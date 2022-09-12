package com.spencer.checklist.service;

import java.time.Clock;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spencer.checklist.model.Day;
import com.spencer.checklist.model.Week;

@Service
public class DateService {
	static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEE MM-dd");
	
	@Autowired
	private Clock clock;
	
	public DateService(Clock clock) {
		this.clock = clock;
	}

	public Week getWeekDates() {
		
		int[] plusDays = {0,1,2,3,4,5,6};
		List<Day> dayList = new ArrayList<>();
		
		for (int day : plusDays) {
			LocalDate date = getFirstDateOfThisWeek().plusDays(day);
			String dateString = getDayString(date);
			Boolean dateIsFirstDay = doesTargetDateEqualToday(date);
			dayList.add(Day.builder().date(date).formattedDate(dateString).isToday(dateIsFirstDay).build());
		}
		
		Week week = Week.builder()
				.Sunday(dayList.get(0))
				.Monday(dayList.get(1))
				.Tuesday(dayList.get(2))
				.Wednesday(dayList.get(3))
				.Thursday(dayList.get(4))
				.Friday(dayList.get(5))
				.Saturday(dayList.get(6))
				.build();

		return week;
	}
	
	public String getDayString(LocalDate date) {
		return formatter.format(date);
	}
	
	public Boolean doesTargetDateEqualToday(LocalDate target) {
		LocalDate today = LocalDate.ofInstant(clock.instant(), clock.getZone());
		
		return today.equals(target);
	}
	
	public LocalDate getFirstDateOfThisWeek() {
		LocalDate today = LocalDate.ofInstant(clock.instant(), clock.getZone());

	    LocalDate firstDateOfThatWeek = today.with(TemporalAdjusters.previousOrSame(DayOfWeek.SUNDAY));
	    
		return firstDateOfThatWeek;
	}
	
	public LocalDate getLastDateOfThisWeek() {
		LocalDate today = LocalDate.ofInstant(clock.instant(), clock.getZone());

	    LocalDate lastDateOfThatWeek = today.with(TemporalAdjusters.nextOrSame(DayOfWeek.SATURDAY));
	    
		return lastDateOfThatWeek;
	}

}
