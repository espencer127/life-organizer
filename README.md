# The Life Organizer

Hoping this project can help me organize my life.

### In Progress

Things I'm still actively working on -

* CSS improvements for scheduled tasks - fix vertical text alignment, task rows flowing outside of columns, button styling, etc
* Tracking executions of monthly tasks

### Next In Line

To be taken on after 'in progress' tasks are done -

* Embed the "Add Scheduled Task" inside the 'checklist' page; remove from separate page
* "Big Chunk Projects" Section

### Future Enhancements

Things I'd like to implement -

* Edit week tasks
* "Clear All" for scheduled tasks (to clear out executions at the end of a week)

### Setup

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

You can probably do something like this -

https://fuzzyblog.io/blog/heroku/2019/10/16/importing-your-local-mysql-database-into-heroku.html

Lots of Thymeleaf help -

https://www.baeldung.com/spring-boot-crud-thymeleaf

Some more -

https://www.baeldung.com/thymeleaf-in-spring-mvc


Thymeleaf / CSS stuff -

https://www.baeldung.com/spring-mvc-thymeleaf-conditional-css-classes
(this is mostly correct but the curly brackets are in the wrong place actually)

conditional checkboxes -

https://stackoverflow.com/questions/71930265/how-to-make-a-checkbox-appear-checked-in-thymeleaf
https://riptutorial.com/thymeleaf/example/32025/string-contains

CSS checked class - unused but maybe helpful -

https://developer.mozilla.org/en-US/docs/Web/CSS/:checked
https://stackoverflow.com/questions/44804022/checkbox-css-checked-styling

Thymeleaf path vars - specifically, how to handle multiple path vars in a URL - 

https://www.baeldung.com/spring-thymeleaf-path-variables

The most helpful CSS guide I could find about responsiveness:

https://css-tricks.com/responsive-layouts-fewer-media-queries/