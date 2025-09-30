package com.Zidio.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Zidio.DTO.RecruiterDTO;
import com.Zidio.Entity.Recruiter;
import com.Zidio.Service.RecruiterService;


@RestController
@RequestMapping("/api/v1/recruiter")
public class RecruiterController {
	
	@Autowired
	private RecruiterService recruiterService;
	
	@PostMapping("/update")
	public ResponseEntity<Recruiter>saveRecruiter(@RequestBody RecruiterDTO dto){
		return ResponseEntity.ok(recruiterService.createOrUpdateRecruiter(dto));
	}
	
	@GetMapping("/{recruiterEmail}")
	public ResponseEntity<Recruiter>getRecruiter(@PathVariable String recruiterEmail){
		return ResponseEntity.ok(recruiterService.getRecruiterByEmail(recruiterEmail));
	}
	
		@DeleteMapping("/delete/{recruiterEmail}")
	    public ResponseEntity<String> deleteRecruiter(@PathVariable String recruiterEmail) {
	        recruiterService.deleteRecruiterByEmail(recruiterEmail);
	        return ResponseEntity.ok("Recruiter deleted successfully.");
	    }
}
