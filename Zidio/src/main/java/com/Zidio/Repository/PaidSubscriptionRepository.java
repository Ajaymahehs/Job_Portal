package com.Zidio.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Zidio.Entity.PaidSubscription;

@Repository
public interface PaidSubscriptionRepository extends JpaRepository<PaidSubscription,Long>{
	List<PaidSubscription> findByRecruiterEmail(String recruiterEmail);
	List<PaidSubscription> findByEmployeeEmail(String employeeEmail);
	List<PaidSubscription>findByUserEmail(String userEmail);
}
