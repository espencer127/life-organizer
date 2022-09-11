package com.spencer.checklist.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spencer.checklist.entity.WeekTask;
import com.spencer.checklist.repository.WeekTaskRepository;

@Controller
@RequestMapping("/weekTask")
public class WeekTaskController {

	@Autowired
	private WeekTaskRepository taskRepository;
	
	@GetMapping("/hi")
	@ResponseBody
	public String hi() {
		return "hi";
	}
	
	@GetMapping("/get")
	@ResponseBody
	public List<WeekTask> getTasks() {
		return getTaskList();
	}
	
	@GetMapping("/get/{taskId}")
	@ResponseBody
	public WeekTask getTask(@PathVariable Long taskId) {
		return taskRepository.findById(taskId).get();
	}
	
	@PutMapping("/create")
	@ResponseBody
	public List<WeekTask> putTasks(@RequestBody WeekTask taskInput) {
		WeekTask saveTask = WeekTask.builder()
				.taskName(taskInput.getTaskName()).build();
		taskRepository.save(saveTask);

		return getTaskList();
	}
	
	
	@PostMapping("/ui/create")
    public String addUser(WeekTask task, Model model) {        
        taskRepository.save(task);
        return "redirect:/checklist";
    }
	
	@PostMapping("/delete/{taskId}")
	@ResponseBody
	public List<WeekTask> deleteTask(@PathVariable Long taskId) {
		taskRepository.deleteById(taskId);
		return getTaskList();
	}
	
	@GetMapping("/ui/delete/{taskId}")
	public String uiDeleteTask(@PathVariable Long taskId) {
		taskRepository.deleteById(taskId);
	    return "redirect:/checklist";
	}
	
	private List<WeekTask> getTaskList() {
		Iterable<WeekTask> tasks = taskRepository.findAll();
		List<WeekTask> taskList = new ArrayList<>();
		
		for (WeekTask task : tasks) {
			taskList.add(task);
		}
		
		return taskList;
		
	}
}
