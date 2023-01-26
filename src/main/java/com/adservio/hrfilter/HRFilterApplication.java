package com.adservio.hrfilter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages = {"com.adservio.hrfilter.controller","com.adservio.hrfilter.service","com.adservio.hrfilter.repository"})
public class HRFilterApplication {

	public static void main(String[] args) {
		SpringApplication.run(HRFilterApplication.class, args);
	}

}
