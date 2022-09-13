package com.spencer.checklist.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.spencer.checklist.entity.Task;
import com.spencer.checklist.repository.TaskRepository;
import com.spencer.checklist.service.DateService;

@Controller
public class SmallChunks {
	
	@Autowired
	TaskRepository taskRepository;
	
	@Autowired
	DateService dateService;
	
	@GetMapping("/small-chunks")
	public String getChecklistReport(Model model) {
	    List<Task> tasks = new ArrayList<>(); 
	    
		taskRepository.findAll().forEach(x -> tasks.add(x));
		
	    model.addAttribute("tasks", tasks);
	    model.addAttribute("newTask", new Task());
		
		return "small-chunks";
	}

}
