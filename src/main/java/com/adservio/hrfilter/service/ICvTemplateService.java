package com.adservio.hrfilter.service;

import com.adservio.hrfilter.data.model.CvTemplate;
import org.springframework.data.domain.Page;


public interface ICvTemplateService {
    CvTemplate getOneCvTemplate(Long id);
    Page<CvTemplate> getCvTemplates(int page, int size);
    CvTemplate addOrEditCvTemplate(CvTemplate cvTemplate);
    void deleteCvTemplate(Long id);
}
