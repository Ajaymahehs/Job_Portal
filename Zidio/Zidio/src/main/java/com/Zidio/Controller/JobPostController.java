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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Zidio.DTO.JobPostDTO;
import com.Zidio.Entity.JobPost;
import com.Zidio.Enum.JobType;
import com.Zidio.Service.JobPostService;


@RestController
@RequestMapping("/api/v1/jobpost")
public class JobPostController {
	@Autowired
	private JobPostService jobPostService;
	
	
	@PostMapping
	public ResponseEntity<JobPost>createJobs(@RequestBody JobPostDTO dto){
		
		return ResponseEntity.ok(jobPostService.createJob(dto));
	}
	
	@GetMapping
	public ResponseEntity<List<JobPost>>getAllJobs(){
		return ResponseEntity.ok(jobPostService.getAllJobs());
	}
	
	@GetMapping("/recruiters/{recruiterEmail}")
	public ResponseEntity<JobPost>getJobByRecruiter(@PathVariable String recruiterEmail){
		return ResponseEntity.ok(jobPostService.getJobByRecruiter(recruiterEmail));
	}
	@GetMapping("/search")
    public ResponseEntity<List<JobPost>> searchJobs(
            @RequestParam(required = false) String jobTitle,
            @RequestParam(required = false) String companyName,
            @RequestParam(required = false) JobType jobType,
            @RequestParam(required = false) String jobLocation,
            @RequestParam(required = false) String skills,
            @RequestParam(required = false) String designation
    ) {
        return ResponseEntity.ok(
            jobPostService.searchJobs(jobTitle, companyName, jobType, jobLocation, skills, designation)
        );
    }
	
	@PutMapping("/{id}")
	public ResponseEntity<JobPost> updateJob(@PathVariable Long id, @RequestBody JobPostDTO dto) {
	    JobPost updatedJob = jobPostService.updateJob(id, dto);
	    return ResponseEntity.ok(updatedJob);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteJob(@PathVariable Long id) {
	    jobPostService.deleteJob(id);
	    return ResponseEntity.noContent().build();
	}

}
