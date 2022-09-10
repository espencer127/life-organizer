package com.spencer.checklist.repository;

import org.springframework.data.repository.CrudRepository;

import com.spencer.checklist.entity.Task;

public interface TaskRepository extends CrudRepository<Task, Long> {

}
