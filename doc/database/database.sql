DROP TABLE IF EXISTS `article`;
CREATE TABLE `article` (
  `article_id` varchar(255) NOT NULL,
  `enable` bit(1) DEFAULT NULL,
  `content_html` text,
  `content_md` text,
  `content_text` text,
  `title` varchar(255) DEFAULT NULL,
  `title_img_url` varchar(255) DEFAULT NULL,
  `user_id` varchar(255) DEFAULT NULL,
   `create_time` DEFAULT CURRENT_TIMESTAMP ,
  `update_time` DEFAULT CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
  PRIMARY KEY (`article_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `draft`;
CREATE TABLE `draft` (
  `draft_id` varchar(255) NOT NULL,
  `article_id` varchar(255) DEFAULT NULL,
  `user_id` varchar(255) DEFAULT NULL,
  `enable` bit(1) DEFAULT NULL,
  `content_md` text,
  `title` varchar(255) DEFAULT NULL,
  `title_img_url` varchar(255) DEFAULT NULL,
   `create_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ,
  `update_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
  PRIMARY KEY (`draft_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;