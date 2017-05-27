/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50621
Source Host           : 127.0.0.1:3306
Source Database       : marathon

Target Server Type    : MYSQL
Target Server Version : 50621
File Encoding         : 65001

Date: 2017-05-27 17:37:24
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for activity_file_resource
-- ----------------------------
DROP TABLE IF EXISTS `activity_file_resource`;
CREATE TABLE `activity_file_resource` (
  `file_resource_id` varchar(36) NOT NULL COMMENT 'id\n',
  `file_resource_type` varchar(1) DEFAULT NULL COMMENT '文件资源类别，0-媒体活动文件',
  `file_resource_url` varchar(128) DEFAULT NULL COMMENT '文件资源URL地址\n',
  `activity_id` varchar(36) DEFAULT NULL COMMENT '文件属主id\n',
  `file_resource_date` datetime DEFAULT NULL COMMENT '文件资源上传时间',
  `file_resource_name` varchar(128) DEFAULT NULL COMMENT '文件资源原名称\n',
  PRIMARY KEY (`file_resource_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='文件资源信息表';

-- ----------------------------
-- Table structure for marathon_info
-- ----------------------------
DROP TABLE IF EXISTS `marathon_info`;
CREATE TABLE `marathon_info` (
  `marathon_uuid` varchar(36) NOT NULL COMMENT '赛事ID',
  `marathon_name` varchar(255) DEFAULT NULL COMMENT '赛事名称',
  `marathon_starttime` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '赛事开始时间',
  `marathon_endtime` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '赛事结束时间',
  `marathon_address` varchar(255) DEFAULT NULL COMMENT '赛事举办详细地址',
  `marathon_creater` varchar(36) NOT NULL COMMENT '创建者',
  `marathon_createtime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `marathon_updater` varchar(36) DEFAULT NULL COMMENT '最后修改者',
  `marathon_updatetime` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  `marathon_deleted` tinyint(4) DEFAULT NULL COMMENT '是否被删除',
  PRIMARY KEY (`marathon_uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='赛事信息表';

-- ----------------------------
-- Table structure for marathon_media_activity
-- ----------------------------
DROP TABLE IF EXISTS `marathon_media_activity`;
CREATE TABLE `marathon_media_activity` (
  `media_activity_uuid` varchar(36) NOT NULL COMMENT '媒体服务活动表',
  `marathon_uuid` varchar(36) NOT NULL COMMENT '属于哪个赛事的活动',
  `media_activity_type` varchar(255) NOT NULL COMMENT '媒体服务活动类型 0:传统媒体 1:新媒体 2:赛事直播 3:视频直播 4:照片服务',
  `media_activity_name` varchar(255) DEFAULT NULL COMMENT '媒体服务活动名称',
  `media_activity_starttime` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '活动开始时间',
  `media_activity_endtime` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `media_activity_director` varchar(36) DEFAULT NULL COMMENT '活动负责人',
  `media_activity_cost` varchar(255) DEFAULT NULL COMMENT '活动预算成本',
  `media_activity_status` varchar(255) DEFAULT NULL COMMENT '活动状态',
  `media_activity_progress` varchar(255) DEFAULT NULL COMMENT '活动进度 百分比',
  `media_activity_creator` varchar(36) DEFAULT NULL COMMENT '活动创建者',
  `media_activity_createtime` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `media_activity_updater` varchar(36) DEFAULT NULL COMMENT '活动最后更新者',
  `media_activity_updatetime` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '活动最后更新时间',
  `media_activity_deleted` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`media_activity_uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='赛事媒体活动表';

-- ----------------------------
-- Table structure for sys_department
-- ----------------------------
DROP TABLE IF EXISTS `sys_department`;
CREATE TABLE `sys_department` (
  `department_id` varchar(36) NOT NULL COMMENT 'id',
  `department_name` varchar(36) NOT NULL COMMENT '部门名称',
  `parent_dep_id` varchar(36) DEFAULT NULL COMMENT '上级部门id',
  `department_update_date` datetime DEFAULT NULL COMMENT '更新日期',
  `dept_order` int(11) DEFAULT NULL COMMENT '部门顺序',
  PRIMARY KEY (`department_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='部门信息表';

-- ----------------------------
-- Table structure for sys_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_permission`;
CREATE TABLE `sys_role_permission` (
  `rp_id` varchar(36) NOT NULL COMMENT ' id',
  `role_id` varchar(36) DEFAULT NULL COMMENT '角色id',
  `permission_id` varchar(36) DEFAULT NULL COMMENT ' 权限id',
  PRIMARY KEY (`rp_id`),
  KEY `permission_id` (`permission_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色权限表';

-- ----------------------------
-- Table structure for sys_t_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_t_menu`;
CREATE TABLE `sys_t_menu` (
  `menu_id` varchar(36) NOT NULL COMMENT ' 菜单id',
  `permission_id` varchar(36) DEFAULT NULL COMMENT '权限id',
  `menu_name` varchar(64) DEFAULT NULL COMMENT '菜单名称',
  `menu_url` varchar(100) DEFAULT NULL COMMENT '菜单URL',
  `menu_class` varchar(64) DEFAULT NULL COMMENT ' 菜单样式',
  `parent_id` varchar(36) DEFAULT NULL COMMENT '父菜单id',
  `display_order` int(11) DEFAULT NULL COMMENT '菜单顺序',
  `menu_status` varchar(1) DEFAULT '1' COMMENT '菜单状态， 是否显示该菜单 0不显示 1显示',
  PRIMARY KEY (`menu_id`),
  KEY `permission_id` (`permission_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='菜单项表';

-- ----------------------------
-- Table structure for sys_t_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_t_role`;
CREATE TABLE `sys_t_role` (
  `role_id` varchar(36) NOT NULL COMMENT '系统内置的5个角色的ID是不能修改的，必须满足一下对应关系\r\n1 上报\r\n2 审核\r\n3 领导\r\n4 发布\r\n5 普通用户',
  `role_name` varchar(36) DEFAULT NULL COMMENT '角色名称',
  `role_desc` varchar(64) DEFAULT NULL COMMENT '角色描述',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色表';

-- ----------------------------
-- Table structure for sys_t_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_t_user`;
CREATE TABLE `sys_t_user` (
  `user_id` varchar(36) NOT NULL,
  `user_account` varchar(20) NOT NULL COMMENT '登录名称',
  `user_name` varchar(255) DEFAULT NULL COMMENT '用户姓名',
  `user_psw` varchar(255) DEFAULT NULL COMMENT '登录密码 MD5',
  `user_gender` varchar(2) DEFAULT NULL,
  `user_age` int(11) DEFAULT NULL COMMENT '用户年龄',
  `mobile_phone` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `dept_id` varchar(36) DEFAULT NULL COMMENT '所属部门',
  `create_dt` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `create_by` varchar(36) DEFAULT NULL,
  `update_dt` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `update_by` varchar(36) DEFAULT NULL,
  `user_status` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `user_id` varchar(36) NOT NULL,
  `role_id` varchar(36) NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户角色关联表\r\n';
