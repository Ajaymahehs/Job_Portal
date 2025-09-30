package com.Zidio.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Zidio.Repository.EmployeeRepository;
import com.Zidio.Repository.UserRepository;
import com.Zidio.DTO.EmployeeDTO;
import com.Zidio.Entity.Employee;
import com.Zidio.Entity.User;

@Service
public class EmployeeService {
	
	@Autowired
	private UserRepository userRepository;
	
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	public Employee getEmployeeByEmail(String email) {
		return employeeRepository.findByEmail(email).orElseThrow(()-> new RuntimeException("Employee not found"));
	}
	
	
	public Employee UpdateEmployee(EmployeeDTO dto) {
		
		 User user = userRepository.findByEmail(dto.getUserEmail())
		            .orElseThrow(() -> new RuntimeException("User not found with id: " + dto.getUserEmail()));

		    // ✅ check active status
		    if (!user.isActive()) {
		        throw new RuntimeException("Employee cannot be created/updated because the user is not active");
		    }
	    Optional<Employee> existing = employeeRepository.findByUserEmail(dto.getUserEmail());
	    Employee employee = existing.orElse(new Employee());

	    employee.setUser(
	        userRepository.findByEmail(dto.getUserEmail())
	            .orElseThrow(() -> new RuntimeException("User not found with id: " + dto.getUserEmail()))
	    );
	    employee.setFirstname(dto.getFirstname());
	    employee.setLastname(dto.getLastname());
	    employee.setEmail(dto.getEmail());
	    employee.setPhone(dto.getPhone());
	    employee.setCollege(dto.getCollege());
	    employee.setQualification(dto.getQualification());
	    employee.setPassedoutyear(dto.getPassedoutyear());
	    employee.setResumeURL(dto.getResumeURL());
	    employee.setCertificateName(dto.getCertificateName());
	    employee.setCertificateIssuedBy(dto.getCertificateIssuedBy());
	    employee.setCertificateIssueDate(dto.getCertificateIssueDate());
	    employee.setCertificateURL(dto.getCertificateURL());

	    
	   

	    return employeeRepository.save(employee);
	}
	
	public void deleteEmployeeDataButKeepIdAndUserEmail(String email) {
	    Employee employee = employeeRepository.findByEmail(email)
	            .orElseThrow(() -> new RuntimeException("Employee not found"));

	    // keep id and userEmail, wipe everything else
	    employee.setFirstname(null);
	    employee.setLastname(null);
	    employee.setPhone(null);
	    employee.setCollege(null);
	    employee.setQualification(null);
	    employee.setPassedoutyear(null);
	    employee.setResumeURL(null);
	    employee.setCertificateName(null);
	    employee.setCertificateIssuedBy(null);
	    employee.setCertificateIssueDate(null);
	    employee.setCertificateURL(null);

	    employeeRepository.save(employee);
	}


	public long getEmployeeCount() {
	    return employeeRepository.count();
	}

}
