package com.july.cloud.auth.dto;

import lombok.Data;

/**
 * 用户登录对象
 */
@Data
public class LoginBodyDTO {
    /**
     * 邮箱
     */
    private String email;
    /**
     * 手机
     */
    private String phone;
    /**
     * 用户名
     */
    private String username;

    /**
     * 用户密码
     */
    private String password;

}
