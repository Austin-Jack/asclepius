package com.asclepius.controller.wx;

import com.asclepius.pojo.WxTextMessage;
import com.asclepius.service.WxMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Date;


/**
 * 接收消息
 *
 * @author luolinyuan
 * @date 2022/6/26
 **/
@RestController
@RequestMapping("/wx")
public class ReceiveMessageController {


	@Autowired
	@Qualifier("wxMessageServiceImpl")
	WxMessageService wxMessageService;

	@PostMapping(value = "/check", consumes = "text/xml", produces = "text/xml;charset=utf-8")
	public String messageHandle(@RequestBody WxTextMessage received) {
		WxTextMessage resultMessage = new WxTextMessage();
		resultMessage.setToUserName(received.getFromUserName());
		resultMessage.setFromUserName(received.getToUserName());
		resultMessage.setCreateTime(new Date().getTime());
		resultMessage.setMsgType(WxTextMessage.RESP_TYPE);

		//收到关注消息
		if (WxTextMessage.RECEIVE_EVENT.equals(received.getMsgType()) && WxTextMessage.EVENT_SUBSCRIBE.equals(received.getEvent())) {
			resultMessage.setContent("回复\"验证码\"获取验证码");
			return resultMessage.toString();
		}
		//收到文本消息
		if (!WxTextMessage.RESP_TYPE.equals(received.getMsgType())) {
			resultMessage.setContent("当前只支持文本消息");
			return resultMessage.toString();
		}
		if (WxTextMessage.EXCEPT_RECEIVE.equals(received.getContent())) {
			return wxMessageService.responseVerifyCode(resultMessage);
		} else {
			/*返回success表示不做处理*/
			return "success";
		}
	}

}
