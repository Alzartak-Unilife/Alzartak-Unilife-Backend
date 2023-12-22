DROP TABLE IF EXISTS `course`;

CREATE TABLE `course`
(
    `course_id`           BIGINT AUTO_INCREMENT,
    `year`                INT,
    `semester`            INT,
    `grades`              VARCHAR(255),
    `curriculum`          VARCHAR(255),
    `course_area`         VARCHAR(255),
    `base_code`           VARCHAR(255),
    `div_code`            VARCHAR(255),
    `course_name`         VARCHAR(255),
    `professor`           VARCHAR(255),
    `campus`              VARCHAR(255),
    `schedules`           VARCHAR(1000),
    `credit`              INT,
    `theory`              INT,
    `practice`            INT,
    `lecture_type`        VARCHAR(255),
    `lecture_category`    VARCHAR(255),
    `lecture_language`    VARCHAR(255),
    `requirement_type`    VARCHAR(255),
    `offering_college`    VARCHAR(255),
    `offering_department` VARCHAR(255),
    `remarks`             VARCHAR(255),
    PRIMARY KEY (`course_id`)
);

DROP TABLE IF EXISTS `evaluation`;

CREATE TABLE `evaluation`
(
    `evaluation_id` BIGINT AUTO_INCREMENT,
    `base_code`     VARCHAR(255),
    `professor`     VARCHAR(255),
    `year`          INT,
    `semester`      INT,
    `score`         FLOAT,
    PRIMARY KEY (`evaluation_id`)
);

DROP TABLE IF EXISTS `avg`;

CREATE TABLE `avg`
(
    `avg_id`    BIGINT AUTO_INCREMENT,
    `base_code` varchar(255) NULL,
    `professor` varchar(255) NULL,
    `avg_score` float NULL,
    PRIMARY KEY (`avg_id`)
);

SHOW
TABLES;
DESC course;
DESC evaluation;
DESC avg;