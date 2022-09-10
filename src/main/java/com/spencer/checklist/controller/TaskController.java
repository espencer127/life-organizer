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

import com.spencer.checklist.entity.Task;
import com.spencer.checklist.repository.TaskRepository;

@Controller
@RequestMapping("/task")
public class TaskController {

	@Autowired
	private TaskRepository taskRepository;
	
	@GetMapping("/hi")
	@ResponseBody
	public String hi() {
		return "hi";
	}
	
	@GetMapping("/get")
	@ResponseBody
	public List<Task> getTasks() {
		return getTaskList();
	}
	
	@GetMapping("/get/{taskId}")
	@ResponseBody
	public Task getTask(@PathVariable Long taskId) {
		return taskRepository.findById(taskId).get();
	}
	
	@PutMapping("/put")
	@ResponseBody
	public List<Task> putTasks(@RequestBody TaskInput taskInput) {
		Task saveTask = Task.builder().projectName(taskInput.getProjectName())
				.taskName(taskInput.getTaskName()).build();
		taskRepository.save(saveTask);

		return getTaskList();
	}
	
	@PostMapping("/delete/{id}")
	@ResponseBody
	public List<Task> deleteTask(@PathVariable Long taskId) {
		taskRepository.deleteById(taskId);
		return getTaskList();
	}
	
	private List<Task> getTaskList() {
		Iterable<Task> tasks = taskRepository.findAll();
		List<Task> taskList = new ArrayList<>();
		
		for (Task task : tasks) {
			taskList.add(task);
		}
		
		return taskList;
		
	}
}
