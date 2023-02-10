package com.adservio.hrfilter.controller;

import com.adservio.hrfilter.data.model.CvTemplate;
import com.adservio.hrfilter.dto.CvTemplateDTO;
import com.adservio.hrfilter.service.ICvTemplateService;
import com.adservio.hrfilter.service.implementation.GoogleCredentialService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/cv-templates")
@Slf4j
public class CvTemplateController {
    private ICvTemplateService iCvTemplateService;

    private GoogleCredentialService googleCredentialService;


    @GetMapping
    public List<CvTemplateDTO> getCvTemplates() throws IOException, GeneralSecurityException {

        return  iCvTemplateService.getCvTemplates();
    }

    @GetMapping("/{id}")
    public CvTemplate getOneTemplate(@PathVariable Long id) {
        return iCvTemplateService.getOneCvTemplate(id);
    }

    @PostMapping
    public CvTemplate getOneTemplate(@RequestBody CvTemplateDTO template) throws IOException, GeneralSecurityException{
        return iCvTemplateService.addOrEditCvTemplate(template);
    }

    @DeleteMapping("/{id}")
    public void deleteOneTemplate(@PathVariable Long id){
        iCvTemplateService.deleteCvTemplate(id);
    }

}
