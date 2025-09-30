package com.Zidio.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.Zidio.DTO.EmployeeDTO;
import com.Zidio.Entity.Employee;
import com.Zidio.Service.EmployeeService;

@RestController
@RequestMapping("/api/v1/employee")

public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/{email}")
	public ResponseEntity<Employee> getEmployeeByEmail(@PathVariable String email){
		return ResponseEntity.ok(employeeService.getEmployeeByEmail(email));
	}
	
	@PostMapping("/update")
	public ResponseEntity<Employee> getUpdateProfile(@RequestBody  EmployeeDTO dto){
		return ResponseEntity.ok(employeeService.UpdateEmployee(dto));
	}
	
	@DeleteMapping("/softdelete/{email}")
	public ResponseEntity<String> softDeleteEmployeeData(@PathVariable String email) {
	    employeeService.deleteEmployeeDataButKeepIdAndUserEmail(email);
	    return ResponseEntity.ok("Employee data cleared but record retained with ID and userEmail.");
	}


	@GetMapping("/internal/count")
	public long getEmployeeCount() {
	    return employeeService.getEmployeeCount();
	}

}
