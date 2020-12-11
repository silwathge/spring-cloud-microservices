package com.kapila.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallBackController {
	
	@RequestMapping("/studentFallBack")
	public String studentServiceFallBack() {
		//return Mono.just("dsfdsfadsfdsa asdfsdafsda");
		return "class service not abailable";
	}
	
	@RequestMapping("/classFallBack")
	public String classServiceFallBack() {
		
		return "class service not abailable";
	}
	

}
