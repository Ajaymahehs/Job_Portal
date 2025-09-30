package com.Zidio.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.Zidio.DTO.EmployeeDTO;
import com.Zidio.Service.EmployeeService;

@RestController
@RequestMapping("/api/v1/employee")

public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/{email}")
	public ResponseEntity<EmployeeDTO>getEmployee(@PathVariable String email){
		return ResponseEntity.ok(employeeService.getEmployeeByEmail(email));
	}
	
	@PostMapping("/update")
	public ResponseEntity<EmployeeDTO>getUpdateProfile(@RequestBody  EmployeeDTO dto){
		return ResponseEntity.ok(employeeService.updateProfile(dto));
	}
	
	@DeleteMapping("/delete/{email}")
	public ResponseEntity<String> deleteEmployeeByEmail(@PathVariable String email) {
	    employeeService.deleteByEmail(email);
	    return ResponseEntity.ok("Employee with email " + email + " deleted successfully.");
	}


}
