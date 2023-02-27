package com.adservio.hrfilter.repository;

import com.adservio.hrfilter.data.model.Certification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CertificationRepository extends JpaRepository<Certification, Long> {
    List<Certification> findByName(String name);
}
