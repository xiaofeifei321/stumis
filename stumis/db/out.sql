/*
Navicat MySQL Data Transfer

Source Server         : 阿里云
Source Server Version : 50722
Source Host           : 47.100.200.237:3306
Source Database       : out

Target Server Type    : MYSQL
Target Server Version : 50722
File Encoding         : 65001

Date: 2018-10-21 22:03:41
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `ball`
-- ----------------------------
DROP TABLE IF EXISTS `ball`;
CREATE TABLE `ball` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `rank` int(11) DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL,
  `price` int(11) DEFAULT NULL,
  `shoot` int(100) DEFAULT NULL,
  `technology` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ball
-- ----------------------------
INSERT INTO `ball` VALUES ('3', '66', 'jaryy', '100', '99', '100');
INSERT INTO `ball` VALUES ('5', '100', 'eric', '100', '100', '100');

-- ----------------------------
-- Table structure for `book`
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `id` int(100) NOT NULL AUTO_INCREMENT,
  `isbn` varchar(100) DEFAULT NULL,
  `bookName` varchar(100) DEFAULT NULL,
  `author` varchar(100) DEFAULT NULL,
  `price` int(100) DEFAULT NULL,
  `publishPress` varchar(100) DEFAULT NULL,
  KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=432 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES ('421', '1', '安徒生不后悔', '安徒生', '100', '大河');
INSERT INTO `book` VALUES ('431', '6', 'java', '图灵', '20', '教育');

-- ----------------------------
-- Table structure for `staff`
-- ----------------------------
DROP TABLE IF EXISTS `staff`;
CREATE TABLE `staff` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `seniority` int(11) DEFAULT NULL,
  `education` varchar(100) DEFAULT NULL,
  `reward` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of staff
-- ----------------------------
INSERT INTO `staff` VALUES ('1', '1', '1', '1', '1', '1');
INSERT INTO `staff` VALUES ('2', '2', '2', '2', '2', '2');
INSERT INTO `staff` VALUES ('3', '3', '3', '3', '3', '3');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) DEFAULT NULL,
  `userpass` varchar(20) DEFAULT NULL,
  KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '2015', '123456');
INSERT INTO `user` VALUES ('2', '1', '1');

-- ----------------------------
-- Table structure for `userdetail`
-- ----------------------------
DROP TABLE IF EXISTS `userdetail`;
CREATE TABLE `userdetail` (
  `username` varchar(20) NOT NULL,
  `userpass` varchar(20) NOT NULL,
  `role` int(4) DEFAULT '0',
  `regtime` datetime DEFAULT NULL,
  `lognum` int(11) DEFAULT '0',
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of userdetail
-- ----------------------------
INSERT INTO `userdetail` VALUES ('admin', '123456', '1', '2010-02-25 01:22:03', '5');
INSERT INTO `userdetail` VALUES ('dingcq', 'dingcq', '1', '2010-02-25 02:20:07', '0');
INSERT INTO `userdetail` VALUES ('tangpp', '123456', '1', '2010-02-25 02:21:03', '1');
INSERT INTO `userdetail` VALUES ('user1', 'user1', '1', '2010-02-25 02:22:50', '1');
INSERT INTO `userdetail` VALUES ('wangwu', 'wangwu', '1', '2010-02-25 02:23:43', '0');
INSERT INTO `userdetail` VALUES ('zhangsan', 'zhangsan', '0', '2010-02-25 12:20:39', '0');
INSERT INTO `userdetail` VALUES ('zkl', '123456', '0', '2010-02-25 09:31:44', '8');
