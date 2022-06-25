package com.asclepius.controller;

import com.asclepius.dto.AccessTokenDTO;
import com.asclepius.dto.GitHubUser;
import com.asclepius.model.User;
import com.asclepius.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

@Controller
public class AuthorizeController {

    @Resource
    private GithubProvider githubProvider;

    @Value("${github.client.id}")
    private String clientId;

    @Value("${github.client.secret}")
    private String clientSecret;

    @Value("${github.redirect.uri}")
    private String clientUri;

    //当完成github的认证后跳转到里进行处理
    @GetMapping("/callback")
    /**
     * @code :用户接受授权后由github提供code，这里接受其提供的code参数用来为POST https://github.com/login/oauth/access_token换取访问令牌
     * @state :为我们在上一步提供的状态
     */
    public String callback(@RequestParam(name = "code") String code,
                           @RequestParam(name = "state")  String state,
                           HttpServletRequest request,
                           HttpServletResponse response, Model model){
        //将我们要获得访问令牌所需提供的参数放到我们封装的对象中去
        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setClient_id(clientId);
        accessTokenDTO.setClient_secret(clientSecret);
        accessTokenDTO.setCode(code);
        accessTokenDTO.setRedirect_uri(clientUri);
        accessTokenDTO.setState(state);
        //调用我们用来获得访问令牌所提供的方法
        String accessToken = githubProvider.getAccessToken(accessTokenDTO);
        //拿我们获得的github令牌取获取用户在github的信息
        GitHubUser gitHubUser = githubProvider.getUser(accessToken);
        //判断，如果成功获得GitHubUser
        if(gitHubUser != null && gitHubUser.getId() != null){
            //将获得的GitHub用户信息对象注入到我们自己网站的User信息对象中
            User user = new User();
            //写我们自己的一个token，用来判断用户是否已经登陆我们自己的网站
            String token = UUID.randomUUID().toString();
            user.setToken(token);
            user.setName(gitHubUser.getName());
            user.setAccountId(String.valueOf(gitHubUser.getId()));
            user.setAvatarUrl(gitHubUser.getAvatar_url());
            //将用户信息写到数据库
//            userService.createOrUpdate(user);
            System.out.println(token);
            System.out.println(gitHubUser.getName());
            //登陆成功，将token写到用户浏览器的cookie中，以便用户下次访问
            response.addCookie(new Cookie("token", token));
            model.addAttribute("msg", "登录成功");
            return "redirect:/";
        } else {
//            log.error("callback get github error,{}",gitHubUser);
            //登陆失败，重新登陆
            return "redirect:/";
        }
    }

}
