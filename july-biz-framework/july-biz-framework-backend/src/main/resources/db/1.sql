-- ----------------------------
-- 1、字典类型表
-- ----------------------------
drop table if exists sys_dict_type;
create table sys_dict_type
(
    id          varchar(36)      not null    comment '字典主键',
    dict_name        varchar(100)    default ''                 comment '字典名称',
    dict_type        varchar(100)    default ''                 comment '字典类型',
    is_deleted           char(1)         default '0'                comment '是否删除（0正常 1删除,null删除）',
    create_by        varchar(64)     default ''                 comment '创建者',
    create_at      datetime                                   comment '创建时间',
    update_by        varchar(64)     default ''                 comment '更新者',
    update_at      datetime                                   comment '更新时间',
    remark           varchar(500)    default null               comment '备注',
    primary key (id),
    unique (dict_type)
) engine=innodb auto_increment=100 comment = '字典类型表';

insert into sys_dict_type values('1',  '用户性别', 'sys_user_sex',        '0', 'admin', sysdate(), '', null, '用户性别列表');
insert into sys_dict_type values('2',  '菜单状态', 'sys_show_hide',       '0', 'admin', sysdate(), '', null, '菜单状态列表');
insert into sys_dict_type values('3',  '系统开关', 'sys_normal_disable',  '0', 'admin', sysdate(), '', null, '系统开关列表');
insert into sys_dict_type values('4',  '任务状态', 'sys_job_status',      '0', 'admin', sysdate(), '', null, '任务状态列表');
insert into sys_dict_type values('5',  '任务分组', 'sys_job_group',       '0', 'admin', sysdate(), '', null, '任务分组列表');
insert into sys_dict_type values('6',  '系统是否', 'sys_yes_no',          '0', 'admin', sysdate(), '', null, '系统是否列表');
insert into sys_dict_type values('7',  '通知类型', 'sys_notice_type',     '0', 'admin', sysdate(), '', null, '通知类型列表');
insert into sys_dict_type values('8',  '通知状态', 'sys_notice_status',   '0', 'admin', sysdate(), '', null, '通知状态列表');
insert into sys_dict_type values('9',  '操作类型', 'sys_oper_type',       '0', 'admin', sysdate(), '', null, '操作类型列表');
insert into sys_dict_type values('10', '系统状态', 'sys_common_status',   '0', 'admin', sysdate(), '', null, '登录状态列表');

-- ----------------------------
-- 2、字典数据表
-- ----------------------------
drop table if exists sys_dict_data;
create table sys_dict_data
(
    id        varchar(36)      not null     comment '字典编码',
    dict_sort        int(4)          default 0                  comment '字典排序',
    dict_label       varchar(100)    default ''                 comment '字典标签',
    dict_value       varchar(100)    default ''                 comment '字典键值',
    dict_type        varchar(100)    default ''                 comment '字典类型',
    is_deleted           char(1)         default '0'                comment '是否删除（0正常 1删除,null删除）',
    create_by        varchar(64)     default ''                 comment '创建者',
    create_at      datetime                                   comment '创建时间',
    update_by        varchar(64)     default ''                 comment '更新者',
    update_at      datetime                                   comment '更新时间',
    remark           varchar(500)    default null               comment '备注',
    primary key (id)
) engine=innodb auto_increment=100 comment = '字典数据表';
insert into sys_dict_data values(1,  1,  '男',       '0',       'sys_user_sex',         '0', 'admin', sysdate(), '', null, '性别男');
insert into sys_dict_data values(2,  2,  '女',       '1',       'sys_user_sex',         '0', 'admin', sysdate(), '', null, '性别女');
insert into sys_dict_data values(3,  3,  '未知',     '2',       'sys_user_sex',         '0', 'admin', sysdate(), '', null, '性别未知');
insert into sys_dict_data values(4,  1,  '显示',     '0',       'sys_show_hide',        '0', 'admin', sysdate(), '', null, '显示菜单');
insert into sys_dict_data values(5,  2,  '隐藏',     '1',       'sys_show_hide',        '0', 'admin', sysdate(), '', null, '隐藏菜单');
insert into sys_dict_data values(6,  1,  '正常',     '0',       'sys_normal_disable',   '0', 'admin', sysdate(), '', null, '正常状态');
insert into sys_dict_data values(7,  2,  '停用',     '1',       'sys_normal_disable',   '0', 'admin', sysdate(), '', null, '停用状态');
insert into sys_dict_data values(8,  1,  '正常',     '0',       'sys_job_status',       '0', 'admin', sysdate(), '', null, '正常状态');
insert into sys_dict_data values(9,  2,  '暂停',     '1',       'sys_job_status',       '0', 'admin', sysdate(), '', null, '停用状态');
insert into sys_dict_data values(10, 1,  '默认',     'DEFAULT', 'sys_job_group',        '0', 'admin', sysdate(), '', null, '默认分组');
insert into sys_dict_data values(11, 2,  '系统',     'SYSTEM',  'sys_job_group',        '0', 'admin', sysdate(), '', null, '系统分组');
insert into sys_dict_data values(12, 1,  '是',       'Y',       'sys_yes_no',           '0', 'admin', sysdate(), '', null, '系统默认是');
insert into sys_dict_data values(13, 2,  '否',       'N',       'sys_yes_no',           '0', 'admin', sysdate(), '', null, '系统默认否');
insert into sys_dict_data values(14, 1,  '通知',     '1',       'sys_notice_type',      '0', 'admin', sysdate(), '', null, '通知');
insert into sys_dict_data values(15, 2,  '公告',     '2',       'sys_notice_type',      '0', 'admin', sysdate(), '', null, '公告');
insert into sys_dict_data values(16, 1,  '正常',     '0',       'sys_notice_status',    '0', 'admin', sysdate(), '', null, '正常状态');
insert into sys_dict_data values(17, 2,  '关闭',     '1',       'sys_notice_status',    '0', 'admin', sysdate(), '', null, '关闭状态');
insert into sys_dict_data values(18, 1,  '新增',     '1',       'sys_oper_type',        '0', 'admin', sysdate(), '', null, '新增操作');
insert into sys_dict_data values(19, 2,  '修改',     '2',       'sys_oper_type',        '0', 'admin', sysdate(), '', null, '修改操作');
insert into sys_dict_data values(20, 3,  '删除',     '3',       'sys_oper_type',        '0', 'admin', sysdate(), '', null, '删除操作');
insert into sys_dict_data values(21, 4,  '授权',     '4',       'sys_oper_type',        '0', 'admin', sysdate(), '', null, '授权操作');
insert into sys_dict_data values(22, 5,  '导出',     '5',       'sys_oper_type',        '0', 'admin', sysdate(), '', null, '导出操作');
insert into sys_dict_data values(23, 6,  '导入',     '6',       'sys_oper_type',        '0', 'admin', sysdate(), '', null, '导入操作');
insert into sys_dict_data values(24, 7,  '强退',     '7',       'sys_oper_type',        '0', 'admin', sysdate(), '', null, '强退操作');
insert into sys_dict_data values(25, 8,  '生成代码', '8',       'sys_oper_type',        '0', 'admin', sysdate(), '', null, '生成操作');
insert into sys_dict_data values(26, 9,  '清空数据', '9',       'sys_oper_type',        '0', 'admin', sysdate(), '', null, '清空操作');
insert into sys_dict_data values(27, 1,  '成功',     '0',       'sys_common_status',    '0', 'admin', sysdate(), '', null, '正常状态');
insert into sys_dict_data values(28, 2,  '失败',     '1',       'sys_common_status',    '0', 'admin', sysdate(), '', null, '停用状态');

-- ----------------------------
-- 3.Table structure for sys_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_log`;
CREATE TABLE `sys_log` (
                           `id` varchar(36) NOT NULL,
                           `type` char(1) COLLATE utf8_general_ci DEFAULT '1' COMMENT '日志类型',
                           `title` varchar(255) COLLATE utf8_general_ci DEFAULT '' COMMENT '日志标题',
                           `service_id` varchar(32) COLLATE utf8_general_ci DEFAULT NULL COMMENT '服务ID',
                           `remote_addr` varchar(255) COLLATE utf8_general_ci DEFAULT NULL COMMENT '操作IP地址',
                           `user_agent` varchar(1000) COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户代理',
                           `request_uri` varchar(255) COLLATE utf8_general_ci DEFAULT NULL COMMENT '请求URI',
                           `method` varchar(10) COLLATE utf8_general_ci DEFAULT NULL COMMENT '操作方式',
                           `params` text COLLATE utf8_general_ci COMMENT '操作提交的数据',
                           `time` bigint DEFAULT NULL COMMENT '执行时间',
                           `exception` text COLLATE utf8_general_ci COMMENT '异常信息',
                           `is_deleted` char(1) COLLATE utf8_general_ci DEFAULT '0' COMMENT '是否删除（0正常 1删除,null删除）',
                           `create_by` varchar(64) COLLATE utf8_general_ci DEFAULT NULL COMMENT '创建人',
                           `create_at` datetime DEFAULT NULL COMMENT '创建时间',
                           `update_at` datetime DEFAULT NULL COMMENT '更新时间',
                           `update_by` varchar(64) COLLATE utf8_general_ci DEFAULT NULL COMMENT '更新人',
                           PRIMARY KEY (`id`),
                           KEY `sys_log_create_by` (`create_by`),
                           KEY `sys_log_request_uri` (`request_uri`),
                           KEY `sys_log_type` (`type`),
                           KEY `sys_log_create_date` (`create_at`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci ROW_FORMAT=DYNAMIC COMMENT='日志表';