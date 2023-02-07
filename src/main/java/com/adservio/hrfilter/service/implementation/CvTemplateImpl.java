package com.adservio.hrfilter.service.implementation;

import com.adservio.hrfilter.data.model.CvTemplate;
import com.adservio.hrfilter.repository.CVTemplateRepository;
import com.adservio.hrfilter.service.ICvTemplateService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CvTemplateImpl implements ICvTemplateService {
    private CVTemplateRepository cvTemplateRepository;
    @Override
    public CvTemplate getOneCvTemplate(Long id) {
        return cvTemplateRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Please enter a correct id!"));
    }
    @Override
    public Page<CvTemplate> getCvTemplates(int page, int size) {
        return cvTemplateRepository.findAll(PageRequest.of(page,size));
    }

    @Override
    public CvTemplate addOrEditCvTemplate(CvTemplate cvTemplate) {
        return cvTemplateRepository.save(cvTemplate);
    }

    @Override
    public void deleteCvTemplate(Long id) {
        cvTemplateRepository.deleteById(id);
    }
}
