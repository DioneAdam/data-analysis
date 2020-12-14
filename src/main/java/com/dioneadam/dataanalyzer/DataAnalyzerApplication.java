package com.dioneadam.dataanalyzer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class DataAnalyzerApplication {

	public static void main(String[] args) {
		SpringApplication.run(DataAnalyzerApplication.class, args);
	}

}
