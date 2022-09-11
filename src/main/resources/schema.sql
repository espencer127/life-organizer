CREATE TABLE task (
  `task_id` smallint unsigned NOT NULL AUTO_INCREMENT,
  `project_name` varchar(225),
  `task_name` varchar(225) NOT NULL,
  PRIMARY KEY (`task_id`)
) ENGINE=InnoDB AUTO_INCREMENT=201 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE scheduled_task (
  `task_id` smallint unsigned NOT NULL AUTO_INCREMENT,
  `task_name` varchar(225) NOT NULL,
  `frequency` varchar(225) NOT NULL,
  `executions` varchar(225) NOT NULL,
  PRIMARY KEY (`task_id`)
) ENGINE=InnoDB AUTO_INCREMENT=201 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE week_task (
  `task_id` smallint unsigned NOT NULL AUTO_INCREMENT,
  `task_name` varchar(225) NOT NULL,
  PRIMARY KEY (`task_id`)
) ENGINE=InnoDB AUTO_INCREMENT=201 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;