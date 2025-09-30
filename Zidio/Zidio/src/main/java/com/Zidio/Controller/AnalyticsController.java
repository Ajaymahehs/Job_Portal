package com.Zidio.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Zidio.DTO.AnalysticsResponse;
import com.Zidio.Service.AnalyticsService;

@RestController
	@RequestMapping("/api/v1/analystics")
	public class AnalyticsController {
		
		@Autowired
		private AnalyticsService analyticsService;
		
		@GetMapping("/summery")
		public ResponseEntity<AnalysticsResponse> getSummey(){
		return ResponseEntity.ok(analyticsService.collectData());
		}
	}
