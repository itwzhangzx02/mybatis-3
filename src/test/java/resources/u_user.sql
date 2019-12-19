--
--    Copyright 2009-2019 the original author or authors.
--
--    Licensed under the Apache License, Version 2.0 (the "License");
--    you may not use this file except in compliance with the License.
--    You may obtain a copy of the License at
--
--       http://www.apache.org/licenses/LICENSE-2.0
--
--    Unless required by applicable law or agreed to in writing, software
--    distributed under the License is distributed on an "AS IS" BASIS,
--    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
--    See the License for the specific language governing permissions and
--    limitations under the License.
--

/*
Navicat MySQL Data Transfer

Source Server         : zhangzx
Source Server Version : 50728
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50728
File Encoding         : 65001

Date: 2019-12-12 14:31:07
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for u_user
-- ----------------------------
DROP TABLE IF EXISTS `u_user`;
CREATE TABLE `u_user` (
  `usercode` varchar(60) NOT NULL DEFAULT '',
  `password` varchar(128) DEFAULT NULL,
  `usertype` varchar(2) DEFAULT NULL COMMENT '00：老师；01：学生 02：家长',
  `mobile` varchar(11) DEFAULT NULL,
  `username` varchar(64) DEFAULT NULL,
  `createtime` datetime DEFAULT NULL,
  PRIMARY KEY (`usercode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
