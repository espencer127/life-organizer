package com.spencer.checklist.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spencer.checklist.entity.ScheduledTask;
import com.spencer.checklist.repository.ScheduledTaskRepository;

@Controller
@RequestMapping("/scheduledTask")
public class ScheduledTaskController {

	@Autowired
	private ScheduledTaskRepository taskRepository;
	
	@GetMapping("/hi")
	@ResponseBody
	public String hi() {
		return "hi";
	}
	
	@GetMapping("/get")
	@ResponseBody
	public List<ScheduledTask> getTasks() {
		return getTaskList();
	}
	
	@GetMapping("/get/{taskId}")
	@ResponseBody
	public ScheduledTask getTask(@PathVariable Long taskId) {
		return taskRepository.findById(taskId).get();
	}
	
	@PutMapping("/put")
	@ResponseBody
	public List<ScheduledTask> putTasks(@RequestBody ScheduledTask taskInput) {
		//ScheduledTask saveTask = ScheduledTask.builder().projectName(taskInput.getProjectName())
				//.taskName(taskInput.getTaskName()).build();
		taskRepository.save(taskInput);

		return getTaskList();
	}
	
	@PostMapping("/delete/{id}")
	@ResponseBody
	public List<ScheduledTask> deleteTask(@PathVariable Long taskId) {
		taskRepository.deleteById(taskId);
		return getTaskList();
	}
	
	private List<ScheduledTask> getTaskList() {
		Iterable<ScheduledTask> tasks = taskRepository.findAll();
		List<ScheduledTask> taskList = new ArrayList<>();
		
		for (ScheduledTask task : tasks) {
			taskList.add(task);
		}
		
		return taskList;
		
	}
}
