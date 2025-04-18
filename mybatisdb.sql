/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50721
Source Host           : localhost:3306
Source Database       : mybatisdb

Target Server Type    : MYSQL
Target Server Version : 50721
File Encoding         : 65001

Date: 2024-01-07 18:20:24
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `mybatisdb`
-- ----------------------------
DROP TABLE IF EXISTS `mybatisdb`;
CREATE TABLE `mybatisdb` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `age` int(11) NOT NULL,
  `email` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of mybatisdb
-- ----------------------------

-- ----------------------------
-- Table structure for `tb_class`
-- ----------------------------
DROP TABLE IF EXISTS `tb_class`;
CREATE TABLE `tb_class` (
  `id` int(11) NOT NULL,
  `class_name` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of tb_class
-- ----------------------------
INSERT INTO `tb_class` VALUES ('1001', '21信计1班');
INSERT INTO `tb_class` VALUES ('1002', '21信计2班');
INSERT INTO `tb_class` VALUES ('1003', '统计1班');
INSERT INTO `tb_class` VALUES ('1004', '数学师范1班');
INSERT INTO `tb_class` VALUES ('1005', '21数师4班');
INSERT INTO `tb_class` VALUES ('1006', '22数师2班');

-- ----------------------------
-- Table structure for `tb_order`
-- ----------------------------
DROP TABLE IF EXISTS `tb_order`;
CREATE TABLE `tb_order` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '订单编号',
  `orderTime` date DEFAULT NULL COMMENT '订单时间',
  `total` int(11) NOT NULL COMMENT '订单价格',
  `user_id` int(11) NOT NULL COMMENT '用户id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of tb_order
-- ----------------------------
INSERT INTO `tb_order` VALUES ('1', '2023-06-01', '1000', '1');
INSERT INTO `tb_order` VALUES ('2', '2023-06-08', '3000', '1');
INSERT INTO `tb_order` VALUES ('3', '2023-06-15', '2000', '2');
INSERT INTO `tb_order` VALUES ('4', '2023-06-22', '4000', '2');
INSERT INTO `tb_order` VALUES ('5', '2023-06-23', '1666', '3');
INSERT INTO `tb_order` VALUES ('6', '2023-06-30', '1111', '4');
INSERT INTO `tb_order` VALUES ('7', '2023-07-01', '1315', '5');
INSERT INTO `tb_order` VALUES ('8', '1970-01-01', '1234', '6');
INSERT INTO `tb_order` VALUES ('9', '2023-07-01', '1315', '6');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(10) NOT NULL,
  `name` varchar(30) CHARACTER SET gbk DEFAULT NULL,
  `age` int(10) DEFAULT NULL,
  `class_id` int(10) NOT NULL,
  `email` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'Cory', '18', '1002', 'Cory@gpnu.edu.cn');
INSERT INTO `user` VALUES ('2', 'Jacker', '18', '1003', 'test2@gpnu.edu.cn');
INSERT INTO `user` VALUES ('3', 'Tom', '19', '1002', 'test3@gpnu.edu.cn');
INSERT INTO `user` VALUES ('5', 'Jone', '20', '1003', 'test5@gpnu.edu.cn');
INSERT INTO `user` VALUES ('6', 'Stone', '19', '1002', 'test6@gpnu.edu.cn');
INSERT INTO `user` VALUES ('7', 'Copper', '29', '1003', 'test7@gpnu.edu.cn');
INSERT INTO `user` VALUES ('8', '马云', '29', '1002', 'test8@gpnu.edu.cn');
INSERT INTO `user` VALUES ('9', '赵信', '19', '1002', 'test9@gpnu.edu.cn');
INSERT INTO `user` VALUES ('10', '张三', '20', '1002', 'test10@gpnu.edu.cn');
INSERT INTO `user` VALUES ('11', '马蓉', '20', '1001', 'test11@gpnu.edu.cn');
INSERT INTO `user` VALUES ('12', '马五', '24', '1001', 'test12@gpnu.edu.cn');
INSERT INTO `user` VALUES ('13', '老六', '23', '1002', 'test13@gpnu.edu.cn');
INSERT INTO `user` VALUES ('14', 'asd', '19', '1002', 'sda@');
INSERT INTO `user` VALUES ('16', '李商隐', '18', '1002', 'lsy@gamil.com');
INSERT INTO `user` VALUES ('17', 'las', '19', '1002', 'asd@gmail.com');
INSERT INTO `user` VALUES ('18', '李四', '19', '1001', 'test13@gpnu.cn');
INSERT INTO `user` VALUES ('20', 'lwq', '19', '1001', 'idoja@gmail.com');
INSERT INTO `user` VALUES ('21', 'lsk', '21', '1001', 'diojd@gmail.com');
INSERT INTO `user` VALUES ('22', 'ska', '19', '1001', 'dojidj@gmail.com');
INSERT INTO `user` VALUES ('23', 'wia', '18', '1002', 'doi@gmail.com');
INSERT INTO `user` VALUES ('24', '阿斯顿', '20', '1003', 'asd@gmail.com');
