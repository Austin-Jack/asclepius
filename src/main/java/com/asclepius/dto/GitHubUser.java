package com.asclepius.dto;

import lombok.Data;

//GitHub返回的用户信息对象类
@Data //简化get和set方法
public class GitHubUser {
    private String name;
    private Long id;
    private String bio;
    private String avatar_url;
}
