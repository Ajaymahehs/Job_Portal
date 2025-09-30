package com.Zidio.DTO;

public class EmployeeDTO {
	
	public Long id;
	public String firstname;
	public String lastname;
	public String email;
	public String phone;
	public String qualification;
	public String college;
	public String passedoutyear;
	public String resumeURL;
	
	public String certificateName;
    public String certificateIssuedBy;
    public String certificateIssueDate;
    public String certificateURL;
    public String userEmail;

	public EmployeeDTO() {}
	
	public EmployeeDTO(Long id,String firstname,String lastname,String college,String passedoutyear, String email, String phone, String qualification, String resumeURL, String certificateName , String certificateIssuedBy,String certificateIssueDate,String certificateURL,String userEmail) 
	{
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
		this.userEmail =userEmail;

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

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}	
	
	
	
}
