package com.spencer.checklist.model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Day {
	LocalDate date;
	String formattedDate;
	Boolean isToday;
}
