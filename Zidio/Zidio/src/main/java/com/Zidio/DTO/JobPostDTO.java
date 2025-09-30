package com.Zidio.DTO;

import java.time.LocalDate;

import com.Zidio.Enum.JobType;

public class JobPostDTO {
	public Long id;
	public String jobTitle;
	public String companyName;
	public String skills;
	public String designation;
	public String jobLocation;
	public JobType jobType;
	public String jobDescription;
	public LocalDate postedDate;
	public LocalDate deadlineDate;

	public String recruiterEmail;
	
	public JobPostDTO() {}
	public JobPostDTO(Long id,String jobTitle, String companyName, String skills, String designation,String jobLocation, JobType jobType, String jobDescription, LocalDate postedDate, LocalDate deadlineDate, String recruiterEmail) 
	{
		this.id=id;
		this.jobTitle = jobTitle;
		this.companyName = companyName;
		this.skills = skills;
		this.designation = designation;
		this.jobLocation = jobLocation;
		this.jobType = jobType;
		this.jobDescription = jobDescription;
		this.postedDate = postedDate;
		this.deadlineDate = deadlineDate;

		this.recruiterEmail = recruiterEmail;
	}
}
