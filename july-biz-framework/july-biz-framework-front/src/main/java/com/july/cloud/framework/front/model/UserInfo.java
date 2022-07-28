package com.july.cloud.framework.front.model;

import lombok.Data;

import java.util.Set;

@Data
public class UserInfo {
    private String id;
    private String username;
    private String password;
    private String lockFlag;
    private Set<String> roles;
    private Set<String> permissions;
}
