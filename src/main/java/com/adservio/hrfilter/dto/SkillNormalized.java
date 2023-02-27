package com.adservio.hrfilter.dto;

import com.adservio.hrfilter.model.Experience;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor @Data
public class SkillNormalized {
    private String name;
    private String type;
    private Experience monthExperience;

}
