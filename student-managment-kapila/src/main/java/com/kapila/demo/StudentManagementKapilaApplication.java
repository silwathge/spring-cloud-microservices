package com.kapila.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class StudentManagementKapilaApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentManagementKapilaApplication.class, args);
	}

}
