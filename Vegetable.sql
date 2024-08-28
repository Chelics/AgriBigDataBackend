/*
 Navicat Premium Dump SQL

 Source Server         : 本地MySQL
 Source Server Type    : MySQL
 Source Server Version : 50744 (5.7.44)
 Source Host           : localhost:3306
 Source Schema         : vegetable

 Target Server Type    : MySQL
 Target Server Version : 50744 (5.7.44)
 File Encoding         : 65001

 Date: 28/08/2024 08:40:43
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for article
-- ----------------------------
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article`  (
  `id` int(11) NOT NULL COMMENT 'ID',
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '标题',
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '内容',
  `source` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '来源',
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '链接',
  `type` int(11) NULL DEFAULT NULL COMMENT '类型',
  `date` datetime NULL DEFAULT NULL COMMENT '发布日期',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '文章' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for article_prvc
-- ----------------------------
DROP TABLE IF EXISTS `article_prvc`;
CREATE TABLE `article_prvc`  (
  `article_id` int(11) NOT NULL COMMENT '文章id',
  `prvc_id` int(11) NOT NULL COMMENT '省份id',
  PRIMARY KEY (`article_id`, `prvc_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '文章-省份' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for market
-- ----------------------------
DROP TABLE IF EXISTS `market`;
CREATE TABLE `market`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '市场名称',
  `prvc_id` int(11) NULL DEFAULT NULL COMMENT '省份id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '市场表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for price
-- ----------------------------
DROP TABLE IF EXISTS `price`;
CREATE TABLE `price`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `pz_id` int(11) NOT NULL COMMENT '品种id',
  `market_id` int(11) NULL DEFAULT NULL COMMENT '市场id',
  `prvc_id` int(11) NULL DEFAULT NULL COMMENT '省份id',
  `date` date NULL DEFAULT NULL COMMENT '日期',
  `highest` double NULL DEFAULT NULL COMMENT '最高价格',
  `lowest` double NULL DEFAULT NULL COMMENT '最低价格',
  `average` double NULL DEFAULT NULL COMMENT '平均价格',
  `sales_volume` double NULL DEFAULT NULL COMMENT '销量',
  `hb` double NULL DEFAULT NULL COMMENT '环比指数',
  `rise` double NULL DEFAULT NULL COMMENT '升幅',
  `increment` double NULL DEFAULT NULL COMMENT '增长百分点',
  `total` double NULL DEFAULT NULL COMMENT '数据抓取量',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `price_market`(`pz_id`, `market_id`, `date`) USING BTREE COMMENT '市场价格索引',
  UNIQUE INDEX `price_prvc`(`pz_id`, `prvc_id`, `date`) USING BTREE COMMENT '省份价格索引'
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '价格信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for prvc
-- ----------------------------
DROP TABLE IF EXISTS `prvc`;
CREATE TABLE `prvc`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '省份名称',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '省份' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for pz
-- ----------------------------
DROP TABLE IF EXISTS `pz`;
CREATE TABLE `pz`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '品种名称',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '品种表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL COMMENT 'ID',
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `tel` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号',
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '电子邮箱',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `prvc_id` int(11) NULL DEFAULT NULL COMMENT '省份id',
  `verify_code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '验证码',
  `verify_time` datetime NULL DEFAULT NULL COMMENT '验证码发送时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `username`(`user_name`) USING BTREE COMMENT '用户名索引',
  UNIQUE INDEX `tel`(`tel`) USING BTREE COMMENT '手机号索引',
  UNIQUE INDEX `email`(`email`) USING BTREE COMMENT '邮箱索引'
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user_pz
-- ----------------------------
DROP TABLE IF EXISTS `user_pz`;
CREATE TABLE `user_pz`  (
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `pz_id` int(11) NOT NULL COMMENT '品种id',
  PRIMARY KEY (`user_id`, `pz_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户关注' ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
