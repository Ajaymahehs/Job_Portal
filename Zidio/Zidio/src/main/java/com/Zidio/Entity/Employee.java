package com.Zidio.Entity;

import jakarta.persistence.*;

@Entity
@Table(name="employees")
public class Employee {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private Long id;
	private String firstname;
	private String lastname;
	private String phone;
	private String qualification;
	private String college;
	private String passedoutyear;
	private String resumeURL;
	private String certificateName;
	private String certificateIssuedBy;
    private String certificateIssueDate;
    private String certificateURL;
	@Column(unique = true, nullable = false)
	private String email;
	
	
	
	
	

	
	public Employee() {}
	
	public Employee(Long id,String firstname,String lastname,String email,String phone,String qualification,String college,String passedoutyear,String resumeURL, String certificateName , String certificateIssuedBy,String certificateIssueDate,String certificateURL) {
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.phone = phone;
		this.qualification = qualification;
		this.college = college;
		this.passedoutyear = passedoutyear;
		this.resumeURL = resumeURL;
		this.certificateName = certificateName;
		this.certificateIssuedBy = certificateIssuedBy;
		this.certificateIssueDate = certificateIssueDate;
		this.certificateURL = certificateURL;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	
	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getCollege() {
		return college;
	}

	public void setCollege(String college) {
		this.college = college;
	}

	public String getPassedoutyear() {
		return passedoutyear;
	}

	public void setPassedoutyear(String passedoutyear) {
		this.passedoutyear = passedoutyear;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	public String getResumeURL() {
		return resumeURL;
	}
	public void setResumeURL(String resumeURL) {
		this.resumeURL = resumeURL;
	}

	public String getCertificateName() {
		return certificateName;
	}

	public void setCertificateName(String certificateName) {
		this.certificateName = certificateName;
	}

	public String getCertificateIssuedBy() {
		return certificateIssuedBy;
	}

	public void setCertificateIssuedBy(String certificateIssuedBy) {
		this.certificateIssuedBy = certificateIssuedBy;
	}

	public String getCertificateIssueDate() {
		return certificateIssueDate;
	}

	public void setCertificateIssueDate(String certificateIssueDate) {
		this.certificateIssueDate = certificateIssueDate;
	}

	public String getCertificateURL() {
		return certificateURL;
	}

	public void setCertificateURL(String certificateURL) {
		this.certificateURL = certificateURL;
	}



}
