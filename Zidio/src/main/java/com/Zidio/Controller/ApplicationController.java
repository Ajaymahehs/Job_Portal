package com.Zidio.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Zidio.DTO.ApplicationDTO;
import com.Zidio.DTO.UpdateApplicationStatusDTO;
import com.Zidio.Enum.ApplicationStatus;
import com.Zidio.Service.ApplicationService;

@RestController
@RequestMapping("/api/v1/applications")	
public class ApplicationController {
	
	@Autowired
	private ApplicationService applicationService;
	
	
	@PostMapping("/apply")
	public ResponseEntity<String>apply(@RequestBody ApplicationDTO dto ){
		applicationService.applyJob(dto);
		return ResponseEntity.ok("Application Submited");
		
	}

	
	@GetMapping("/job/employee/{employeeEmail}")
	public ResponseEntity<List<ApplicationDTO>> getByEmployeeEmail(@PathVariable String employeeEmail) {
	    return ResponseEntity.ok(applicationService.getByEmployeeEmail(employeeEmail));
	}
										
	
	@GetMapping("/job/recruiter/{recruiterEmail}")
	public ResponseEntity<List<ApplicationDTO>> getByRecruiterEmail(@PathVariable String recruiterEmail) {
	    return ResponseEntity.ok(applicationService.getByRecruiterEmail(recruiterEmail));
	}

	
	@GetMapping("/job/{jobId}")
	public ResponseEntity<List<ApplicationDTO>>getByJobId(@PathVariable Long jobId){
		return ResponseEntity.ok(applicationService.getByJobId(jobId));
	}
	
	
	@PutMapping("/update/status")
	public ResponseEntity<String>updateApplicationStatus(@RequestBody UpdateApplicationStatusDTO dto){
		applicationService.updateApplicationStatus(dto);
		return ResponseEntity.ok("Status Update ");
	}	
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteApplication(@PathVariable Long id) {
	    applicationService.deleteApplication(id);
	    return ResponseEntity.ok("Application deleted successfully.");
	}
	
	@GetMapping("/status/{status}")
	public ResponseEntity<List<ApplicationDTO>> getByStatus(@PathVariable ApplicationStatus status) {
	    return ResponseEntity.ok(applicationService.getByStatus(status));
	}
	
	@GetMapping("/internal/count")
	public long getApplicationCount() {
	    return applicationService.getApplicationCount();
	}
}
