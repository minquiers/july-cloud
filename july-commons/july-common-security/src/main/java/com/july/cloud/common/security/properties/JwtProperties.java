package com.july.cloud.common.security.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "july.jwt")
public class JwtProperties {
    /**
     * 令牌前缀
     */
    private String prefix = "Bearer ";
    /**
     * 令牌自定义标识
     */
    private String authentication = "Authorization";
    /**
     * 令牌密钥
     */
    private String secret = "1234567890123";
    /**
     * 超时时间
     */
    private long expiration = 24 * 60 * 60 * 1000;
}
