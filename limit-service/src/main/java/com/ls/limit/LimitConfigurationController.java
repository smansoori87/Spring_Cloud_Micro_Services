package com.ls.limit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitConfigurationController {
	
	@Autowired
	private LimitConfiguration lmtConfig;
	
	@GetMapping("/limits")
	public LimitConfiguration getLimitConfiguration() {
		return new LimitConfiguration(lmtConfig.getMinimum(),lmtConfig.getMaximum());
	}
	
}
