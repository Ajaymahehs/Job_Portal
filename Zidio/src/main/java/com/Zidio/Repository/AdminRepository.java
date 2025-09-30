package com.Zidio.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Zidio.Entity.Admin;
import com.Zidio.Enum.Role;

@Repository
public interface AdminRepository extends JpaRepository<Admin,Long>{
	List<Admin>findByRole(Role role);
	Optional<Admin>findByEmail(String email);
	Optional<Admin> findByUserEmail(String userEmail);

}
