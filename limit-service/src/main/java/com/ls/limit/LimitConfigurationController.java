package com.ls.limit;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class LimitConfigurationController {
	
//	@Autowired
//	private LimitConfiguration lmtConfig;
	
	@Value("${limit-service.maximum}")
	private int maximum;
	
	@Value("${limit-service.minimum}")
	private int minimum;

	@GetMapping("/limits")
	public LimitConfiguration getLimitConfiguration() {
		return new LimitConfiguration(minimum,maximum);
	}
	
}
