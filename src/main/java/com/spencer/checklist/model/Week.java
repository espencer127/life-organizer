package com.spencer.checklist.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Week {
	private Day Sunday;
	private Day Monday;
	private Day Tuesday;
	private Day Wednesday;
	private Day Thursday;
	private Day Friday;
	private Day Saturday;
}
