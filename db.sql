/*
 Navicat Premium Data Transfer

 Source Server         : dba
 Source Server Type    : MySQL
 Source Server Version : 50649
 Source Host           : localhost:3306
 Source Schema         : mbtest

 Target Server Type    : MySQL
 Target Server Version : 50649
 File Encoding         : 65001

 Date: 19/08/2020 17:19:30
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for address
-- ----------------------------
DROP TABLE IF EXISTS `address`;
CREATE TABLE `address` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '送货地址ID',
  `customer_address_id` bigint(255) DEFAULT NULL COMMENT '客户id',
  `province` varchar(20) DEFAULT NULL COMMENT '省 ',
  `city` varchar(50) DEFAULT NULL COMMENT '市',
  `area` varchar(50) DEFAULT NULL COMMENT '区',
  `info` varchar(255) DEFAULT NULL COMMENT '详细地址 不包括省市区',
  `bak` varchar(255) DEFAULT NULL COMMENT '地址信息备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for customer
-- ----------------------------
DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '客户id',
  `name` varchar(50) DEFAULT NULL COMMENT '客户姓名',
  `sex` varchar(5) DEFAULT NULL COMMENT '客户性别 0:女 1:男',
  `phone_num` varchar(11) DEFAULT NULL COMMENT '客户手机号',
  `phone_num_bak` varchar(11) DEFAULT NULL COMMENT '备用手机号',
  `care_id` varchar(32) DEFAULT NULL COMMENT '身份证号码',
  `address` varchar(110) DEFAULT '0' COMMENT '客户家庭住址',
  `level` varchar(50) DEFAULT NULL COMMENT '客户级别',
  `bak_info` varchar(255) DEFAULT NULL COMMENT '客户个人备注信息',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1296011942820892674 DEFAULT CHARSET=utf8;

SET FOREIGN_KEY_CHECKS = 1;
