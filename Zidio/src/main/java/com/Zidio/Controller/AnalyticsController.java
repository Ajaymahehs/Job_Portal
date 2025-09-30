package com.Zidio.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Zidio.DTO.AnalyticsResponse;
import com.Zidio.Service.AnalyticsService;

@RestController
	@RequestMapping("/api/v1/analytics")
	public class AnalyticsController {
		

    @Autowired
    private AnalyticsService analyticsService;
    
    @GetMapping("/summary")
    public AnalyticsResponse getAnalytics(@RequestHeader("Authorization") String token) {
        return analyticsService.collectData(token);
    }

	}
