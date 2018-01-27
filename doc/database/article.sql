drop table `blog`.`article`;
CREATE TABLE `blog`.`article` (
  `id` VARCHAR(64) NOT NULL,
  `user_id` VARCHAR(64) NULL,
  `img_url` VARCHAR(128) NULL,
  `title` VARCHAR(128) NULL,
  `content` TEXT NULL,
  `create_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ,
  `update_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`));
