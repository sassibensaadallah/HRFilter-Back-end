package com.adservio.hrfilter.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adservio.hrfilter.data.model.ResumeData;

public interface ResumeRepository extends JpaRepository<ResumeData, Long> {

}
