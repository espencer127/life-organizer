package com.spencer.checklist.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Task {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long taskId;
	
	private String projectName;
	private String taskName;
}
