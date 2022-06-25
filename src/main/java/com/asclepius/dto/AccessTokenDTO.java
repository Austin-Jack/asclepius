package com.asclepius.dto;

import lombok.Data;

//向GitHub拿令牌信息对象类
@Data //简化set和get方法
public class AccessTokenDTO {

    private String client_id;

    private String client_secret;

    private String code;

    private String redirect_uri;

    private String state;
}
