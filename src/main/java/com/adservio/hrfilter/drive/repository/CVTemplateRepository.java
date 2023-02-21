package com.adservio.hrfilter.drive.repository;

import com.adservio.hrfilter.drive.entity.CvTemplate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CVTemplateRepository extends JpaRepository<CvTemplate, Long> {
}
