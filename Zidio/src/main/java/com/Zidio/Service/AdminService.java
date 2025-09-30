package com.Zidio.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Zidio.DTO.AdminDTO;
import com.Zidio.DTO.SystemStatusDTO;
import com.Zidio.DTO.UserStatusUpdateDTO;
import com.Zidio.Entity.Admin;
import com.Zidio.Entity.User;
import com.Zidio.Enum.Role;
import com.Zidio.Repository.AdminRepository;
import com.Zidio.Repository.ApplicationRepository;
import com.Zidio.Repository.JobPostRepository;
import com.Zidio.Repository.UserRepository;

@Service
public class AdminService {
	@Autowired
	private AdminRepository adminRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private JobPostRepository jobPostRepository;
	
	@Autowired
	private ApplicationRepository applicationRepository;
	
	
	
	
	 public List<AdminDTO> getAllUsers() {
	     
	        List<AdminDTO> admins = adminRepository.findAll()
	                .stream()
	                .map(this::toDTO1)
	                .collect(Collectors.toList());

	        // Get registered users from User table
	        List<AdminDTO> registeredUsers = userRepository.findAll()
	                .stream()
	                .map(this::toDTOFromUser1)
	                .collect(Collectors.toList());

	        // Merge both lists
	        List<AdminDTO> allUsers = new ArrayList<>();
	        allUsers.addAll(admins);
	        allUsers.addAll(registeredUsers);

	        return allUsers;
	    }

	    private AdminDTO toDTO1(Admin admin) {
	        AdminDTO dto = new AdminDTO();
	        dto.setId(admin.getId());
	        dto.setEmail(admin.getEmail());
	        dto.setRole(admin.getRole());
	        dto.setActive(admin.isActive());
	        return dto;
	    }

	    private AdminDTO toDTOFromUser1(User user) {
	        AdminDTO dto = new AdminDTO();
	        dto.setId(user.getId());
	        dto.setEmail(user.getEmail());
	        dto.setRole(user.getRole()); // assuming User also has Role
	        dto.setActive(user.isActive());
	        return dto;
	    }
	
	    public List<AdminDTO> getUserByRole(Role role) {
	        List<AdminDTO> result = new ArrayList<>();

	        // From Admin table
	        result.addAll(
	            adminRepository.findByRole(role)
	                .stream()
	                .map(this::toDTO1)
	                .collect(Collectors.toList())
	        );

	        // From User table
	        result.addAll(
	            userRepository.findByRole(role) // You must add this method in UserRepository
	                .stream()
	                .map(this::toDTOFromUser1)
	                .collect(Collectors.toList())
	        );

	        return result;
	    }

	    public AdminDTO updateUserStatus(UserStatusUpdateDTO dto) {
	        // Try Admin first
	        Optional<Admin> optionalAdmin = adminRepository.findByEmail(dto.email);
	        if (optionalAdmin.isPresent()) {
	            Admin admin = optionalAdmin.get();
	            admin.setActive(dto.active);
	            adminRepository.save(admin);
	            return toDTO1(admin);
	        }

	        // Try User
	        Optional<User> optionalUser = userRepository.findByEmail(dto.email);
	        if (optionalUser.isPresent()) {
	            User user = optionalUser.get();
	            user.setActive(dto.active);
	            userRepository.save(user);
	            return toDTOFromUser1(user);
	        }

	        throw new RuntimeException("User not found in either Admin or User table");
	    }

	    public SystemStatusDTO getSystemStatus() {
	        int totalUsers = (int) (adminRepository.count() + userRepository.count());
	        int totalEmployees = (int) (adminRepository.findByRole(Role.STUDENT).size() +
	                                     userRepository.findByRole(Role.STUDENT).size());
	        int totalRecruiters = (int) (adminRepository.findByRole(Role.RECRUITER).size() +
	                                      userRepository.findByRole(Role.RECRUITER).size());

	        int totalJobPosts = (int) jobPostRepository.count();
	        int totalApplications = (int) applicationRepository.count();

	        SystemStatusDTO status = new SystemStatusDTO();
	        status.setTotalUsers(totalUsers);
	        status.setTotalEmployees(totalEmployees);
	        status.setTotalRecruiters(totalRecruiters);
	        status.setTotalJobPosts(totalJobPosts);
	        status.setTotalApplicatiions(totalApplications);

	        return status;
	    }

}
