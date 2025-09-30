package com.Zidio.Entity;

import java.time.LocalDate;

import com.Zidio.Enum.JobType;

import jakarta.persistence.*;

@Entity
@Table(name="jobPost")
public class JobPost {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String jobTitle;
	private String companyName;
	private String skills;
	private String designation;
	private String jobLocation;
	private JobType jobType;
	private String jobDescription;
	private LocalDate postedDate;
	private LocalDate deadlineDate;
	@Column(unique=true)
	
	private String recruiterEmail;
	public JobPost() {}
	public JobPost(Long id,String jobTitle, String companyName, String skills,String designation,String jobLocation, JobType jobType, String jobDescription, LocalDate postedDate, LocalDate deadlineDate, String recruiterEmail) 
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
		this.recruiterEmail  = recruiterEmail;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getJobLocation() {
		return jobLocation;
	}
	public void setJobLocation(String jobLocation) {
		this.jobLocation = jobLocation;
	}
	public JobType getJobType() {
		return jobType;
	}
	public void setJobType(JobType jobType) {
		this.jobType = jobType;
	}
	public String getJobDescription() {
		return jobDescription;
	}
	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}
	public LocalDate getPostedDate() {
		return postedDate;
	}
	public void setPostedDate(LocalDate postedDate) {
		this.postedDate = postedDate;
	}
	public LocalDate getDeadlineDate() {
		return deadlineDate;
	}
	public void setDeadlineDate(LocalDate deadlineDate) {
		this.deadlineDate = deadlineDate;
	}

	public String getRecruiterEmail() {
		return recruiterEmail;
	}
	public void setRecruiterEmail(String recruiterEmail) {
		this.recruiterEmail = recruiterEmail;
	}
	public String getSkills() {
		return skills;
	}
	public void setSkills(String skills) {
		this.skills = skills;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	
	
}
