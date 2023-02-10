package com.adservio.hrfilter.dto;

import lombok.*;

@Data
@AllArgsConstructor @NoArgsConstructor @Builder
public class CvTemplateDTO {
    private Long id;

    private String imageName;
    private String image;
    private String template;

    private String description;

}
