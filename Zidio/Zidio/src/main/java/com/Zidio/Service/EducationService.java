package com.Zidio.Service;

import com.Zidio.DTO.EducationDTO;
import com.Zidio.Entity.Education;
import com.Zidio.Entity.Employee;
import com.Zidio.Repository.EducationRepository;
import com.Zidio.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EducationService {

    @Autowired
    private EducationRepository educationRepo;

    @Autowired
    private EmployeeRepository employeeRepo;

    public EducationDTO addEducation(EducationDTO dto) {
        Employee employee = employeeRepo.findByEmail(dto.getEmployeeEmail());
        if (employee == null) {
            throw new RuntimeException("Employee not found with email: " + dto.getEmployeeEmail());
        }

        Education education = new Education(
                dto.getInstitution(),
                dto.getDegree(),
                dto.getFieldOfStudy(),
                dto.getStartDate(),
                dto.getEndDate(),
                employee
        );

        education = educationRepo.save(education);
        return toDTO(education);
    }
    
    public EducationDTO updateEducation(EducationDTO dto) {
        Education education = educationRepo.findById(dto.getId())
                .orElseThrow(() -> new RuntimeException("Education not found with ID: " + dto.getId()));

        // Update fields
        education.setInstitution(dto.getInstitution());
        education.setDegree(dto.getDegree());
        education.setFieldOfStudy(dto.getFieldOfStudy());
        education.setStartDate(dto.getStartDate());
        education.setEndDate(dto.getEndDate());

        // Optionally reassign employee if needed
        if (dto.getEmployeeEmail() != null && !dto.getEmployeeEmail().equals(education.getEmployee().getEmail())) {
            Employee employee = employeeRepo.findByEmail(dto.getEmployeeEmail());
            if (employee == null) {
                throw new RuntimeException("Employee not found with email: " + dto.getEmployeeEmail());
            }
            education.setEmployee(employee);
        }

        education = educationRepo.save(education);
        return toDTO(education);
    }


    public List<EducationDTO> getEducationByEmail(String email) {
        Employee employee = employeeRepo.findByEmail(email);
        if (employee == null) {
            throw new RuntimeException("Employee not found with email: " + email);
        }

        return educationRepo.findByEmployee(employee)
                .stream().map(this::toDTO).collect(Collectors.toList());
    }

    public void deleteEducation(Long id) {
        educationRepo.deleteById(id);
    }

    private EducationDTO toDTO(Education education) {
        return new EducationDTO(
                education.getId(),
                education.getInstitution(),
                education.getDegree(),
                education.getFieldOfStudy(),
                education.getStartDate(),
                education.getEndDate(),
                education.getEmployee().getEmail() 
        );
    }
    
    public void deleteAllByEmail(String email) {
        Employee employee = employeeRepo.findByEmail(email);
        if (employee == null) {
            throw new RuntimeException("Employee not found with email: " + email);
        }
        List<Education> educations = educationRepo.findByEmployee(employee);
        educationRepo.deleteAll(educations);
    }
}
