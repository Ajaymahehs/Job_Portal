package com.Zidio.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Zidio.Entity.AuditLog;

@Repository
public interface AuditLogRepository extends JpaRepository<AuditLog,Long>{
	
	List<AuditLog>findByActor(String actor);
	List<AuditLog>findByModule(String module);
}
