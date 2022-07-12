package com.july.cloud.auth.service.impl;

import com.july.cloud.common.core.domain.R;
import com.july.cloud.common.security.model.LoginUser;
import com.july.cloud.framework.front.RemoteUserService;
import com.july.cloud.framework.front.model.UserInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private RemoteUserService remoteUserService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        R<UserInfo> r = remoteUserService.findInfoByUsername(username);
        if (null != r && null != r.getData()) {
            UserInfo userInfo = r.getData();
            return new LoginUser(userInfo.getId() , userInfo.getUsername(), userInfo.getPassword(),"9".equals(userInfo.getLockFlag()) , userInfo.getRoles());
        }
        return null;
    }
}
