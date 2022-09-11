package com.spencer.checklist.repository;

import org.springframework.data.repository.CrudRepository;

import com.spencer.checklist.entity.WeekTask;

public interface WeekTaskRepository extends CrudRepository<WeekTask, Long> {

}
