package com.adservio.hrfilter.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
@Data @AllArgsConstructor @NoArgsConstructor
public class SkillRow {
    private String id;
    private String name;

    private String type;

    private Experience monthsExperience;
    private List<Taxonomy> Taxonomies= new ArrayList<>();

}
