package com.Zidio.Controller;

import java.io.ByteArrayInputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Zidio.DTO.PaidSubscriptionDTO;
import com.Zidio.Service.PaidSubscriptionService;

@RestController
@RequestMapping("/api/v1/subscription")
public class PaidSubscriptionController {
	
	@Autowired 
	private PaidSubscriptionService paidSubscriptionService;
	
	@PostMapping
	public ResponseEntity<PaidSubscriptionDTO>subscription(@RequestBody PaidSubscriptionDTO dto){
		return ResponseEntity.ok(paidSubscriptionService.createSubscription(dto));
	}
	
	@GetMapping("/user/email/{userEmail}")
	public ResponseEntity<List<PaidSubscriptionDTO>> getSubscriptionByUserEmail(@PathVariable String userEmail){
		return ResponseEntity.ok(paidSubscriptionService.getSubscriptionByUserEmail(userEmail));
	}
	
	@GetMapping("/user/employee/{employeeEmail}")
	public ResponseEntity<List<PaidSubscriptionDTO>> getSubscriptionByEmployeeId(@PathVariable String employeeEmail){
		return ResponseEntity.ok(paidSubscriptionService.getSubscriptionByEmployeeEmail(employeeEmail));
	}
	
	@GetMapping("/user/recruiter/{recruiterEmail}")
	public ResponseEntity<List<PaidSubscriptionDTO>> getSubscriptionByRecruiterId(@PathVariable String recruiterEmail){
		return ResponseEntity.ok(paidSubscriptionService.getSubscriptionByRecruiterEmail(recruiterEmail));
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<PaidSubscriptionDTO>>getAll()
	{
		return ResponseEntity.ok(paidSubscriptionService.getAll());
	}
	
	@GetMapping("/invoice/{id}")
	public ResponseEntity<InputStreamResource> downloadInvoice(@PathVariable Long id) {
	    ByteArrayInputStream invoice = paidSubscriptionService.generationInvoice(id);

	    HttpHeaders headers = new HttpHeaders();
	    headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=invoice_" + id + ".pdf");

	    return ResponseEntity.ok()
	            .headers(headers)
	            .contentType(MediaType.APPLICATION_PDF)
	            .body(new InputStreamResource(invoice));
	}

	
	@GetMapping("/internal/count")
	public long getPaidSubscriptionCount() {
	    return paidSubscriptionService.getPaidSubscriptionCount();
	}
}
