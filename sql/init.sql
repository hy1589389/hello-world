-- 创建数据库
CREATE DATABASE IF NOT EXISTS hotel_db CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

USE hotel_db;

-- 创建用户表
CREATE TABLE IF NOT EXISTS `user` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `username` varchar(50) NOT NULL COMMENT '用户名',
  `password` varchar(100) NOT NULL COMMENT '密码',
  `real_name` varchar(50) COMMENT '真实姓名',
  `email` varchar(100) COMMENT '邮箱',
  `phone` varchar(20) COMMENT '手机号',
  `id_card` varchar(50) COMMENT '身份证',
  `user_type` int COMMENT '用户类型(0-普通用户,1-管理员)',
  `status` int COMMENT '用户状态(0-禁用,1-启用)',
  `create_time` datetime COMMENT '创建时间',
  `update_time` datetime COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_username` (`username`),
  KEY `idx_email` (`email`),
  KEY `idx_phone` (`phone`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='用户表';

-- 创建房间表
CREATE TABLE IF NOT EXISTS `room` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `room_number` varchar(50) NOT NULL COMMENT '房间号',
  `room_type` int COMMENT '房间类型(0-单人间,1-双人间,2-三人间,3-豪华间)',
  `room_name` varchar(100) COMMENT '房间名称',
  `description` text COMMENT '房间描述',
  `location` varchar(50) COMMENT '房间位置/楼层',
  `bed_count` int COMMENT '床位数',
  `max_guests` int COMMENT '最大入住人数',
  `area` decimal(10,2) COMMENT '房间面积(平方米)',
  `price` decimal(10,2) COMMENT '每晚价格',
  `facilities` text COMMENT '房间设施(JSON格式)',
  `status` int COMMENT '房间状态(0-维护中,1-可用,2-已预定)',
  `create_time` datetime COMMENT '创建时间',
  `update_time` datetime COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_room_number` (`room_number`),
  KEY `idx_room_type` (`room_type`),
  KEY `idx_status` (`status`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='房间表';

-- 创建预订表
CREATE TABLE IF NOT EXISTS `booking` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `booking_number` varchar(50) NOT NULL COMMENT '预订号',
  `user_id` bigint NOT NULL COMMENT '用户ID',
  `room_id` bigint NOT NULL COMMENT '房间ID',
  `check_in_date` date NOT NULL COMMENT '入住日期',
  `check_out_date` date NOT NULL COMMENT '退房日期',
  `guest_count` int COMMENT '入住人数',
  `guest_name` varchar(50) COMMENT '入住人姓名',
  `guest_phone` varchar(20) COMMENT '入住人电话',
  `guest_email` varchar(100) COMMENT '入住人邮箱',
  `total_price` decimal(10,2) COMMENT '总价格',
  `status` int COMMENT '预订状态(0-待确认,1-已确认,2-已入住,3-已退房,4-已取消)',
  `remarks` text COMMENT '备注',
  `create_time` datetime COMMENT '创建时间',
  `update_time` datetime COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_booking_number` (`booking_number`),
  KEY `idx_user_id` (`user_id`),
  KEY `idx_room_id` (`room_id`),
  KEY `idx_check_in_date` (`check_in_date`),
  KEY `idx_check_out_date` (`check_out_date`),
  KEY `idx_status` (`status`),
  CONSTRAINT `fk_booking_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `fk_booking_room` FOREIGN KEY (`room_id`) REFERENCES `room` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='预订表';

-- 插入示例数据
-- 插入用户数据
INSERT INTO `user` (`username`, `password`, `real_name`, `email`, `phone`, `user_type`, `status`, `create_time`) VALUES
('admin', '123456', '管理员', 'admin@hotel.com', '13800000001', 1, 1, NOW()),
('user1', '123456', '张三', 'user1@hotel.com', '13800000002', 0, 1, NOW()),
('user2', '123456', '李四', 'user2@hotel.com', '13800000003', 0, 1, NOW());

-- 插入房间数据
INSERT INTO `room` (`room_number`, `room_type`, `room_name`, `description`, `location`, `bed_count`, `max_guests`, `area`, `price`, `status`, `create_time`) VALUES
('101', 0, '豪华单人间', '配置高档家具和设施', '一楼', 1, 1, 20.00, 288.00, 1, NOW()),
('102', 1, '豪华双人间', '宽敞舒适的双人间', '一楼', 1, 2, 30.00, 388.00, 1, NOW()),
('103', 2, '豪华三人间', '三人间配置豪华', '一楼', 1, 3, 40.00, 488.00, 1, NOW()),
('201', 0, '单人间', '简洁舒适的单人间', '二楼', 1, 1, 18.00, 188.00, 1, NOW()),
('202', 1, '双人间', '宽敞的双人间', '二楼', 1, 2, 25.00, 288.00, 1, NOW()),
('203', 2, '三人间', '适合家庭入住', '二楼', 1, 3, 35.00, 388.00, 1, NOW()),
('301', 0, '单人间', '经济型单人间', '三楼', 1, 1, 15.00, 128.00, 1, NOW()),
('302', 1, '双人间', '经济型双人间', '三楼', 1, 2, 20.00, 188.00, 1, NOW());
