package com.asclepius.common;

/**
 * ResponseCode
 *
 * @author luolinyuan
 * @date 2022/6/27
 **/
public interface ResponseCode {
	int OK = 200;
	int UNDETERMINED = 201;
	int CREATED = 202;
	int DELETED = 204;
	int BAD_REQUEST = 400;
	int UNAUTHORIZED = 401;
	int FORBIDDEN = 403;
	int NOT_FOUND = 404;
	int UNPROCESSABLE_ENTITY = 422;
	int INTERNAL_SERVER_ERROR = 500;
}
