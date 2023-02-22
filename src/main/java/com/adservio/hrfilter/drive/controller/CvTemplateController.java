package com.adservio.hrfilter.drive.controller;

import com.adservio.hrfilter.drive.service.ICvTemplateService;
import com.adservio.hrfilter.dto.CvTemplateDTO;
import com.adservio.hrfilter.utils.ApiResponseHandler;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;
import java.security.GeneralSecurityException;

@RestController
@AllArgsConstructor
@RequestMapping("/cv-templates")
@Slf4j
@CrossOrigin(origins = "*")
public class CvTemplateController {
    private ICvTemplateService iCvTemplateService;
    @GetMapping
    public ResponseEntity<Object> getCvTemplates(){
        try {
            return ApiResponseHandler
                    .generateResponse(HttpStatus.OK, true,
                            "CV TEMPLATE LIST SUCCESSFULLY GOT",
                            iCvTemplateService.getCvTemplates());
        }catch (Exception e){
            return ApiResponseHandler
                    .generateResponse(HttpStatus.OK, false,
                            e.getMessage(),
                            null);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneTemplate(@PathVariable Long id) {
        try {
            return ApiResponseHandler
                    .generateResponse(HttpStatus.OK, true,
                            "CV TEMPLATE WITH ID :"+id,
                    iCvTemplateService.getOneCvTemplate(id));
        }catch (Exception e){
            return ApiResponseHandler
                    .generateResponse(HttpStatus.OK, false,
                            e.getMessage(),
                            null);
        }
    }

    @PostMapping
    public ResponseEntity<Object> createTemplate(@RequestBody CvTemplateDTO template) throws IOException, GeneralSecurityException{
        template.setId(null);
        try {
            return ApiResponseHandler
                    .generateResponse(HttpStatus.OK, true,
                            "CV TEMPLATE SUCCESSFULLY CREATED",
                            iCvTemplateService.addCvTemplate(template));
        }catch (Exception e){
            return ApiResponseHandler
                    .generateResponse(HttpStatus.OK, false,
                            e.getMessage(),
                            null);
        }
    }

    @PutMapping
    public ResponseEntity<Object> updateTemplate(@RequestBody CvTemplateDTO template) throws IOException, GeneralSecurityException{
        template.setId(null);
        try {
            return ApiResponseHandler
                    .generateResponse(HttpStatus.OK, true,
                            "CV TEMPLATE SUCCESSFULLY UPDATED",
                            iCvTemplateService.updateCvTemplate(template));
        }catch (Exception e){
            return ApiResponseHandler
                    .generateResponse(HttpStatus.OK, false,
                            e.getMessage(),
                            null);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteOneTemplate(@PathVariable Long id) throws GeneralSecurityException, IOException {
        try {
            iCvTemplateService.deleteCvTemplate(id);
            return ApiResponseHandler
                    .generateResponse(HttpStatus.OK, true,
                            "CV TEMPLATE SUCCESSFULLY DELETED", null);
        }catch (Exception e){
            return ApiResponseHandler
                    .generateResponse(HttpStatus.OK, false,
                            e.getMessage(),
                            null);
        }
    }
}
