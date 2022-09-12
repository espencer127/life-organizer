package com.spencer.checklist.config;

import java.time.Clock;
import java.util.Calendar;
import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

	@Bean
	public Clock clock() {
	    return Clock.systemDefaultZone();
	}
	
	@Bean
	public Calendar calendar() {
		return Calendar.getInstance(Locale.US);
	}
}
