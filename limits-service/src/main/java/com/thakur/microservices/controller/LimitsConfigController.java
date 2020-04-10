package com.thakur.microservices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thakur.microservices.config.LimitsConfiguration;

@RestController
public class LimitsConfigController {
	
	@Autowired
	LimitsConfiguration limitsConfig;
	

	@GetMapping("/limits")
	public LimitsConfiguration getLimitConfiguration() {
		
		return new LimitsConfiguration(limitsConfig.getMinimum(),limitsConfig.getMaximum());
	}
}