package com.july.cloud.auth.service.impl;

import com.july.cloud.auth.dto.LoginBodyDTO;
import com.july.cloud.auth.service.ILoginService;
import com.july.cloud.common.security.constants.SecurityConstants;
import com.july.cloud.common.security.model.LoginUser;
import com.july.cloud.common.security.properties.JwtProperties;
import com.july.cloud.common.security.utils.JwtUtils;
import com.july.cloud.core.exception.service.LoginException;
import com.july.cloud.core.utils.StringUtils;
import com.july.cloud.framework.front.RemoteUserService;
import com.july.cloud.redis.cache.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class LoginServiceImpl implements ILoginService {

    @Autowired
    private JwtProperties jwtProperties;

    @Autowired
    private RemoteUserService remoteUserService;
    @Autowired
    private RedisUtil redisUtil;
    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public Map<String, Object> login(LoginBodyDTO form) {

        String username = form.getUsername();
        if (StringUtils.isBlank(username) && (StringUtils.isNotBlank(form.getEmail()) || StringUtils.isNotBlank(form.getPhone()))) {
            username = remoteUserService.findUsername(form.getEmail(), form.getPhone()).getData();
        }

        if (StringUtils.isBlank(username)) {
            throw new LoginException("用户不存在");
        }

        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username, form.getPassword());
        Authentication authenticate = authenticationManager.authenticate(authenticationToken);
        if (null == authenticate) {
            throw new RuntimeException("用户名或密码错误");
        }

        LoginUser loginUser = (LoginUser) authenticate.getPrincipal();
        Map<String, Object> claims = new HashMap<>();
        claims.put(SecurityConstants.DETAILS_USER_ID, loginUser.getId());
        claims.put(SecurityConstants.DETAILS_USERNAME, loginUser.getUsername());
        String token = JwtUtils.createExpirationToken(claims);
        redisUtil.setEx(SecurityConstants.LOGIN_TOKEN_KEY + loginUser.getId(), loginUser , jwtProperties.getExpiration() / 1000);
        Map<String, Object> result = new HashMap<>();
        result.put("token", token);
        return result;
    }
}
