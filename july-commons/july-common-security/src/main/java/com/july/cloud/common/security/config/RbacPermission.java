package com.july.cloud.common.security.config;

import cn.hutool.core.collection.CollectionUtil;
import com.july.cloud.common.security.model.LoginUser;
import org.springframework.security.core.Authentication;
import org.springframework.util.AntPathMatcher;

import javax.servlet.http.HttpServletRequest;
import java.util.Set;

public class RbacPermission {
    private AntPathMatcher antPathMatcher = new AntPathMatcher();

    public boolean hasPermission(HttpServletRequest request, Authentication authentication) {
        Object principal = authentication.getPrincipal();
        boolean hasPermission = false;
        if (principal instanceof LoginUser) {
            // 读取用户所拥有的权限菜单
            Set<String> permissions = ((LoginUser) principal).getPermissions();
            if(CollectionUtil.isNotEmpty(permissions) && permissions.contains("x")){
                return true;
            }
            /*for (String menu : menus) {
                if (antPathMatcher.match(menu, request.getRequestURI())) {
                    hasPermission = true;
                    break;
                }
            }*/
        }
        return hasPermission;
    }
}
