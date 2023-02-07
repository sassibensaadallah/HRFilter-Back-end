package com.adservio.hrfilter.repository;

import com.adservio.hrfilter.data.model.CvTemplate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CVTemplateRepository extends JpaRepository<CvTemplate, Long> {
}
