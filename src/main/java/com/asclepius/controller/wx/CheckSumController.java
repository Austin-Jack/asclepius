package com.asclepius.controller.wx;

import com.asclepius.utils.CheckUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.PrintWriter;


/**
 * wx校验controller 绑定完成后路径由其他Controller使用
 *
 * @author luolinyuan
 * @date 2022/6/26
 **/
@Deprecated
//@Controller("/wx")
public class CheckSumController {
	/**
	 * 验证微信服务器
	 *
	 * @param signature
	 * @param timestamp
	 * @param nonce
	 * @param echostr
	 */
	@RequestMapping(value = "/check", method = RequestMethod.GET)
	public void wechatService(PrintWriter out,
	                          @RequestParam(value = "signature", required = false) String signature,
	                          @RequestParam String timestamp,
	                          @RequestParam String nonce, @RequestParam String echostr) {
		if (CheckUtil.checkSignature(signature, timestamp, nonce)) {
			System.out.println("get some request");
			out.print(echostr);
		}
	}
}
