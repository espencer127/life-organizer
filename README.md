# The Life Organizer

Hoping this project can help me organize my life.

## Setup

Create a few MySql databases first. For instance, after running the following scripts, the db can be accessed at `jdbc:mysql://localhost:3306/db_example` -

```sql
create database db_example;

CREATE TABLE db_example.`task` (
  `task_id` smallint unsigned NOT NULL AUTO_INCREMENT,
  `project_name` varchar(225),
  `task_name` varchar(225) NOT NULL,
  PRIMARY KEY (`task_id`)
) ENGINE=InnoDB AUTO_INCREMENT=201 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE db_example.`scheduled_task` (
  `task_id` smallint unsigned NOT NULL AUTO_INCREMENT,
  `task_name` varchar(225) NOT NULL,
  `frequency` varchar(225) NOT NULL,
  `executions` varchar(225) NOT NULL,
  PRIMARY KEY (`task_id`)
) ENGINE=InnoDB AUTO_INCREMENT=201 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE db_example.`week_task` (
  `task_id` smallint unsigned NOT NULL AUTO_INCREMENT,
  `task_name` varchar(225) NOT NULL,
  PRIMARY KEY (`task_id`)
) ENGINE=InnoDB AUTO_INCREMENT=201 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
```