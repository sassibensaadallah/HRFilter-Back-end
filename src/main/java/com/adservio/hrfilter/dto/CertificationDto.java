package com.adservio.hrfilter.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CertificationDto {
	private boolean isVariation;
	private String name;
	private boolean matchedFromList;

	private String date;

	
	
}
