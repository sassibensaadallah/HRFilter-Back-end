package com.adservio.hrfilter.controller;

import com.adservio.hrfilter.data.model.CvTemplate;
import com.adservio.hrfilter.service.ICvTemplateService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/cv-templates")
public class CvTemplateController {
    private ICvTemplateService iCvTemplateService;

    @GetMapping
    public Page<CvTemplate> getCvTemplates(@RequestParam(name = "page", defaultValue = "0") int page,
                                           @RequestParam(name = "size", defaultValue = "0") int size){
        return iCvTemplateService.getCvTemplates(page,size);
    }

    @GetMapping("/{id}")
    public CvTemplate getOneTemplate(@PathVariable Long id){
        return iCvTemplateService.getOneCvTemplate(id);
    }

    @PostMapping
    public CvTemplate getOneTemplate(@RequestBody CvTemplate template){
        return iCvTemplateService.addOrEditCvTemplate(template);
    }

    @DeleteMapping("/{id}")
    public void deleteOneTemplate(@PathVariable Long id){
        iCvTemplateService.deleteCvTemplate(id);
    }

}
