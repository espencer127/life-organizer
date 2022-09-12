package com.spencer.checklist.service;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

import org.junit.jupiter.api.Test;


class DateServiceTest {

	/**
	 * 9-11 is a sunday. It should be the first day of the week.
	 */
	@Test
	void test_today() {

		Clock clock = Clock.fixed(Instant.parse("2022-09-11T10:15:30.00Z"), ZoneId.of("America/New_York"));

		DateService service = new DateService(clock);
		LocalDate firstDay = service.getFirstDateOfThisWeek();
		LocalDate lastDay = service.getLastDateOfThisWeek();

	    assertEquals(11,firstDay.getDayOfMonth());
	    assertEquals(17,lastDay.getDayOfMonth());
	    assertTrue(service.doesTargetDateEqualToday(firstDay));
	    
	    assertTrue(service.getWeekDates().getSunday().getIsToday());
	    assertFalse(service.getWeekDates().getMonday().getIsToday());
	}
	
	/**
	 * 9-10 is a saturday. The first day of the week should be the 4th.
	 */
	@Test
	void test_yesterday() {
		Clock clock = Clock.fixed(Instant.parse("2022-09-10T10:15:30.00Z"), ZoneId.of("America/New_York"));

		DateService service = new DateService(clock);
		LocalDate firstDay = service.getFirstDateOfThisWeek();
		LocalDate lastDay = service.getLastDateOfThisWeek();

	    assertEquals(4,firstDay.getDayOfMonth());
	    assertEquals(10,lastDay.getDayOfMonth());

	    assertTrue(service.getWeekDates().getSaturday().getIsToday());
	    assertFalse(service.getWeekDates().getMonday().getIsToday());
	}

}
