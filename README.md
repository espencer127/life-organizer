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


Setup maven stuff - 

https://elements.heroku.com/buildpacks/heroku/heroku-buildpack-java

Setup Clear DB -

https://devcenter.heroku.com/articles/cleardb

Clear DB will give you access to import dump files, but not to run create scripts. If you have a database locally, you can do a 'dump' of it. Then connect to your Clear DB with your DB tool (like MySQL Workbench). Then, import the dump files into that schema.