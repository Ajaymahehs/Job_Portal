package com.Zidio.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.Zidio.DTO.AnalysticsResponse;


@Service
public class AnalyticsService {
	

	@Autowired
	private RestTemplate restTemplate;
	
	public AnalysticsResponse collectData() {
		Long students= restTemplate.getForObject("http://student-service/internal/count", Long.class);
		Long recruiters= restTemplate.getForObject("http://recruiter-service/internal/count", Long.class);
		Long jobPosts= restTemplate.getForObject("http://jobPost-service/internal/count", Long.class);
		Long applications= restTemplate.getForObject("http://applcation-service/internal/count", Long.class);
		Long auth=restTemplate.getForObject("http://auth-service/internal/count", Long.class);
		Long admins=restTemplate.getForObject("http://admin-service/internal/count", Long.class);
		Long email=restTemplate.getForObject("http://email-service/internal/count", Long.class);
		Long fileUpload=restTemplate.getForObject("http://admin-service/internal/count", Long.class);
		Long subsciptionPlan=restTemplate.getForObject("http://subscriptiionPlan-service/internal/count", Long.class);
		Long payment=restTemplate.getForObject("http://payment-service/internal/count", Long.class);
		Long userPaymentStatus=restTemplate.getForObject("http://userPaymentStatus-service/internal/count", Long.class);
		
		
		
		return new AnalysticsResponse(students,
				recruiters,
				jobPosts,
				auth,
				applications,
				admins,
				email,
				fileUpload,
				subsciptionPlan,
				payment,userPaymentStatus);
	}
}



