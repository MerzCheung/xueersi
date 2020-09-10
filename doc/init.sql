drop table if exists xueersi;
CREATE TABLE `xueersi` (
  `id` BIGINT(32) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `province` varchar(30) DEFAULT NULL COMMENT '省份',
  `switch_grade` varchar(15) DEFAULT NULL COMMENT '年级',
  `switch_subject` varchar(15) DEFAULT NULL COMMENT '学科',
  `switch_type` varchar(15) DEFAULT NULL COMMENT '课程类型',
  `terms` varchar(15) DEFAULT NULL COMMENT '学期',
  `point` varchar(30) DEFAULT NULL COMMENT '知识点',
  `version` varchar(30) DEFAULT NULL COMMENT '版本',
  `labels` varchar(30) DEFAULT NULL COMMENT '素养分类',
  `study_phases` varchar(30) DEFAULT NULL COMMENT '进度',
  `difficulties` varchar(30) DEFAULT NULL COMMENT '难度',
  `times` varchar(15) DEFAULT NULL COMMENT '时间',
  `time_slots` varchar(15) DEFAULT NULL COMMENT '时段',
  `concrete_time` varchar(100) DEFAULT NULL COMMENT '具体时间',
  `teacher` varchar(30) DEFAULT NULL COMMENT '授课老师',
  `duration` varchar(50) DEFAULT NULL COMMENT '名称',
  `rating` varchar(10) DEFAULT NULL COMMENT '价格',
  `views` varchar(500) DEFAULT NULL COMMENT '详情链接',
  `is_valid` int(1) DEFAULT 1 COMMENT '是否有效 1：有效 0：无效',
  `created_time` datetime NOT NULL,
  `modified_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='xueersi';
