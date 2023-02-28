package com.adservio.hrfilter.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LanguageDto {
	private String foundInContext;
	private String language;
	private String languageCode;
	private String level;

}
