package com.july.cloud.common.security.util;

import com.july.cloud.common.security.constants.SecurityConstants;
import com.july.cloud.common.security.properties.JwtProperties;
import com.july.cloud.core.text.Convert;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Date;
import java.util.Map;

/**
 * Jwt工具类
 */
@EnableConfigurationProperties(JwtProperties.class)
@Data
@Slf4j
@Configuration
public class JwtUtils {

    @Autowired
    private static JwtProperties jwtProperties;

    /**
     * 从数据声明生成令牌
     *
     * @param claims 数据声明
     * @return 令牌
     */
    public static String createToken(Map<String, Object> claims) {
        String token = Jwts.builder().setClaims(claims).signWith(SignatureAlgorithm.HS512, jwtProperties.getSecret()).compact();
        return token;
    }

    /**
     * 从数据声明生成令牌(超时s)
     *
     * @param claims 数据声明
     * @return 令牌
     */
    public static String createExpirationToken(Map<String, Object> claims) {
        String token = Jwts.builder().setClaims(claims).signWith(SignatureAlgorithm.HS512, jwtProperties.getSecret()).setExpiration(new Date(new Date().getTime() + jwtProperties.getExpiration())).compact();
        return token;
    }

    /**
     * 从数据声明生成令牌(超时s)
     *
     * @param claims 数据声明
     * @return 令牌
     */
    public static String createExpirationToken(Map<String, Object> claims , Date expiration) {
        String token = Jwts.builder().setClaims(claims).signWith(SignatureAlgorithm.HS512, jwtProperties.getSecret()).setExpiration(expiration).compact();
        return token;
    }

    /**
     * 从令牌中获取数据声明
     *
     * @param token 令牌
     * @return 数据声明
     */
    public static Claims parseToken(String token) {
        return Jwts.parser().setSigningKey(jwtProperties.getSecret()).parseClaimsJws(token).getBody();
    }

    /**
     * 根据令牌获取用户ID
     *
     * @param token 令牌
     * @return 用户ID
     */
    public static String getUserId(String token) {
        Claims claims = parseToken(token);
        return getValue(claims, SecurityConstants.DETAILS_USER_ID);
    }

    /**
     * 根据身份信息获取用户ID
     *
     * @param claims 身份信息
     * @return 用户ID
     */
    public static String getUserId(Claims claims) {
        return getValue(claims, SecurityConstants.DETAILS_USER_ID);
    }

    /**
     * 根据令牌获取用户名
     *
     * @param token 令牌
     * @return 用户名
     */
    public static String getUserName(String token) {
        Claims claims = parseToken(token);
        return getValue(claims, SecurityConstants.DETAILS_USERNAME);
    }

    /**
     * 根据身份信息获取用户名
     *
     * @param claims 身份信息
     * @return 用户名
     */
    public static String getUserName(Claims claims) {
        return getValue(claims, SecurityConstants.DETAILS_USERNAME);
    }

    /**
     * 根据身份信息获取键值
     *
     * @param claims 身份信息
     * @param key    键
     * @return 值
     */
    public static String getValue(Claims claims, String key) {
        return Convert.toStr(claims.get(key), "");
    }
}
