package com.adservio.hrfilter.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SkillDto {
    private String category;
    private List<String> skillList;
}
