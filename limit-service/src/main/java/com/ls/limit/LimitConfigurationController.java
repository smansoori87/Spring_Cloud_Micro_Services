package com.ls.limit;

import org.springframework.web.bind.annotation.GetMapping;

public class LimitConfigurationController {

	@GetMapping("/limits")
	public LimitConfiguration getLimitConfiguration() {
		return new LimitConfiguration(1000,1);
	}
	
}
