CREATE TABLE `product` (
	`id` BIGINT(20) NOT NULL,
	`bar_code` INT(11) NULL DEFAULT NULL,
	`description` VARCHAR(255) NULL DEFAULT NULL,
	`name` VARCHAR(255) NULL DEFAULT NULL,
	PRIMARY KEY (`id`),
	UNIQUE INDEX `UK_m2hrqf78hkkulfqxk62k3y4sm` (`bar_code`)
)
COLLATE='latin1_swedish_ci'
ENGINE=MyISAM
;


CREATE TABLE `survey_product` (
	`id` BIGINT(20) NOT NULL,
	`notes` VARCHAR(255) NULL DEFAULT NULL,
	`price_by_user` DOUBLE NOT NULL,
	`product_id` BIGINT(20) NULL DEFAULT NULL,
	PRIMARY KEY (`id`),
	INDEX `FKtegvxivm8m7n2u12rxm5441x2` (`product_id`)
)
COLLATE='latin1_swedish_ci'
ENGINE=MyISAM
;
