package com.asclepius.controller;

import com.asclepius.common.ResponseCode;
import com.asclepius.dto.ResultDTO;
import com.asclepius.pojo.User;
import com.asclepius.service.LoginService;
import com.asclepius.service.UserService;
import com.asclepius.utils.GenToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;

/**
 * LoginController
 *
 * @author luolinyuan
 * @date 2022/6/27
 **/
@RequestMapping(value = "/api/login")
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
	public ResultDTO login(@PathVariable("code") String code) {
		ResultDTO result = new ResultDTO();
		String openID;
		if ((openID = loginService.verify(code)) != null) {
			result.setMessage(openID);
			User user = new User();
			user.setAccountId(openID);
			int uId = userService.createOrUpdate(user);
			// 添加token
			HashMap<String, String> map = new HashMap<>();
			map.put("token", GenToken.sign(openID, uId));
			map.put("uId", String.valueOf(uId));
			result.setData(map);
		} else {
			result.setCode(ResponseCode.UNPROCESSABLE_ENTITY);
		}
		return result;
	}

	@GetMapping("/validity/{token}")
	public ResultDTO validity(@PathVariable String token) {
		ResultDTO resultDTO = new ResultDTO();
		if (!GenToken.verify(token)) {
			resultDTO.setData(ResponseCode.FORBIDDEN);
		}
		return resultDTO;
	}
}
