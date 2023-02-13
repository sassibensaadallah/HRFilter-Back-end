package com.adservio.hrfilter.service;

import com.adservio.hrfilter.data.model.CvTemplate;
import com.adservio.hrfilter.dto.CvTemplateDTO;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;


public interface ICvTemplateService {
    CvTemplate getOneCvTemplate(Long id);
    List<CvTemplateDTO> getCvTemplates() throws GeneralSecurityException, IOException;
    CvTemplate addCvTemplate(CvTemplateDTO cvTemplate) throws GeneralSecurityException, IOException;

    CvTemplate updateCvTemplate(CvTemplateDTO cvTemplate) throws GeneralSecurityException, IOException;
    void deleteCvTemplate(Long id) throws GeneralSecurityException, IOException;
}
