package com.Zidio.DTO;

public class RecruiterDTO {
	public Long id;
	public String recruiterName;
	public String companyName;
	public String recruiterEmail;
	public String recruiterPhone;
	public String designation;
	public String userEmail;



	public RecruiterDTO() {}
	public RecruiterDTO(Long id , String recruiterName,String companyName,String recruiterEmail,String  recruiterPhone,String designation, String userEmail ) {
		
		this.id=id;
		this.recruiterName=recruiterName;
		this.companyName=companyName;
		this.recruiterEmail=recruiterEmail;
		this.recruiterPhone=recruiterPhone;
		this.designation=designation;
		this.userEmail = userEmail;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getRecruiterName() {
		return recruiterName;
	}
	public void setRecruiterName(String recruiterName) {
		this.recruiterName = recruiterName;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getRecruiterEmail() {
		return recruiterEmail;
	}
	public void setRecruiterEmail(String recruiterEmail) {
		this.recruiterEmail = recruiterEmail;
	}
	public String getRecruiterPhone() {
		return recruiterPhone;
	}
	public void setRecruiterPhone(String recruiterPhone) {
		this.recruiterPhone = recruiterPhone;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	
	
}
