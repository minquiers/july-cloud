package com.july.cloud.common.security.constants;

/**
 * 权限相关通用常量
 */
public interface SecurityConstants {
    /**
     * 用户ID字段
     */
    String DETAILS_USER_ID = "user_id";

    /**
     * 用户名字段
     */
    String DETAILS_USERNAME = "username";

    /**
     * 用户角色
     */
    String DETAILS_USER_ROLE = "user_role";

    /**
     * 权限范围
     */
    String SCP = "scp";

    /**
     * 到期
     */
    String EXPIRATION = "expiration";

    /**
     * 授权信息字段
     */
    String AUTHORIZATION_HEADER = "Authorization";

    String PREFIX = "Base64 ";

    String LOGIN_TOKEN_KEY = "login:";

    /**
     * 请求来源
     */
    String FROM_SOURCE = "from-source";

    /**
     * 内部请求
     */
    String INNER = "inner";

    /**
     * 用户标识
     */
    String USER_KEY = "user_key";

    /**
     * 登录用户
     */
    String LOGIN_USER = "login_user";
}
