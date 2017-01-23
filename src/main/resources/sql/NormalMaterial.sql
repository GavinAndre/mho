-- auto Generated on 2017-01-11 14:44:23 
-- DROP TABLE IF EXISTS `normal_material`; 
CREATE TABLE normal_material(
    `id` INTEGER(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'id',
    `name` VARCHAR(50) NOT NULL DEFAULT '' COMMENT 'name',
    `count` VARCHAR(50) NOT NULL DEFAULT '' COMMENT 'count',
    `price` VARCHAR(50) NOT NULL DEFAULT '' COMMENT 'price',
    `is_update` INTEGER(12) NOT NULL DEFAULT -1 COMMENT 'isUpdate',
    PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT 'normal_material';
