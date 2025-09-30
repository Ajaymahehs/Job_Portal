package com.Zidio.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Zidio.Repository.EmployeeRepository;
import com.Zidio.DTO.EmployeeDTO;
import com.Zidio.Entity.Employee;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	public EmployeeDTO getEmployeeByEmail(String email) {
		Employee emp= employeeRepository.findByEmail(email);
		if (emp==null)return null ;
			return new EmployeeDTO(
					emp.getId(),
					emp.getFirstname(),
					emp.getLastname(),
					emp.getEmail(),
					emp.getPhone(),
					emp.getCollege(),
					emp.getPassedoutyear(),
					emp.getQualification(),
					emp.getResumeURL(),
					emp.getCertificateName(),
			        emp.getCertificateIssuedBy(),
			        emp.getCertificateIssueDate(),
			        emp.getCertificateURL());
					
		
	}
	public EmployeeDTO updateProfile(EmployeeDTO dto) {
	    Employee emp = employeeRepository.findByEmail(dto.email);

	    if (emp == null) {
	        emp = new Employee(); 
	        emp.setEmail(dto.email); 
	    }


	    emp.setFirstname(dto.firstname);
	    emp.setLastname(dto.lastname);
	    emp.setPhone(dto.phone);
	    emp.setCollege(dto.college);
	    emp.setPassedoutyear(dto.passedoutyear);
	    emp.setQualification(dto.qualification);
	    emp.setResumeURL(dto.resumeURL);
	    emp.setCertificateName(dto.certificateName);
	    emp.setCertificateIssuedBy(dto.certificateIssuedBy);
	    emp.setCertificateIssueDate(dto.certificateIssueDate);
	    emp.setCertificateURL(dto.certificateURL);

	    Employee saved = employeeRepository.save(emp);

	    return new EmployeeDTO(
	            saved.getId(),
	            saved.getFirstname(),
	            saved.getLastname(),
	            saved.getEmail(),
	            saved.getPhone(),
	            saved.getCollege(),
	            saved.getPassedoutyear(),
	            saved.getQualification(),
	            saved.getResumeURL(),
	            saved.getCertificateName(),
	            saved.getCertificateIssuedBy(),
	            saved.getCertificateIssueDate(),
	            saved.getCertificateURL());
	}
	
	public void deleteByEmail(String email) {
	    Employee emp = employeeRepository.findByEmail(email);
	    if (emp == null) {
	        throw new RuntimeException("Employee not found with email: " + email);
	    }
	    employeeRepository.delete(emp);
	}


}
