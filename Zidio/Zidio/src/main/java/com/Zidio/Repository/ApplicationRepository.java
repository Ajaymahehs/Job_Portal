package com.Zidio.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Zidio.Entity.Application;
import com.Zidio.Enum.ApplicationStatus;

@Repository
public interface ApplicationRepository extends JpaRepository<Application,Long>{
	List<Application>findByEmployeeEmail(String employeeEmail);
	List<Application>findByRecruiterEmail(String recruiterEmail);
	List<Application>findByJobId(Long jobId);
	Optional<Application> findById(Long id);
	List<Application> findByStatus(ApplicationStatus status);
	
	boolean existsByJobIdAndEmployeeEmail(Long jobId, String employeeEmail);


}
