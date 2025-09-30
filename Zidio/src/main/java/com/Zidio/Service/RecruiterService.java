package com.Zidio.Service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Zidio.DTO.RecruiterDTO;
import com.Zidio.Entity.Recruiter;
import com.Zidio.Entity.User;
import com.Zidio.Repository.RecruiterRepository;
import com.Zidio.Repository.UserRepository;



@Service
public class RecruiterService {
	
	@Autowired
	private RecruiterRepository recruiterRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	public Recruiter createOrUpdateRecruiter(RecruiterDTO dto) {
		
		 User user = userRepository.findByEmail(dto.getUserEmail())
		            .orElseThrow(() -> new RuntimeException("User not found with id: " + dto.getUserEmail()));

		    // ✅ check active status
		    if (!user.isActive()) {
		        throw new RuntimeException("Recruiter cannot be created/updated because the user is not active");
		    }
	    Optional<Recruiter> existing = recruiterRepository.findByUserEmail(dto.getUserEmail());
	    Recruiter recruiter = existing.orElse(new Recruiter());

	    recruiter.setUser(
	        userRepository.findByEmail(dto.getUserEmail())
	            .orElseThrow(() -> new RuntimeException("User not found with id: " + dto.getUserEmail()))
	    );
	    recruiter.setRecruiterName(dto.getRecruiterName());
	    recruiter.setCompanyName(dto.getCompanyName());
	    recruiter.setRecruiterEmail(dto.getRecruiterEmail());
	    recruiter.setRecruiterPhone(dto.getRecruiterPhone());
	    recruiter.setDesignation(dto.getDesignation());

	    return recruiterRepository.save(recruiter);
	}


	
	public Recruiter getRecruiterByEmail(String recruiterEmail) {
		return recruiterRepository.findByRecruiterEmail(recruiterEmail).orElseThrow(()-> new RuntimeException("Recruiter not found"));
	}
	
	public Recruiter getRecruiterByID(Long id) {
		return recruiterRepository.findById(id).orElseThrow(()-> new RuntimeException("Recruiter not found"));
	}

	
	public Recruiter clearRecruiterDetailsByEmail(String recruiterEmail) {
	    Recruiter recruiter = recruiterRepository.findByRecruiterEmail(recruiterEmail)
	            .orElseThrow(() -> new RuntimeException("Recruiter not found"));

	    // clear all details except id and userEmail
	    recruiter.setRecruiterName(null);
	    recruiter.setCompanyName(null);
	    recruiter.setRecruiterEmail(null);
	    recruiter.setRecruiterPhone(null);
	    recruiter.setDesignation(null);

	    return recruiterRepository.save(recruiter);
	}

	
	public long getRecruiterCount() {
	    return recruiterRepository.count();
	}
}
