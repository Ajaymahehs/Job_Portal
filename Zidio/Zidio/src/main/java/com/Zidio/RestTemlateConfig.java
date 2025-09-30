package com.Zidio;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemlateConfig {
	@Bean
	public RestTemplate restTeplate() {
		return new RestTemplate();
	}

}
