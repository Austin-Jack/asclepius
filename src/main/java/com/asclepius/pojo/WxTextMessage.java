package com.asclepius.pojo;

/**
 * WxTextMessage
 *
 * @author luolinyuan
 * @date 2022/6/26
 **/

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;

@Data
@JacksonXmlRootElement(localName = "xml")
public class WxTextMessage {

	public final static String RECEIVE_EVENT = "event";
	public final static String EVENT_SUBSCRIBE = "subscribe";
	public final static String RESP_TYPE = "text";
	public final static String EXCEPT_RECEIVE = "验证码";

	@JacksonXmlProperty(localName = "ToUserName")
	private String ToUserName;

	@JacksonXmlProperty(localName = "FromUserName")
	private String FromUserName;

	@JacksonXmlProperty(localName = "CreateTime")
	private Long CreateTime;

	@JacksonXmlProperty(localName = "MsgType")
	private String MsgType;

	@JacksonXmlProperty(localName = "Content")
	private String Content;

	@JacksonXmlProperty(localName = "Event")
	private String event;

	public String toString() {
		String str = "<xml><ToUserName>" +
				this.getToUserName() +
				"</ToUserName><FromUserName>" +
				this.getFromUserName() +
				"</FromUserName>" +
				"<CreateTime>" +
				this.getCreateTime() +
				"</CreateTime><MsgType>text</MsgType><Content>" +
				this.getContent() +
				"</Content></xml>";
		return str;
	}
}
