package com.adservio.hrfilter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adservio.hrfilter.model.Response;

@Repository
public interface ResponseRepository extends JpaRepository<Response, Long>{

}
