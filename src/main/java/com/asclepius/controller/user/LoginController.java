package com.asclepius.controller.user;

import com.asclepius.common.ResponseCode;
import com.asclepius.pojo.R;
import com.asclepius.pojo.User;
import com.asclepius.service.LoginService;
import com.asclepius.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * LoginController
 *
 * @author luolinyuan
 * @date 2022/6/27
 **/
@RequestMapping("/api/login")
@RestController
public class LoginController {
	private LoginService loginService;

	@Autowired
	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}

	@Resource
	UserService userService;

	@GetMapping("/{code}")
	public R login(@PathVariable("code") String code) {
		R result = new R();
		String openID;
		if ((openID = loginService.verify(code)) != null) {
			result.setMessage(openID);
			User user = new User();
			user.setAccountId(openID);
			userService.createOrUpdate(user);

			// 添加token

		} else {
			result.setCode(ResponseCode.UNPROCESSABLE_ENTITY);
		}
		System.out.println(openID);
		return result;
	}
}
