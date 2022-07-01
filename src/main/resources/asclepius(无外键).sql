/*
 Navicat Premium Data Transfer

 Source Server         : asclepius
 Source Server Type    : MySQL
 Source Server Version : 80029
 Source Host           : 49.232.196.77:3306
 Source Schema         : asclepius

 Target Server Type    : MySQL
 Target Server Version : 80029
 File Encoding         : 65001

 Date: 01/07/2022 08:46:57
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

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
BEGIN;
COMMIT;

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
                        KEY `patient_FK` (`u_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10010 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of card
-- ----------------------------
BEGIN;
INSERT INTO `card` (`identityID`, `u_id`, `sex`, `age`, `name`, `tel_number`, `c_id`, `c_status`) VALUES ('321281197109183266', 9, 1, 30, '张雷', '13705224848', 10000, 1);
INSERT INTO `card` (`identityID`, `u_id`, `sex`, `age`, `name`, `tel_number`, `c_id`, `c_status`) VALUES ('451423194408201455', 4, 0, 34, '徐凤英', '15797887094', 10001, 0);
INSERT INTO `card` (`identityID`, `u_id`, `sex`, `age`, `name`, `tel_number`, `c_id`, `c_status`) VALUES ('620123196403277235', 2, 0, 39, '朱燕', '18641219907', 10002, 1);
INSERT INTO `card` (`identityID`, `u_id`, `sex`, `age`, `name`, `tel_number`, `c_id`, `c_status`) VALUES ('440881198406231547', 9, 0, 30, '侯丹', '18042352633', 10003, 0);
INSERT INTO `card` (`identityID`, `u_id`, `sex`, `age`, `name`, `tel_number`, `c_id`, `c_status`) VALUES ('140203196608105045', 2, 0, 73, '常晨', '14597213850', 10004, 1);
INSERT INTO `card` (`identityID`, `u_id`, `sex`, `age`, `name`, `tel_number`, `c_id`, `c_status`) VALUES ('150902195202191552', 6, 1, 16, '季鹏', '15096246791', 10005, 0);
INSERT INTO `card` (`identityID`, `u_id`, `sex`, `age`, `name`, `tel_number`, `c_id`, `c_status`) VALUES ('654025197805246790', 1, 1, 89, '张洋', '18884087955', 10006, 1);
INSERT INTO `card` (`identityID`, `u_id`, `sex`, `age`, `name`, `tel_number`, `c_id`, `c_status`) VALUES ('360803194502028138', 1, 1, 80, '卢成', '18101632437', 10007, 1);
INSERT INTO `card` (`identityID`, `u_id`, `sex`, `age`, `name`, `tel_number`, `c_id`, `c_status`) VALUES ('230803198110040882', 2, 0, 41, '王柳', '14739876023', 10008, 1);
INSERT INTO `card` (`identityID`, `u_id`, `sex`, `age`, `name`, `tel_number`, `c_id`, `c_status`) VALUES ('530723198706256001', 9, 0, 89, '谭秀英', '13212471354', 10009, 0);
COMMIT;

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
BEGIN;
INSERT INTO `clinic` (`cli_id`, `cli_name`, `cli_level`) VALUES (1, '皮肤性病科', 0);
INSERT INTO `clinic` (`cli_id`, `cli_name`, `cli_level`) VALUES (2, '儿科', 0);
INSERT INTO `clinic` (`cli_id`, `cli_name`, `cli_level`) VALUES (3, '全科医学科', 2);
INSERT INTO `clinic` (`cli_id`, `cli_name`, `cli_level`) VALUES (4, '专家门诊', 1);
INSERT INTO `clinic` (`cli_id`, `cli_name`, `cli_level`) VALUES (5, '儿科', 2);
INSERT INTO `clinic` (`cli_id`, `cli_name`, `cli_level`) VALUES (6, '口腔科', 0);
INSERT INTO `clinic` (`cli_id`, `cli_name`, `cli_level`) VALUES (7, '外科', 2);
INSERT INTO `clinic` (`cli_id`, `cli_name`, `cli_level`) VALUES (8, '全科医学科', 1);
INSERT INTO `clinic` (`cli_id`, `cli_name`, `cli_level`) VALUES (9, '皮肤性病科', 0);
INSERT INTO `clinic` (`cli_id`, `cli_name`, `cli_level`) VALUES (10, '儿科', 2);
COMMIT;

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
BEGIN;
INSERT INTO `department` (`d_id`, `d_name`, `cli_id`) VALUES (1, '皮肤科', 1);
INSERT INTO `department` (`d_id`, `d_name`, `cli_id`) VALUES (2, '儿科', 2);
INSERT INTO `department` (`d_id`, `d_name`, `cli_id`) VALUES (3, '儿科', 10);
INSERT INTO `department` (`d_id`, `d_name`, `cli_id`) VALUES (4, '口腔医学中心', 6);
INSERT INTO `department` (`d_id`, `d_name`, `cli_id`) VALUES (5, '心脏大血管外科', 7);
INSERT INTO `department` (`d_id`, `d_name`, `cli_id`) VALUES (6, '专家门诊', 4);
INSERT INTO `department` (`d_id`, `d_name`, `cli_id`) VALUES (7, '儿科', 5);
INSERT INTO `department` (`d_id`, `d_name`, `cli_id`) VALUES (8, '全科医学科门诊', 3);
INSERT INTO `department` (`d_id`, `d_name`, `cli_id`) VALUES (9, '皮肤科', 9);
INSERT INTO `department` (`d_id`, `d_name`, `cli_id`) VALUES (10, '全科医学科门诊', 8);
COMMIT;

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
                          `doc_image` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '医生照片',
                          `doc_detail` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '医生详情信息',
                          PRIMARY KEY (`doc_id`),
                          KEY `doctor_FK` (`d_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of doctor
-- ----------------------------
BEGIN;
INSERT INTO `doctor` (`doc_id`, `d_id`, `doc_name`, `doc_sex`, `doc_rank`, `doc_image`, `doc_detail`) VALUES (1, 2, '李斌', 1, 1, NULL, NULL);
INSERT INTO `doctor` (`doc_id`, `d_id`, `doc_name`, `doc_sex`, `doc_rank`, `doc_image`, `doc_detail`) VALUES (2, 8, '游鹏', 1, 0, NULL, NULL);
INSERT INTO `doctor` (`doc_id`, `d_id`, `doc_name`, `doc_sex`, `doc_rank`, `doc_image`, `doc_detail`) VALUES (3, 2, '饶磊', 1, 2, NULL, NULL);
INSERT INTO `doctor` (`doc_id`, `d_id`, `doc_name`, `doc_sex`, `doc_rank`, `doc_image`, `doc_detail`) VALUES (4, 10, '潘娟', 0, 1, NULL, NULL);
INSERT INTO `doctor` (`doc_id`, `d_id`, `doc_name`, `doc_sex`, `doc_rank`, `doc_image`, `doc_detail`) VALUES (5, 3, '王荣', 1, 0, NULL, NULL);
INSERT INTO `doctor` (`doc_id`, `d_id`, `doc_name`, `doc_sex`, `doc_rank`, `doc_image`, `doc_detail`) VALUES (6, 10, '陈萍', 0, 2, NULL, NULL);
INSERT INTO `doctor` (`doc_id`, `d_id`, `doc_name`, `doc_sex`, `doc_rank`, `doc_image`, `doc_detail`) VALUES (7, 7, '陈勇', 1, 0, NULL, NULL);
INSERT INTO `doctor` (`doc_id`, `d_id`, `doc_name`, `doc_sex`, `doc_rank`, `doc_image`, `doc_detail`) VALUES (8, 4, '张玉英', 0, 2, NULL, NULL);
INSERT INTO `doctor` (`doc_id`, `d_id`, `doc_name`, `doc_sex`, `doc_rank`, `doc_image`, `doc_detail`) VALUES (9, 9, '杨丽娟', 0, 2, NULL, NULL);
INSERT INTO `doctor` (`doc_id`, `d_id`, `doc_name`, `doc_sex`, `doc_rank`, `doc_image`, `doc_detail`) VALUES (10, 8, '黄丽华', 0, 0, NULL, NULL);
COMMIT;

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
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for schedule
-- ----------------------------
DROP TABLE IF EXISTS `schedule`;
CREATE TABLE `schedule` (
                            `s_id` int NOT NULL AUTO_INCREMENT COMMENT '本表主键',
                            `doc_id` int NOT NULL COMMENT '医生表外键',
                            `sc_start_time` bigint NOT NULL COMMENT '排班开始时间',
                            `doc_price` float NOT NULL COMMENT '预约价格',
                            `num` int NOT NULL DEFAULT '30' COMMENT '可预约数量',
                            PRIMARY KEY (`s_id`),
                            KEY `schedule_FK` (`doc_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of schedule
-- ----------------------------
BEGIN;
INSERT INTO `schedule` (`s_id`, `doc_id`, `sc_start_time`, `doc_price`, `num`) VALUES (1, 9, 61615643400000, 35, 30);
INSERT INTO `schedule` (`s_id`, `doc_id`, `sc_start_time`, `doc_price`, `num`) VALUES (2, 2, 61616161800000, 10, 50);
INSERT INTO `schedule` (`s_id`, `doc_id`, `sc_start_time`, `doc_price`, `num`) VALUES (3, 6, 61615837800000, 35, 30);
INSERT INTO `schedule` (`s_id`, `doc_id`, `sc_start_time`, `doc_price`, `num`) VALUES (4, 3, 61615751400000, 35, 30);
INSERT INTO `schedule` (`s_id`, `doc_id`, `sc_start_time`, `doc_price`, `num`) VALUES (5, 4, 61615665000000, 25, 40);
INSERT INTO `schedule` (`s_id`, `doc_id`, `sc_start_time`, `doc_price`, `num`) VALUES (6, 5, 61615989000000, 10, 50);
INSERT INTO `schedule` (`s_id`, `doc_id`, `sc_start_time`, `doc_price`, `num`) VALUES (7, 2, 61615643400000, 10, 50);
INSERT INTO `schedule` (`s_id`, `doc_id`, `sc_start_time`, `doc_price`, `num`) VALUES (8, 9, 61616010600000, 35, 30);
INSERT INTO `schedule` (`s_id`, `doc_id`, `sc_start_time`, `doc_price`, `num`) VALUES (9, 2, 61615902600000, 10, 50);
INSERT INTO `schedule` (`s_id`, `doc_id`, `sc_start_time`, `doc_price`, `num`) VALUES (10, 7, 61615924200000, 10, 50);
COMMIT;

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
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of user
-- ----------------------------
BEGIN;
INSERT INTO `user` (`ACCOUNT_ID`, `u_id`, `GMT_CREATED`, `GMT_MODIFIED`, `balance`) VALUES ('owdyEGtIOU2Hetidhn6WFkCiG', 1, 1229375693000, 1229375693000, 444.1);
INSERT INTO `user` (`ACCOUNT_ID`, `u_id`, `GMT_CREATED`, `GMT_MODIFIED`, `balance`) VALUES ('8JoSTOxA09Ubf3sn6kIBl3y9d', 2, 1517594070000, 1517594070000, 161.75);
INSERT INTO `user` (`ACCOUNT_ID`, `u_id`, `GMT_CREATED`, `GMT_MODIFIED`, `balance`) VALUES ('qZXwtiljiwkctMOoLgr3eiLmH', 3, 1536541372000, 1536541372000, 978.62);
INSERT INTO `user` (`ACCOUNT_ID`, `u_id`, `GMT_CREATED`, `GMT_MODIFIED`, `balance`) VALUES ('sGuFsgHwr4wjZcEVUdYwtJ2yY', 4, 1259589800000, 1259589800000, 34.06);
INSERT INTO `user` (`ACCOUNT_ID`, `u_id`, `GMT_CREATED`, `GMT_MODIFIED`, `balance`) VALUES ('9NOyLSKdICUMlKorz9I9D5UuG', 5, 1128431964000, 1128431964000, 794.67);
INSERT INTO `user` (`ACCOUNT_ID`, `u_id`, `GMT_CREATED`, `GMT_MODIFIED`, `balance`) VALUES ('1JWZWWdoUJvGZ93qyJP7eezaK', 6, 1417244987000, 1417244987000, 705.13);
INSERT INTO `user` (`ACCOUNT_ID`, `u_id`, `GMT_CREATED`, `GMT_MODIFIED`, `balance`) VALUES ('418OBjunuA5ONcVq2ytiWxQyM', 7, 1037075130000, 1037075130000, 915.19);
INSERT INTO `user` (`ACCOUNT_ID`, `u_id`, `GMT_CREATED`, `GMT_MODIFIED`, `balance`) VALUES ('t3e7eCsSuGtP2nJbM22G9BlW5', 8, 985211184000, 985211184000, 24.27);
INSERT INTO `user` (`ACCOUNT_ID`, `u_id`, `GMT_CREATED`, `GMT_MODIFIED`, `balance`) VALUES ('bXLno8UnNJOxbtYmODnIMd4J1', 9, 1420291837000, 1420291837000, 597.23);
INSERT INTO `user` (`ACCOUNT_ID`, `u_id`, `GMT_CREATED`, `GMT_MODIFIED`, `balance`) VALUES ('fJOjz2DpUtWRC1EikUTQc68gy', 10, 1271524610000, 1271524610000, 247.1);
INSERT INTO `user` (`ACCOUNT_ID`, `u_id`, `GMT_CREATED`, `GMT_MODIFIED`, `balance`) VALUES ('8twCTW678Wc79SBZ9Xq9AXPs8888', 12, 1656594398778, 1656594398778, 0);
INSERT INTO `user` (`ACCOUNT_ID`, `u_id`, `GMT_CREATED`, `GMT_MODIFIED`, `balance`) VALUES ('9GT89gqgWVz6zZsK7i779UfDd967', 13, 1656594563483, 1656594563483, 0);
INSERT INTO `user` (`ACCOUNT_ID`, `u_id`, `GMT_CREATED`, `GMT_MODIFIED`, `balance`) VALUES ('D7vjPx7tL99BOY78DY699lTA8Pt7', 14, 1656594623531, 1656594623531, 0);
INSERT INTO `user` (`ACCOUNT_ID`, `u_id`, `GMT_CREATED`, `GMT_MODIFIED`, `balance`) VALUES ('VrsMD6OS688LUodlKHTyZhydYn7c', 15, 1656595094808, 1656595094808, 0);
INSERT INTO `user` (`ACCOUNT_ID`, `u_id`, `GMT_CREATED`, `GMT_MODIFIED`, `balance`) VALUES ('qL8nPt86TLc7Qn7znte978GbHvxY', 16, 1656595174449, 1656595174449, 0);
INSERT INTO `user` (`ACCOUNT_ID`, `u_id`, `GMT_CREATED`, `GMT_MODIFIED`, `balance`) VALUES ('q7ju687ocm9jfsgzQK8fLqdkq77R', 17, 1656595277746, 1656595277746, 0);
INSERT INTO `user` (`ACCOUNT_ID`, `u_id`, `GMT_CREATED`, `GMT_MODIFIED`, `balance`) VALUES ('JYx66UHBlx8DWTK7c7t87KaWH9mA', 18, 1656595553723, 1656595553723, 0);
INSERT INTO `user` (`ACCOUNT_ID`, `u_id`, `GMT_CREATED`, `GMT_MODIFIED`, `balance`) VALUES ('Gt77b68rj7QnrERJb7l7z8YU989i', 19, 1656595659272, 1656595659272, 0);
INSERT INTO `user` (`ACCOUNT_ID`, `u_id`, `GMT_CREATED`, `GMT_MODIFIED`, `balance`) VALUES ('9qIizjhUjabhSsa9G9Ah6OzVfQsN', 20, 1656595844929, 1656595844929, 0);
INSERT INTO `user` (`ACCOUNT_ID`, `u_id`, `GMT_CREATED`, `GMT_MODIFIED`, `balance`) VALUES ('I6hWqXBPRDQZOlmEyb7Jt87ftld9', 21, 1656596353730, 1656596353730, 0);
INSERT INTO `user` (`ACCOUNT_ID`, `u_id`, `GMT_CREATED`, `GMT_MODIFIED`, `balance`) VALUES ('PIQv9Q967D89978Pg97VmOH66M6f', 22, 1656596371429, 1656596371429, 0);
INSERT INTO `user` (`ACCOUNT_ID`, `u_id`, `GMT_CREATED`, `GMT_MODIFIED`, `balance`) VALUES ('8uc8H8unWnxgLYXg77d77x9CdVpn', 23, 1656596511626, 1656596511626, 0);
INSERT INTO `user` (`ACCOUNT_ID`, `u_id`, `GMT_CREATED`, `GMT_MODIFIED`, `balance`) VALUES ('pzk9yd7VAX8YdLaVT98gkPugskGc', 26, 1656599702492, 1656599702492, 0);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
