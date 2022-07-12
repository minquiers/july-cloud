package com.july.cloud.auth.controller;


import com.july.cloud.auth.dto.LoginBodyDTO;
import com.july.cloud.auth.service.ILoginService;
import com.july.cloud.common.core.domain.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TokenController {

    @Autowired
    private ILoginService loginService;

    @PostMapping("login")
    public R<?> login(@RequestBody LoginBodyDTO form) {
        return R.ok(loginService.login(form));
    }

    /*@DeleteMapping("logout")
    public R<?> logout(HttpServletRequest request) {
        String token = SecurityUtils.getToken(request);
        if (StringUtils.isNotEmpty(token)) {
            String username = JwtUtils.getUserName(token);
            // 删除用户缓存记录
            AuthUtil.logoutByToken(token);
            // 记录用户退出日志
            sysLoginService.logout(username);
        }
        return R.ok();
    }*/

}
