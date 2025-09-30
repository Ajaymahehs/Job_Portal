package com.Zidio.Service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.Zidio.DTO.AnalyticsResponse;


@Service
public class AnalyticsService {
	
	 @Autowired
	    private RestTemplate restTemplate;

	    @Value("${service.auth.url}")
	    private String authUrl;
	    @Value("${service.student.url}")
	    private String studentUrl;
	    @Value("${service.recruiter.url}")
	    private String recruiterUrl;
	    @Value("${service.jobpost.url}")
	    private String jobPostUrl;
	    @Value("${service.application.url}")
	    private String applicationUrl;
	    @Value("${service.fileupload.url}")
	    private String fileUploadUrl;
	    @Value("${service.subscriptionplan.url}")
	    private String subscriptionPlanUrl;
	    @Value("${service.payment.url}")
	    private String paymentUrl;
	    @Value("${service.userpaymentstatus.url}")
	    private String userPaymentStatusUrl;

	    private final Executor executor = Executors.newFixedThreadPool(10);

	    public AnalyticsResponse collectData(String token) {

	        CompletableFuture<Long> auth = asyncGet(authUrl, token);
	        CompletableFuture<Long> students = asyncGet(studentUrl, token);
	        CompletableFuture<Long> recruiters = asyncGet(recruiterUrl, token);
	        CompletableFuture<Long> jobPosts = asyncGet(jobPostUrl, token);
	        CompletableFuture<Long> applications = asyncGet(applicationUrl, token);
	        CompletableFuture<Long> fileUpload = asyncGet(fileUploadUrl, token);
	        CompletableFuture<Long> subscriptionPlan = asyncGet(subscriptionPlanUrl, token);
	        CompletableFuture<Long> payment = asyncGet(paymentUrl, token);
	        CompletableFuture<Long> userPaymentStatus = asyncGet(userPaymentStatusUrl, token);

	        CompletableFuture.allOf(
	            auth, students, recruiters, jobPosts, applications,
	             fileUpload, subscriptionPlan, payment, userPaymentStatus
	        ).join();

	        return new AnalyticsResponse(
	            auth.join(),
	            students.join(),
	            recruiters.join(),
	            jobPosts.join(),
	            applications.join(),	           
	            fileUpload.join(),
	            subscriptionPlan.join(),
	            payment.join(),
	            userPaymentStatus.join()
	        );
	    }
	    
	    private CompletableFuture<Long> asyncGet(String url, String token) {
	        return CompletableFuture.supplyAsync(() -> safeGet(url, token), executor);
	    }

	    private Long safeGet(String url, String token) {
	        try {
	            HttpHeaders headers = new HttpHeaders();
	            headers.set("Authorization", token);

	            HttpEntity<String> entity = new HttpEntity<>(headers);

	            ResponseEntity<Long> response = restTemplate.exchange(
	                url,
	                HttpMethod.GET,
	                entity,
	                Long.class
	            );

	            return response.getBody();
	        } catch (Exception e) {
	            return 0L;
	        }
	    }


}



