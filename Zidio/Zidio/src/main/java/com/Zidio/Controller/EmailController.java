package com.Zidio.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Zidio.DTO.EmailRequest;
import com.Zidio.Service.EmailService;

@RestController
@RequestMapping("/api/v1/notifications")
public class EmailController {
	@Autowired
	private EmailService emailService;
	
	
	@PostMapping("/email")
	public ResponseEntity<String>sendEmail(@RequestBody EmailRequest request){
		return ResponseEntity.ok(emailService.sendEmail(request));
		
	}
}
