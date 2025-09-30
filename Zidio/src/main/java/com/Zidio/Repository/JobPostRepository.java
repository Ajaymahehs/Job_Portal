package com.Zidio.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Zidio.Entity.JobPost;
import com.Zidio.Enum.JobType;

@Repository
public interface JobPostRepository extends JpaRepository<JobPost, Long>{
	JobPost findByRecruiterEmail(String recruiterEmail);
	
	
	List<JobPost>findByJobTitle(String jobTitle);
	List<JobPost>findByCompanyName(String companyName);
	List<JobPost>findByJobType(JobType jobType);
	List<JobPost>findByJobLocation(String jobLocation);
	
	List<JobPost>findBySkills(String skills);
	List<JobPost>findByDesignation(String designation);
	
}
