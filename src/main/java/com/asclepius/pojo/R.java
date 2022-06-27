package com.asclepius.pojo;

import com.asclepius.common.ResponseCode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 封装返回数据
 *
 * @author luolinyuan
 * @date 2022/6/27
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class R {
	private int code = ResponseCode.OK;

	private String message = "";

	private Object data;
}
