package com.spencer.checklist.repository;

import org.springframework.data.repository.CrudRepository;

import com.spencer.checklist.entity.ScheduledTask;

public interface ScheduledTaskRepository extends CrudRepository<ScheduledTask, Long> {

}
