-- auto Generated on 2017-01-12 17:33:03 
-- DROP TABLE IF EXISTS `user_model`; 
CREATE TABLE user_model(
    `user_name` VARCHAR(50) NOT NULL DEFAULT '' COMMENT '登录名',
    `real_name` VARCHAR(50) NOT NULL DEFAULT '' COMMENT '真实姓名',
    `user_pwd` VARCHAR(50) NOT NULL DEFAULT '' COMMENT '密码',
    `phone_num` VARCHAR(50) NOT NULL DEFAULT '' COMMENT 'phoneNum',
    `id` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'id',
    `create_date` DATETIME NOT NULL DEFAULT '1000-01-01 00:00:00' COMMENT 'createDate',
    PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT 'user_model';
