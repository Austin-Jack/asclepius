package com.asclepius.controller.interceptor;


import cn.hutool.json.JSONObject;
import com.asclepius.common.ResponseCode;
import com.asclepius.utils.GenToken;
import org.springframework.http.HttpHeaders;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * AccessTokenInterceptor
 *
 * @author luolinyuan
 * @date 2022/7/1
 **/
public class AccessTokenInterceptor implements HandlerInterceptor {
	@Override
	public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
		String accessToken = httpServletRequest.getHeader(HttpHeaders.AUTHORIZATION);
		if (!StringUtils.hasLength(accessToken) || !GenToken.verify(accessToken)) {
			return extracted(httpServletResponse);
		}
		return true;
	}

	private boolean extracted(HttpServletResponse httpServletResponse) throws IOException {
		PrintWriter out;
		try {
			httpServletResponse.setCharacterEncoding("UTF-8");
			httpServletResponse.setContentType("application/json; charset=utf-8");
			out = httpServletResponse.getWriter();
			JSONObject o = new JSONObject();
			o.set("code", ResponseCode.FORBIDDEN);
			o.set("message", "");
			o.set("data", null);
			out.println(o.toStringPretty());
		} catch (Exception ignored) {
		}
		return false;
	}
}


