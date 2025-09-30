package com.Zidio.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Zidio.DTO.JobPostDTO;
import com.Zidio.Entity.JobPost;
import com.Zidio.Enum.JobType;
import com.Zidio.Repository.JobPostRepository;

@Service
public class JobPostService {
	
	@Autowired
	private JobPostRepository jobPostRepository;
	
	public JobPost createJob(JobPostDTO dto) {
		JobPost job = new JobPost();
		
		job.setId(dto.id);
		job.setCompanyName(dto.companyName);
		job.setJobDescription(dto.jobDescription);
		job.setJobLocation(dto.jobLocation);
		job.setJobTitle(dto.jobTitle);
		job.setJobType(dto.jobType);
		job.setPostedDate(dto.postedDate);
		job.setDeadlineDate(dto.deadlineDate);
		job.setRecruiterEmail(dto.recruiterEmail);
		job.setDesignation(dto.designation);
		job.setSkills(dto.skills);
		return jobPostRepository.save(job);
		}
	
	public JobPost updateJob(Long jobId, JobPostDTO dto) {
	    JobPost existingJob = jobPostRepository.findById(jobId)
	        .orElseThrow(() -> new RuntimeException("Job not found with ID: " + jobId));

	    existingJob.setCompanyName(dto.companyName);
	    existingJob.setJobDescription(dto.jobDescription);
	    existingJob.setJobLocation(dto.jobLocation);
	    existingJob.setJobTitle(dto.jobTitle);
	    existingJob.setJobType(dto.jobType);
	    existingJob.setPostedDate(dto.postedDate);
	    existingJob.setDeadlineDate(dto.deadlineDate);
	    existingJob.setRecruiterEmail(dto.recruiterEmail);
	    existingJob.setDesignation(dto.designation);
	    existingJob.setSkills(dto.skills);
	    return jobPostRepository.save(existingJob);
	}
	
	public List<JobPost>getAllJobs(){
		return jobPostRepository.findAll();
	}
	
	public JobPost getJobByRecruiter(String recruiterEmail){
		return jobPostRepository.findByRecruiterEmail(recruiterEmail);
	}
	
	public List<JobPost> searchJobs(String jobTitle, String companyName, JobType jobType,
	            String jobLocation, String skills, String designation) {
	return jobPostRepository.findAll().stream()
	.filter(j -> jobTitle == null || j.getJobTitle().equalsIgnoreCase(jobTitle))
	.filter(j -> companyName == null || j.getCompanyName().equalsIgnoreCase(companyName))
	.filter(j -> jobType == null || j.getJobType() == jobType)
	.filter(j -> jobLocation == null || j.getJobLocation().equalsIgnoreCase(jobLocation))
	.filter(j -> skills == null || j.getSkills().toLowerCase().contains(skills.toLowerCase()))
	.filter(j -> designation == null || j.getDesignation().equalsIgnoreCase(designation))
	.collect(Collectors.toList());
	}
	
	public void deleteJob(Long jobId) {
	    if (!jobPostRepository.existsById(jobId)) {
	        throw new RuntimeException("Job not found with ID: " + jobId);
	    }
	    jobPostRepository.deleteById(jobId);
	}
}
