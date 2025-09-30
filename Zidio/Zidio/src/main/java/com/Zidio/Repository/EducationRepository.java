package com.Zidio.Repository;

import com.Zidio.Entity.Education;
import com.Zidio.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface EducationRepository extends JpaRepository<Education, Long> {
    List<Education> findByEmployee(Employee employee);
}
