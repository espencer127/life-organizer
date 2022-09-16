package com.spencer.checklist.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.spencer.checklist.entity.ScheduledTask;
import com.spencer.checklist.entity.Task;
import com.spencer.checklist.repository.ScheduledTaskRepository;
import com.spencer.checklist.repository.TaskRepository;
import com.spencer.checklist.repository.WeekTaskRepository;
import com.spencer.checklist.service.DateService;

@Controller
public class ChecklistReport {
	
	@Autowired
	WeekTaskRepository weekTaskRepository;
	
	@Autowired
	ScheduledTaskRepository scheduledTaskRepository;
	
	@Autowired
	TaskRepository taskRepository;
	
	@Autowired
	DateService dateService;
	
	@GetMapping()
	public String mainForwarder() {
		return "redirect:/checklist";
	}
	
	@GetMapping("/checklist")
	public String getChecklistReport(Model model) {
	    List<ScheduledTask> scheduledTasks = new ArrayList<>();
		scheduledTaskRepository.findAll().forEach(x -> scheduledTasks.add(x));
		
		List<Task> smallChunkTasks = new ArrayList<>(); 
		taskRepository.findAll().forEach(x -> smallChunkTasks.add(x));
		
		model.addAttribute("weekDates", dateService.getWeekDates());
		model.addAttribute("weekTasks", weekTaskRepository.findAll());
		model.addAttribute("newWeekTask", new ScheduledTask());
		
		model.addAttribute("onceWeekTasks", filterScheduledTasks(scheduledTasks, "onceweekly"));
		model.addAttribute("twiceWeekTasks", filterScheduledTasks(scheduledTasks, "twiceweekly"));
		model.addAttribute("onceMonthTasks", filterScheduledTasks(scheduledTasks, "oncemonthly"));
		model.addAttribute("twiceMonthTasks", filterScheduledTasks(scheduledTasks, "twicemonthly"));
	    
		model.addAttribute("thisWeeksSmallChunks", filterSmallChunkTasks(smallChunkTasks, "thisweek"));
		
		return "checklist";
	}
	
	private Object filterSmallChunkTasks(List<Task> smallChunkTasks, String string) {
		return smallChunkTasks.stream()
				.filter(x -> x.getProjectName().toLowerCase().equals(string))
				.collect(Collectors.toList());
	}

	private Object filterScheduledTasks(List<ScheduledTask> scheduledTasks, String timeWindow) {
		return scheduledTasks.stream()
	    		.filter(x -> x.getFrequency().toLowerCase().equals(timeWindow))
	    		.collect(Collectors.toList());
	}

	@GetMapping("/delete-scheduled-task")
	public String deleteScheduledTask(Model model) {
	    List<ScheduledTask> scheduledTasks = new ArrayList<>(); 
		
		scheduledTaskRepository.findAll().forEach(x -> scheduledTasks.add(x));
		
	    List<ScheduledTask> onceWeekTasks = scheduledTasks.stream()
	    		.filter(x -> x.getFrequency().toLowerCase().equals("onceweekly"))
	    		.collect(Collectors.toList());
	    
	    List<ScheduledTask> twiceWeekTasks = scheduledTasks.stream()
	    		.filter(x -> x.getFrequency().toLowerCase().equals("twiceweekly"))
	    		.collect(Collectors.toList());
	    
	    List<ScheduledTask> onceMonthTasks = scheduledTasks.stream()
	    		.filter(x -> x.getFrequency().toLowerCase().equals("oncemonthly"))
	    		.collect(Collectors.toList());
	    
	    List<ScheduledTask> twiceMonthTasks = scheduledTasks.stream()
	    		.filter(x -> x.getFrequency().toLowerCase().equals("twicemonthly"))
	    		.collect(Collectors.toList());
		model.addAttribute("weekDates", dateService.getWeekDates());
		model.addAttribute("weekTasks", weekTaskRepository.findAll());
		model.addAttribute("newWeekTask", new ScheduledTask());
		model.addAttribute("onceWeekTasks", onceWeekTasks);
		model.addAttribute("twiceWeekTasks", twiceWeekTasks);
		model.addAttribute("onceMonthTasks", onceMonthTasks);
		model.addAttribute("twiceMonthTasks", twiceMonthTasks);
	    
	    
		return "delete-scheduled-task";
	}

}
