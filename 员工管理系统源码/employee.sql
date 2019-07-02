/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 80011
Source Host           : 127.0.0.1:3306
Source Database       : employee

Target Server Type    : MYSQL
Target Server Version : 80011
File Encoding         : 65001

Date: 2019-07-02 16:23:33
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for department
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department` (
  `did` int(11) NOT NULL AUTO_INCREMENT,
  `dname` varchar(20) DEFAULT NULL,
  `ddesc` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`did`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of department
-- ----------------------------
INSERT INTO `department` VALUES ('1', 'ssh框架部', '学习慕课视频');
INSERT INTO `department` VALUES ('3', '文案处', '写文档');
INSERT INTO `department` VALUES ('5', '后台代码', '学习ssh框架');
INSERT INTO `department` VALUES ('7', '人力资源部', '招聘');
INSERT INTO `department` VALUES ('8', '外交部', '与别人交流');
INSERT INTO `department` VALUES ('9', '设计部', '界面');
INSERT INTO `department` VALUES ('10', '修理部', '变废为宝');
INSERT INTO `department` VALUES ('11', '文娱部', '能歌善舞');

-- ----------------------------
-- Table structure for employee
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee` (
  `eid` int(11) NOT NULL AUTO_INCREMENT,
  `ename` varchar(20) DEFAULT NULL,
  `sex` varchar(20) DEFAULT NULL,
  `birthday` datetime DEFAULT NULL,
  `joinDate` datetime DEFAULT NULL,
  `eno` varchar(20) DEFAULT NULL,
  `username` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `dno` int(11) DEFAULT NULL,
  PRIMARY KEY (`eid`),
  KEY `FKliyqiooso8ar5j2n18pry22p2` (`dno`),
  CONSTRAINT `FKliyqiooso8ar5j2n18pry22p2` FOREIGN KEY (`dno`) REFERENCES `department` (`did`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of employee
-- ----------------------------
INSERT INTO `employee` VALUES ('1', '乔露露', '女', '2015-11-18 16:00:00', '2018-01-15 16:00:00', '20163561', '小小桥', '123456', '1');
INSERT INTO `employee` VALUES ('3', '方琦', '男', '1998-01-16 00:00:00', '2018-01-16 00:00:00', '20163588', '小小琦', '123456', '3');
INSERT INTO `employee` VALUES ('4', '梁乃升', '女', '2000-02-15 16:00:00', '2018-01-15 16:00:00', '20173522', '小小李', 'asdf', '9');
INSERT INTO `employee` VALUES ('5', '张润东', '男', '2000-03-05 00:00:00', '2018-01-16 00:00:00', '20173544', '小东', 'zxcv', '1');
INSERT INTO `employee` VALUES ('6', '李伟', '男', '2018-11-05 16:00:00', '2018-11-04 16:00:00', '20173527', 'fear个', '123456', '5');
INSERT INTO `employee` VALUES ('7', '铁头', '男', '2018-11-04 16:00:00', '2018-11-11 16:00:00', '20173542', '徐志权', 'qazx', '3');
INSERT INTO `employee` VALUES ('8', '段家兴', '男', '2016-10-13 00:00:00', '2018-10-10 00:00:00', '20173544', '小泡', 'huji', '3');
