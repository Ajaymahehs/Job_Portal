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
	
	public EmployeeDTO() {}
	
	public EmployeeDTO(Long id,String firstname,String lastname,String college,String passedoutyear, String email, String phone, String qualification, String resumeURL, String certificateName , String certificateIssuedBy,String certificateIssueDate,String certificateURL) 
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
	}	
}
