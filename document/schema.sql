CREATE SCHEMA IF NOT EXISTS spring_jndi DEFAULT CHARACTER SET utf8;

USE spring_jndi;

CREATE TABLE IF NOT EXISTS `t_user` (
`id` int(11) auto_increment,
`name` varchar(12) DEFAULT NULL,
`password` varchar(12) DEFAULT NULL,
PRIMARY KEY(id))
ENGINE=InnoDB DEFAULT CHARSET=utf8;

GRANT ALL ON spring_jndi.* TO 'spring_jndi'@'127.0.0.1' IDENTIFIED BY 'spring_jndi';
