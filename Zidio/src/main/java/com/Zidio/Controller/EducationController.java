package com.Zidio.Controller;

import com.Zidio.DTO.EducationDTO;
import com.Zidio.Service.EducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/education")
public class EducationController {

    @Autowired
    private EducationService educationService;

    @PostMapping("/education/add")
    public ResponseEntity<EducationDTO> addEducation(@RequestBody EducationDTO dto) {
        return ResponseEntity.ok(educationService.addEducation(dto));
    }
    
    @PutMapping("/education/update")
    public ResponseEntity<EducationDTO> updateEducation(@RequestBody EducationDTO dto) {
        return ResponseEntity.ok(educationService.updateEducation(dto));
    }

    @GetMapping("/education/{email}")
    public ResponseEntity<List<EducationDTO>> getByEmployee(@PathVariable String email) {
        return ResponseEntity.ok(educationService.getEducationByEmail(email));
    }

    @DeleteMapping("/education/delete/{id}")
    public ResponseEntity<Void> deleteEducation(@PathVariable Long id) {
        educationService.deleteEducation(id);
        return ResponseEntity.noContent().build();
    }
    
    @DeleteMapping("/education/delete-all/{email}")
    public ResponseEntity<Void> deleteAllByEmail(@PathVariable String email) {
        educationService.deleteAllByEmail(email);
        return ResponseEntity.noContent().build();
    }

}

