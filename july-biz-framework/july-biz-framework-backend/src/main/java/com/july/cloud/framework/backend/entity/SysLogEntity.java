package com.july.cloud.framework.backend.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.july.cloud.mybatisplus.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 日志表
 * @TableName sys_log
 */
@TableName(value ="sys_log")
@Data
@EqualsAndHashCode(callSuper = true)
public class SysLogEntity extends BaseEntity {
    /**
     * 日志类型
     */
    @TableField(value = "type")
    private String type;

    /**
     * 日志标题
     */
    @TableField(value = "title")
    private String title;

    /**
     * 服务ID
     */
    @TableField(value = "service_id")
    private String serviceId;

    /**
     * 操作IP地址
     */
    @TableField(value = "remote_addr")
    private String remoteAddr;

    /**
     * 用户代理
     */
    @TableField(value = "user_agent")
    private String userAgent;

    /**
     * 请求URI
     */
    @TableField(value = "request_uri")
    private String requestUri;

    /**
     * 操作方式
     */
    @TableField(value = "method")
    private String method;

    /**
     * 操作提交的数据
     */
    @TableField(value = "params")
    private String params;

    /**
     * 执行时间
     */
    @TableField(value = "time")
    private Long time;

    /**
     * 异常信息
     */
    @TableField(value = "exception")
    private String exception;
}