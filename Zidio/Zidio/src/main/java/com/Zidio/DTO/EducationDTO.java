package com.Zidio.DTO;

public class EducationDTO {

    private Long id;
    private String institution;
    private String degree;
    private String fieldOfStudy;
    private String startDate;
    private String endDate;
    private String employeeEmail; 

    public EducationDTO() {}

    public EducationDTO(Long id, String institution, String degree, String fieldOfStudy,
                        String startDate, String endDate, String employeeEmail) {
        this.id = id;
        this.institution = institution;
        this.degree = degree;
        this.fieldOfStudy = fieldOfStudy;
        this.startDate = startDate;
        this.endDate = endDate;
        this.employeeEmail = employeeEmail;
    }


    public Long getId() 
    { 
    	return id;
    }

    public void setId(Long id) 
    { 
    	this.id = id;
    	}

    public String getInstitution() 
    { 
    	return institution; 
    }

    public void setInstitution(String institution) 
    { 
    	this.institution = institution;
    }

    
    public String getDegree()
    { 
    	return degree; 
    }

    public void setDegree(String degree)
    {
    	this.degree = degree; 
    }

    public String getFieldOfStudy() 
    { 
    	return fieldOfStudy; 
    }

    public void setFieldOfStudy(String fieldOfStudy) 
    { 
    	this.fieldOfStudy = fieldOfStudy; 
    }

    public String getStartDate()
    { 
    	return startDate;
    }

    public void setStartDate(String startDate) 
    {
    	this.startDate = startDate; 
    	}

    public String getEndDate() 
    { 
    	return endDate; 
    	}

    public void setEndDate(String endDate)
    { 
    	this.endDate = endDate; 
    	}

    public String getEmployeeEmail() 
    { 
    	return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail)
    {
    	this.employeeEmail = employeeEmail;
    }
}
