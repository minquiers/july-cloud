package com.july.cloud.auth.service;

import com.july.cloud.auth.dto.LoginBodyDTO;
import com.july.cloud.common.security.model.LoginUser;

import java.util.Map;

public interface ILoginService {

    /**
     * 登陆
     * @param form
     * @return
     */
    Map<String,Object> login(LoginBodyDTO form);
}
