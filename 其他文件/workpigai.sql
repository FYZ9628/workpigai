/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 80011
Source Host           : localhost:3306
Source Database       : workpigai

Target Server Type    : MYSQL
Target Server Version : 80011
File Encoding         : 65001

Date: 2019-07-04 19:06:20
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `account` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `sex` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `admin_user_on_userId_fk` (`account`) USING BTREE,
  CONSTRAINT `admin_user_on_userId_fk` FOREIGN KEY (`account`) REFERENCES `user` (`account`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('1', '1001', '冯钰臻', '男');
INSERT INTO `admin` VALUES ('2', '1002', '蒙坚', '男');

-- ----------------------------
-- Table structure for chose_course
-- ----------------------------
DROP TABLE IF EXISTS `chose_course`;
CREATE TABLE `chose_course` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `course_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `teacher_id` int(11) NOT NULL,
  `class_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `teacher_id` (`teacher_id`),
  KEY `class_id` (`class_id`),
  CONSTRAINT `chose_course_ibfk_3` FOREIGN KEY (`teacher_id`) REFERENCES `teacher` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `chose_course_ibfk_4` FOREIGN KEY (`class_id`) REFERENCES `class` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of chose_course
-- ----------------------------
INSERT INTO `chose_course` VALUES ('1', '安卓开发', '1', '1');
INSERT INTO `chose_course` VALUES ('2', '课程设计', '2', '2');
INSERT INTO `chose_course` VALUES ('3', '测试课程', '3', '3');
INSERT INTO `chose_course` VALUES ('4', '测试课程', '4', '1');
INSERT INTO `chose_course` VALUES ('5', '计算机图形学', '5', '2');
INSERT INTO `chose_course` VALUES ('6', '项目管理', '2', '4');
INSERT INTO `chose_course` VALUES ('9', 'C语言', '4', '2');

-- ----------------------------
-- Table structure for class
-- ----------------------------
DROP TABLE IF EXISTS `class`;
CREATE TABLE `class` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `class_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `class_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`,`class_id`),
  KEY `class_id` (`class_id`) USING BTREE,
  KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of class
-- ----------------------------
INSERT INTO `class` VALUES ('1', '20160001', '99软件');
INSERT INTO `class` VALUES ('2', '20170001', '17软件');
INSERT INTO `class` VALUES ('3', '20180003', '18软件');
INSERT INTO `class` VALUES ('4', '20190032', '19软件');
INSERT INTO `class` VALUES ('5', '20160011', '16网络');
INSERT INTO `class` VALUES ('6', '20170011', '17网络');
INSERT INTO `class` VALUES ('7', '20180021', '18网络');
INSERT INTO `class` VALUES ('8', '20190031', '19网络');

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES ('1', 'C语言');
INSERT INTO `course` VALUES ('2', '高等数学');
INSERT INTO `course` VALUES ('3', '模拟电子技术');
INSERT INTO `course` VALUES ('4', '大学英语');
INSERT INTO `course` VALUES ('5', '民族理论与政策');
INSERT INTO `course` VALUES ('6', '思修');
INSERT INTO `course` VALUES ('7', '大学语文');
INSERT INTO `course` VALUES ('8', '马基');
INSERT INTO `course` VALUES ('9', '数字电路');
INSERT INTO `course` VALUES ('10', '线性代数');
INSERT INTO `course` VALUES ('11', 'C++');
INSERT INTO `course` VALUES ('12', '公共体育');
INSERT INTO `course` VALUES ('13', '大学生心理健康教育');
INSERT INTO `course` VALUES ('14', '软件工程导论');
INSERT INTO `course` VALUES ('15', '离散数学');
INSERT INTO `course` VALUES ('16', '中国近代史');
INSERT INTO `course` VALUES ('17', '数据结构');
INSERT INTO `course` VALUES ('18', 'java');
INSERT INTO `course` VALUES ('19', '计算机图形学');
INSERT INTO `course` VALUES ('20', '数据库系统');
INSERT INTO `course` VALUES ('21', '算法设计与分析');
INSERT INTO `course` VALUES ('22', '毛概');
INSERT INTO `course` VALUES ('23', '网络编程');
INSERT INTO `course` VALUES ('24', '软件设计与构造');
INSERT INTO `course` VALUES ('25', '计算机组成原理');
INSERT INTO `course` VALUES ('26', '专业英语');
INSERT INTO `course` VALUES ('27', '软件测试');
INSERT INTO `course` VALUES ('28', '概率论与数理统计');
INSERT INTO `course` VALUES ('29', '移动软件开发');
INSERT INTO `course` VALUES ('30', '项目管理');
INSERT INTO `course` VALUES ('31', '操作系统');
INSERT INTO `course` VALUES ('32', 'UNIX/LINUX');

-- ----------------------------
-- Table structure for question_bank
-- ----------------------------
DROP TABLE IF EXISTS `question_bank`;
CREATE TABLE `question_bank` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `question_id` varchar(11) NOT NULL,
  `title` varchar(255) NOT NULL,
  `content` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `answer` longtext,
  PRIMARY KEY (`id`,`question_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of question_bank
-- ----------------------------
INSERT INTO `question_bank` VALUES ('1', '2019001', '第一题', '第一题内容', '第一题答案');
INSERT INTO `question_bank` VALUES ('2', '2019002', '第二题', '第二题内容', '第二题答案');
INSERT INTO `question_bank` VALUES ('3', '2019003', '第三题', '第三题内容', '第三题答案');
INSERT INTO `question_bank` VALUES ('4', '2019004', '第四题', '第四题内容', '第四题答案');
INSERT INTO `question_bank` VALUES ('5', '2019005', '第五题', '第五题内容', '第五题答案');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `sex` varchar(255) NOT NULL,
  `class_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `class_id` (`class_id`),
  CONSTRAINT `student_ibfk_3` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `student_ibfk_4` FOREIGN KEY (`class_id`) REFERENCES `class` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('1', '5', '钱文震', '男', '1');
INSERT INTO `student` VALUES ('2', '6', '黄金泽', '男', '1');
INSERT INTO `student` VALUES ('3', '15', '张三', '男', '2');
INSERT INTO `student` VALUES ('4', '16', '李四', '男', '3');
INSERT INTO `student` VALUES ('6', '17', '小丽', '女', '3');
INSERT INTO `student` VALUES ('7', '18', '小爱', '女', '6');
INSERT INTO `student` VALUES ('8', '19', '彭于晏', '男', '7');
INSERT INTO `student` VALUES ('9', '20', '刘德华', '男', '8');
INSERT INTO `student` VALUES ('10', '21', '周星星', '女', '3');

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `sex` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `teacher_user_on_userId_fk` (`user_id`) USING BTREE,
  CONSTRAINT `teacher_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES ('1', '3', '李杰', '男');
INSERT INTO `teacher` VALUES ('2', '4', '曾俊雄', '男');
INSERT INTO `teacher` VALUES ('3', '7', '金晨', '女');
INSERT INTO `teacher` VALUES ('4', '8', '郭京飞', '男');
INSERT INTO `teacher` VALUES ('5', '9', '唐嫣', '女');
INSERT INTO `teacher` VALUES ('7', '11', '孟美岐', '女');
INSERT INTO `teacher` VALUES ('8', '12', '李小璐', '女');
INSERT INTO `teacher` VALUES ('9', '13', '孙倩', '女');
INSERT INTO `teacher` VALUES ('10', '14', '关晓彤', '女');
INSERT INTO `teacher` VALUES ('22', '60', '同仁', '女');
INSERT INTO `teacher` VALUES ('23', '8', '来来来', '女');
INSERT INTO `teacher` VALUES ('24', '8', 'FASDF', '男');
INSERT INTO `teacher` VALUES ('25', '61', '发送到', '女');
INSERT INTO `teacher` VALUES ('26', '67', '锅煽豆腐', '女');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `account` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `type` int(11) NOT NULL,
  PRIMARY KEY (`id`,`account`),
  UNIQUE KEY `account_user_fk` (`account`) USING BTREE,
  KEY `id_user_fk` (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=69 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '1001', '123456', '1');
INSERT INTO `user` VALUES ('2', '1002', '123456', '1');
INSERT INTO `user` VALUES ('3', 'T116263000101', '123456', '2');
INSERT INTO `user` VALUES ('4', 'T116263000102', '123456', '2');
INSERT INTO `user` VALUES ('5', '116263000101', '123456', '3');
INSERT INTO `user` VALUES ('6', '116263000102', '132465', '3');
INSERT INTO `user` VALUES ('7', 'T116263000103', '123456', '2');
INSERT INTO `user` VALUES ('8', 'T116263000789', '123456', '2');
INSERT INTO `user` VALUES ('9', 'T116263000105', '123456', '2');
INSERT INTO `user` VALUES ('11', 'T116263000107', '123456', '2');
INSERT INTO `user` VALUES ('12', 'T116263000108', '123456', '2');
INSERT INTO `user` VALUES ('13', 'T116263000109', '123456', '2');
INSERT INTO `user` VALUES ('14', 'T116263000110', '123456', '2');
INSERT INTO `user` VALUES ('15', '116263000103', '123456', '3');
INSERT INTO `user` VALUES ('16', '116263000104', '132465', '3');
INSERT INTO `user` VALUES ('17', '116263000105', '123456', '3');
INSERT INTO `user` VALUES ('18', '116263000106', '132465', '3');
INSERT INTO `user` VALUES ('19', '116263000107', '123456', '3');
INSERT INTO `user` VALUES ('20', '116263000108', '132465', '3');
INSERT INTO `user` VALUES ('21', '116263000109', '123456', '3');
INSERT INTO `user` VALUES ('22', '116263000110', '132465', '3');
INSERT INTO `user` VALUES ('60', 'T116263000987', '123456', '2');
INSERT INTO `user` VALUES ('61', 'T116263999000', '123456', '2');
INSERT INTO `user` VALUES ('67', 'T116263111000', '123456', '2');

-- ----------------------------
-- Table structure for work
-- ----------------------------
DROP TABLE IF EXISTS `work`;
CREATE TABLE `work` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `work_detail_id` int(11) NOT NULL,
  `teacher_id` int(11) NOT NULL,
  `student_id` int(11) NOT NULL,
  `submit_content` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `state` varchar(11) NOT NULL,
  `start_time` datetime NOT NULL,
  `end_time` datetime NOT NULL,
  `score` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `work_detail_id` (`work_detail_id`),
  KEY `teacher_id` (`teacher_id`),
  KEY `student_id` (`student_id`),
  CONSTRAINT `work_ibfk_1` FOREIGN KEY (`work_detail_id`) REFERENCES `work_detail` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `work_ibfk_2` FOREIGN KEY (`teacher_id`) REFERENCES `teacher` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `work_ibfk_3` FOREIGN KEY (`student_id`) REFERENCES `student` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of work
-- ----------------------------
INSERT INTO `work` VALUES ('1', '1', '1', '1', '提交内容', '未提交', '2019-06-24 09:14:26', '2019-07-05 16:16:49', '99');
INSERT INTO `work` VALUES ('2', '2', '2', '2', '提交内容', '未提交', '2019-06-24 09:14:26', '2019-07-05 16:16:49', '99');
INSERT INTO `work` VALUES ('3', '3', '1', '1', '提交内容', '已提交', '2019-06-24 09:14:26', '2019-07-05 16:16:49', '99');
INSERT INTO `work` VALUES ('4', '1', '1', '3', '提交内容', '未提交', '2019-06-24 09:14:26', '2019-07-05 16:16:49', '99');
INSERT INTO `work` VALUES ('6', '12', '7', '2', '发布测试', '未提交', '2019-07-04 03:22:51', '2019-07-04 03:22:51', '0');
INSERT INTO `work` VALUES ('7', '13', '7', '1', '发布测试', '未提交', '2019-07-04 03:25:11', '2019-07-04 03:25:11', '0');
INSERT INTO `work` VALUES ('8', '13', '7', '2', '发布测试', '未提交', '2019-07-04 03:25:11', '2019-07-04 03:25:11', '0');
INSERT INTO `work` VALUES ('9', '14', '7', '1', '发布测试', '未提交', '2019-07-04 03:29:50', '2019-07-04 03:29:50', '0');
INSERT INTO `work` VALUES ('10', '14', '7', '2', '发布测试', '未提交', '2019-07-04 03:29:50', '2019-07-04 03:29:50', '0');
INSERT INTO `work` VALUES ('11', '15', '2', '1', '发布测试', '未提交', '2019-07-04 04:56:56', '2019-07-18 00:00:00', '0');
INSERT INTO `work` VALUES ('12', '15', '2', '2', '发布测试', '未提交', '2019-07-04 04:56:56', '2019-07-18 00:00:00', '0');
INSERT INTO `work` VALUES ('13', '16', '2', '8', '发布测试', '未提交', '2019-07-04 04:59:52', '2019-07-05 00:00:00', '0');
INSERT INTO `work` VALUES ('14', '17', '2', '8', '', '未提交', '2019-07-04 05:01:38', '2019-07-06 00:00:00', '0');
INSERT INTO `work` VALUES ('15', '18', '2', '8', '', '未提交', '2019-07-04 05:04:15', '2019-07-06 00:00:00', '0');
INSERT INTO `work` VALUES ('16', '19', '2', '1', '', '未提交', '2019-07-04 05:04:56', '2019-07-12 00:00:00', '0');
INSERT INTO `work` VALUES ('17', '19', '2', '2', '', '未提交', '2019-07-04 05:04:56', '2019-07-12 00:00:00', '0');
INSERT INTO `work` VALUES ('18', '20', '2', '1', '', '未提交', '2019-07-04 05:05:53', '2019-07-18 00:00:00', '0');
INSERT INTO `work` VALUES ('19', '20', '2', '2', '', '未提交', '2019-07-04 05:05:53', '2019-07-18 00:00:00', '0');

-- ----------------------------
-- Table structure for work_detail
-- ----------------------------
DROP TABLE IF EXISTS `work_detail`;
CREATE TABLE `work_detail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `work_title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `publish_content` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `answer` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of work_detail
-- ----------------------------
INSERT INTO `work_detail` VALUES ('1', '安卓开发', '第一个发布作业内容', '第一个发布作业答案');
INSERT INTO `work_detail` VALUES ('2', '项目管理', '第二个发布作业内容', '第二个发布作业答案');
INSERT INTO `work_detail` VALUES ('3', '课程设计', '第三个发布作业内容', '第三个发布作业答案');
INSERT INTO `work_detail` VALUES ('4', '软件工程导论', '第四个发布作业内容', '第四个发布作业答案');
INSERT INTO `work_detail` VALUES ('5', '数据库设计', '第五个发布作业内容', '第五个发布作业答案');
INSERT INTO `work_detail` VALUES ('6', '课程测试', '测试内容', '测试答案');
INSERT INTO `work_detail` VALUES ('7', '课程测试', '测试内容', '测试答案');
INSERT INTO `work_detail` VALUES ('9', '643fas', '1 、 第二题内容\n\n2 、 第三题内容\n\n', '1 、 第二题答案\n\n2 、 第三题答案\n\n');
INSERT INTO `work_detail` VALUES ('10', '5235', '1 、 第一题内容\n\n2 、 第二题内容\n\n3 、 第四题内容\n\n', '1 、 第一题答案\n\n2 、 第二题答案\n\n3 、 第四题答案\n\n');
INSERT INTO `work_detail` VALUES ('11', '郭德纲发热', '1 、 第二题内容\n\n2 、 第三题内容\n\n', '1 、 第二题答案\n\n2 、 第三题答案\n\n');
INSERT INTO `work_detail` VALUES ('12', '给对方', '1 、 第二题内容\n\n2 、 第三题内容\n\n', '1 、 第二题答案\n\n2 、 第三题答案\n\n');
INSERT INTO `work_detail` VALUES ('13', '发布测试33333', '1 、 第一题内容\n\n2 、 第二题内容\n\n3 、 第三题内容\n\n4 、 第四题内容\n\n', '1 、 第一题答案\n\n2 、 第二题答案\n\n3 、 第三题答案\n\n4 、 第四题答案\n\n');
INSERT INTO `work_detail` VALUES ('14', '哥哥哥各个', '1 、 第一题内容\n\n2 、 第二题内容\n\n3 、 第三题内容\n\n4 、 第四题内容\n\n', '1 、 第一题答案\n\n2 、 第二题答案\n\n3 、 第三题答案\n\n4 、 第四题答案\n\n');
INSERT INTO `work_detail` VALUES ('15', '伽古拉就是感觉', '1 、 第二题内容\n\n2 、 第三题内容\n\n3 、 第四题内容\n\n4 、 第五题内容\n\n', '1 、 第二题答案\n\n2 、 第三题答案\n\n3 、 第四题答案\n\n4 、 第五题答案\n\n');
INSERT INTO `work_detail` VALUES ('16', '作业作业作业作业', '1 、 第一题内容\n\n2 、 第二题内容\n\n3 、 第三题内容\n\n', '1 、 第一题答案\n\n2 、 第二题答案\n\n3 、 第三题答案\n\n');
INSERT INTO `work_detail` VALUES ('17', '666666666', '1 、 第二题内容\n\n2 、 第三题内容\n\n', '1 、 第二题答案\n\n2 、 第三题答案\n\n');
INSERT INTO `work_detail` VALUES ('18', '888888', '1 、 第二题内容\n\n2 、 第三题内容\n\n', '1 、 第二题答案\n\n2 、 第三题答案\n\n');
INSERT INTO `work_detail` VALUES ('19', '000000', '1 、 第二题内容\n\n2 、 第三题内容\n\n1 、 第二题内容\n\n2 、 第三题内容\n\n3 、 第四题内容\n\n', '1 、 第二题答案\n\n2 、 第三题答案\n\n1 、 第二题答案\n\n2 、 第三题答案\n\n3 、 第四题答案\n\n');
INSERT INTO `work_detail` VALUES ('20', '6456456456', '1 、 第二题内容\n\n2 、 第三题内容\n\n', '1 、 第二题答案\n\n2 、 第三题答案\n\n');
