package com.july.cloud.common.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * 密码加密
     * @return
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    /**
     * 静态资源设置
     */
    @Override
    public void configure(WebSecurity webSecurity) {
        //不拦截静态资源,所有用户均可访问的资源
        webSecurity.ignoring().antMatchers(
                "/",
                "/css/**",
                "/js/**",
                "/images/**",
                "/layui/**"
        );
    }


    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.csrf().disable(); //注释就是使用 csrf 功能
        http.headers().frameOptions().disable();//解决 in a frame because it set 'X-Frame-Options' to 'DENY' 问题
        //http.anonymous().disable();
        http.authorizeRequests()
                .antMatchers("/login/**", "/initUserData")//不拦截登录相关方法
                .permitAll()
                //.antMatchers("/user").hasRole("ADMIN")  // user接口只有ADMIN角色的可以访问
//            .anyRequest()
//            .authenticated()// 任何尚未匹配的URL只需要验证用户即可访问
                .anyRequest()
                .access("@rbacPermission.hasPermission(request, authentication)")//根据账号权限访问
                .and()
                .formLogin()
                .loginPage("/")
                .loginPage("/login")   //登录请求页
                .loginProcessingUrl("/login")  //登录POST请求路径
                .usernameParameter("username") //登录用户名参数
                .passwordParameter("password") //登录密码参数
                .defaultSuccessUrl("/main")   //默认登录成功页面
                .and()
                .exceptionHandling()
                .accessDeniedHandler(customAccessDeniedHandler()) //无权限处理器
                .and()
                .logout()
                .logoutSuccessUrl("/login?logout");  //退出登录成功URL

    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    /**
     * 权限验证
     * @return
     */
    @Bean("rbacPermission")
    public RbacPermission rbacPermission() {
        return new RbacPermission();
    }

    /**
     * 无权限处理器
     * @return
     */
    @Bean("customAccessDeniedHandler")
    public CustomAccessDeniedHandler customAccessDeniedHandler() {
        return new CustomAccessDeniedHandler();
    }
}

