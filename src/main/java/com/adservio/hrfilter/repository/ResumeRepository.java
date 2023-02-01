package com.adservio.hrfilter.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.adservio.hrfilter.data.model.ResumeData;

@Repository
public interface ResumeRepository extends JpaRepository<ResumeData, Long>, JpaSpecificationExecutor<ResumeData>{
	
}
