package com.Zidio.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.Zidio.Entity.User;
import com.Zidio.Enum.Role;

public interface UserRepository extends JpaRepository<User, Long> {
  
	Optional<User> findByEmail(String email);
    Optional<User> findByResetToken(String resetToken);
    
    List<User> findByRole(Role role);
    long countByResumeUrlIsNotNullAndResumeUrlNot(String emptyString);
}
