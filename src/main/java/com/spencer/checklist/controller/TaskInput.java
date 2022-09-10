package com.spencer.checklist.controller;

import lombok.Data;

@Data
public class TaskInput {
	private Long taskId;
	
	private String projectName;
	private String taskName;
}
