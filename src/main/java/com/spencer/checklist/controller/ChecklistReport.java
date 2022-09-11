package com.spencer.checklist.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.spencer.checklist.entity.ScheduledTask;
import com.spencer.checklist.repository.ScheduledTaskRepository;
import com.spencer.checklist.repository.WeekTaskRepository;

@Controller
public class ChecklistReport {
	
	@Autowired
	WeekTaskRepository weekTaskRepository;
	
	@Autowired
	ScheduledTaskRepository scheduledTaskRepository;
	
	@GetMapping("/checklist")
	public String getChecklistReport(Model model) {
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
		
		model.addAttribute("weekTasks", weekTaskRepository.findAll());
		model.addAttribute("newWeekTask", new ScheduledTask());
		model.addAttribute("onceWeekTasks", onceWeekTasks);
		model.addAttribute("twiceWeekTasks", twiceWeekTasks);
		model.addAttribute("onceMonthTasks", onceMonthTasks);
		model.addAttribute("twiceMonthTasks", twiceMonthTasks);
	    
	    
	    
		return "checklist";
	}

}
