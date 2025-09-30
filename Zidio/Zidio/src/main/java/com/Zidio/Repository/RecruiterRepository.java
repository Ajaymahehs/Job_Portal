package com.Zidio.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Zidio.Entity.Recruiter;



@Repository
public interface RecruiterRepository extends JpaRepository<Recruiter, Long>{
	Optional<Recruiter> findByRecruiterEmail(String recruiterEmail);
}
