package com.spencer.checklist.model;

import java.util.List;

import com.spencer.checklist.entity.Task;

import lombok.Data;

@Data
public class BigProject {
	String name;
	List<Task> tasks;
}
