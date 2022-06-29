/*
Navicat MySQL Data Transfer

Source Server         : asclepius
Source Server Version : 80029
Source Host           : 49.232.196.77:3306
Source Database       : asclepius

Target Server Type    : MYSQL
Target Server Version : 80029
File Encoding         : 65001

Date: 2022-06-29 14:48:08
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for appointment
-- ----------------------------
DROP TABLE IF EXISTS `appointment`;
CREATE TABLE `appointment` (
  `ap_id` int NOT NULL AUTO_INCREMENT COMMENT '本表的主键',
  `c_id` int NOT NULL COMMENT '关联card表的外键',
  `ap_num` int NOT NULL COMMENT '排队号',
  `ap_time` bigint NOT NULL COMMENT '预约时间',
  `doc_name` varchar(100) NOT NULL COMMENT '医生姓名',
  `d_name` varchar(100) NOT NULL COMMENT '门诊名',
  `c_name` varchar(100) NOT NULL COMMENT '诊室名',
  `ap_cost` float NOT NULL COMMENT '预约花费',
  `ap_status` int NOT NULL DEFAULT '0' COMMENT '0表示正在排队，1表示正在就诊，2表示已过号，3表示就诊结束',
  `s_id` int NOT NULL COMMENT '排班表外键',
  PRIMARY KEY (`ap_id`),
  KEY `appointment_FK` (`c_id`),
  KEY `appointment_FK_1` (`s_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of appointment
-- ----------------------------

-- ----------------------------
-- Table structure for card
-- ----------------------------
DROP TABLE IF EXISTS `card`;
CREATE TABLE `card` (
  `identityID` varchar(20) NOT NULL COMMENT '患者身份证号',
  `u_id` int NOT NULL COMMENT '关联的user表外键',
  `sex` int NOT NULL COMMENT '患者性别，1表示男，0表示女',
  `age` int DEFAULT NULL COMMENT '患者年龄',
  `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '患者姓名',
  `tel_number` varchar(20) DEFAULT NULL COMMENT '患者电话号码',
  `c_id` int NOT NULL AUTO_INCREMENT COMMENT '本表主键',
  `c_status` int NOT NULL DEFAULT '1' COMMENT '1为正常，0为挂失',
  PRIMARY KEY (`c_id`),
  UNIQUE KEY `patient_UN` (`identityID`),
  KEY `patient_FK` (`u_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10010 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of card
-- ----------------------------
INSERT INTO `card` VALUES ('321281197109183266', '9', '1', '30', '张雷', '13705224848', '10000', '1');
INSERT INTO `card` VALUES ('451423194408201455', '4', '0', '34', '徐凤英', '15797887094', '10001', '0');
INSERT INTO `card` VALUES ('620123196403277235', '2', '0', '39', '朱燕', '18641219907', '10002', '1');
INSERT INTO `card` VALUES ('440881198406231547', '9', '0', '30', '侯丹', '18042352633', '10003', '0');
INSERT INTO `card` VALUES ('140203196608105045', '2', '0', '73', '常晨', '14597213850', '10004', '1');
INSERT INTO `card` VALUES ('150902195202191552', '6', '1', '16', '季鹏', '15096246791', '10005', '0');
INSERT INTO `card` VALUES ('654025197805246790', '1', '1', '89', '张洋', '18884087955', '10006', '1');
INSERT INTO `card` VALUES ('360803194502028138', '1', '1', '80', '卢成', '18101632437', '10007', '1');
INSERT INTO `card` VALUES ('230803198110040882', '2', '0', '41', '王柳', '14739876023', '10008', '1');
INSERT INTO `card` VALUES ('530723198706256001', '9', '0', '89', '谭秀英', '13212471354', '10009', '0');

-- ----------------------------
-- Table structure for clinic
-- ----------------------------
DROP TABLE IF EXISTS `clinic`;
CREATE TABLE `clinic` (
  `cli_id` int NOT NULL AUTO_INCREMENT COMMENT '本表主键',
  `cli_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '门诊名',
  `cli_level` int NOT NULL COMMENT '门诊等级，0为普通门诊，1为专家门诊',
  PRIMARY KEY (`cli_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of clinic
-- ----------------------------
INSERT INTO `clinic` VALUES ('1', '皮肤性病科', '0');
INSERT INTO `clinic` VALUES ('2', '儿科', '0');
INSERT INTO `clinic` VALUES ('3', '全科医学科', '2');
INSERT INTO `clinic` VALUES ('4', '专家门诊', '1');
INSERT INTO `clinic` VALUES ('5', '儿科', '2');
INSERT INTO `clinic` VALUES ('6', '口腔科', '0');
INSERT INTO `clinic` VALUES ('7', '外科', '2');
INSERT INTO `clinic` VALUES ('8', '全科医学科', '1');
INSERT INTO `clinic` VALUES ('9', '皮肤性病科', '0');
INSERT INTO `clinic` VALUES ('10', '儿科', '2');

-- ----------------------------
-- Table structure for department
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department` (
  `d_id` int NOT NULL AUTO_INCREMENT COMMENT '本表主键',
  `d_name` varchar(100) NOT NULL COMMENT '科室名',
  `cli_id` int NOT NULL COMMENT '门诊表外键',
  PRIMARY KEY (`d_id`),
  KEY `department_FK` (`cli_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of department
-- ----------------------------
INSERT INTO `department` VALUES ('1', '皮肤科', '1');
INSERT INTO `department` VALUES ('2', '儿科', '2');
INSERT INTO `department` VALUES ('3', '儿科', '10');
INSERT INTO `department` VALUES ('4', '口腔医学中心', '6');
INSERT INTO `department` VALUES ('5', '心脏大血管外科', '7');
INSERT INTO `department` VALUES ('6', '专家门诊', '4');
INSERT INTO `department` VALUES ('7', '儿科', '5');
INSERT INTO `department` VALUES ('8', '全科医学科门诊', '3');
INSERT INTO `department` VALUES ('9', '皮肤科', '9');
INSERT INTO `department` VALUES ('10', '全科医学科门诊', '8');

-- ----------------------------
-- Table structure for doctor
-- ----------------------------
DROP TABLE IF EXISTS `doctor`;
CREATE TABLE `doctor` (
  `doc_id` int NOT NULL AUTO_INCREMENT COMMENT '本表主键',
  `d_id` int NOT NULL COMMENT '科室外键',
  `doc_name` varchar(100) NOT NULL COMMENT '医生姓名',
  `doc_sex` int NOT NULL COMMENT '医生性别，1表示男，0表示女',
  `doc_rank` int NOT NULL COMMENT '医生等级',
  PRIMARY KEY (`doc_id`),
  KEY `doctor_FK` (`d_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of doctor
-- ----------------------------
INSERT INTO `doctor` VALUES ('1', '2', '李斌', '1', '1');
INSERT INTO `doctor` VALUES ('2', '8', '游鹏', '1', '0');
INSERT INTO `doctor` VALUES ('3', '2', '饶磊', '1', '2');
INSERT INTO `doctor` VALUES ('4', '10', '潘娟', '0', '1');
INSERT INTO `doctor` VALUES ('5', '3', '王荣', '1', '0');
INSERT INTO `doctor` VALUES ('6', '10', '陈萍', '0', '2');
INSERT INTO `doctor` VALUES ('7', '7', '陈勇', '1', '0');
INSERT INTO `doctor` VALUES ('8', '4', '张玉英', '0', '2');
INSERT INTO `doctor` VALUES ('9', '9', '杨丽娟', '0', '2');
INSERT INTO `doctor` VALUES ('10', '8', '黄丽华', '0', '0');

-- ----------------------------
-- Table structure for prescription
-- ----------------------------
DROP TABLE IF EXISTS `prescription`;
CREATE TABLE `prescription` (
  `pre_id` int NOT NULL AUTO_INCREMENT COMMENT '本表主键',
  `ap_id` int NOT NULL COMMENT 'appointment表外键',
  `pre_comment` varchar(255) NOT NULL COMMENT '处方注意事项',
  `pre_cost` float NOT NULL DEFAULT '0' COMMENT '处方价格',
  `pre_status` int NOT NULL DEFAULT '0' COMMENT '处方状态，0表示未付款，1表示已付款未取药，2表示已付款已取药',
  PRIMARY KEY (`pre_id`),
  KEY `prescription_FK` (`ap_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of prescription
-- ----------------------------

-- ----------------------------
-- Table structure for schedule
-- ----------------------------
DROP TABLE IF EXISTS `schedule`;
CREATE TABLE `schedule` (
  `s_id` int NOT NULL AUTO_INCREMENT COMMENT '本表主键',
  `doc_id` int NOT NULL COMMENT '医生表外键',
  `sc_start_time` bigint NOT NULL COMMENT '排班开始时间',
  `sc_end_time` bigint NOT NULL COMMENT '排班结束时间',
  `doc_price` float NOT NULL COMMENT '预约价格',
  `num` int NOT NULL DEFAULT '30' COMMENT '可预约数量',
  PRIMARY KEY (`s_id`),
  KEY `schedule_FK` (`doc_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of schedule
-- ----------------------------
INSERT INTO `schedule` VALUES ('1', '9', '61615643400000', '61615654200000', '35', '30');
INSERT INTO `schedule` VALUES ('2', '2', '61616161800000', '61616172600000', '10', '50');
INSERT INTO `schedule` VALUES ('3', '6', '61615837800000', '61615848600000', '35', '30');
INSERT INTO `schedule` VALUES ('4', '3', '61615751400000', '61615762200000', '35', '30');
INSERT INTO `schedule` VALUES ('5', '4', '61615665000000', '61615675800000', '25', '40');
INSERT INTO `schedule` VALUES ('6', '5', '61615989000000', '61615999800000', '10', '50');
INSERT INTO `schedule` VALUES ('7', '2', '61615643400000', '61615654200000', '10', '50');
INSERT INTO `schedule` VALUES ('8', '9', '61616010600000', '61616021400000', '35', '30');
INSERT INTO `schedule` VALUES ('9', '2', '61615902600000', '61615913400000', '10', '50');
INSERT INTO `schedule` VALUES ('10', '7', '61615924200000', '61615935000000', '10', '50');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `ACCOUNT_ID` varchar(100) NOT NULL COMMENT '获取到的微信用户的ID',
  `u_id` int NOT NULL AUTO_INCREMENT COMMENT '本表主键',
  `GMT_CREATED` bigint NOT NULL COMMENT '该条信息的创建时间',
  `GMT_MODIFIED` bigint NOT NULL COMMENT '该条信息的修改时间',
  `balance` float NOT NULL COMMENT '该账户下的余额',
  PRIMARY KEY (`u_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('owdyEGtIOU2Hetidhn6WFkCiG', '1', '1229375693000', '1229375693000', '444.1');
INSERT INTO `user` VALUES ('8JoSTOxA09Ubf3sn6kIBl3y9d', '2', '1517594070000', '1517594070000', '161.75');
INSERT INTO `user` VALUES ('qZXwtiljiwkctMOoLgr3eiLmH', '3', '1536541372000', '1536541372000', '978.62');
INSERT INTO `user` VALUES ('sGuFsgHwr4wjZcEVUdYwtJ2yY', '4', '1259589800000', '1259589800000', '34.06');
INSERT INTO `user` VALUES ('9NOyLSKdICUMlKorz9I9D5UuG', '5', '1128431964000', '1128431964000', '794.67');
INSERT INTO `user` VALUES ('1JWZWWdoUJvGZ93qyJP7eezaK', '6', '1417244987000', '1417244987000', '705.13');
INSERT INTO `user` VALUES ('418OBjunuA5ONcVq2ytiWxQyM', '7', '1037075130000', '1037075130000', '915.19');
INSERT INTO `user` VALUES ('t3e7eCsSuGtP2nJbM22G9BlW5', '8', '985211184000', '985211184000', '24.27');
INSERT INTO `user` VALUES ('bXLno8UnNJOxbtYmODnIMd4J1', '9', '1420291837000', '1420291837000', '597.23');
INSERT INTO `user` VALUES ('fJOjz2DpUtWRC1EikUTQc68gy', '10', '1271524610000', '1271524610000', '247.1');
