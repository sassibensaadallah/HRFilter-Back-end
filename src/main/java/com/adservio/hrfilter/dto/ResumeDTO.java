package com.adservio.hrfilter.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@AllArgsConstructor @NoArgsConstructor
@Data
public class ResumeDTO {
	private String firstName;
	private String lastName;
	private String jobPosition;
	private String createdBy;
	private LocalDateTime creationDate;
	private Long resumeId;

}
