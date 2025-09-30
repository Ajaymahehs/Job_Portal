package com.Zidio.Service;

import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.Zidio.DTO.AuditLogDTO;
import com.Zidio.Entity.AuditLog;
import com.Zidio.Repository.AuditLogRepository;

import jakarta.transaction.Transactional;

@Service
public class AuditLogService {

	@Autowired
	private AuditLogRepository auditLogRepository;
	
	
	public String logAction(AuditLogDTO dto) {
		AuditLog log = new AuditLog();
		
		log.setActor(dto.actor);
		log.setAction(dto.action);
		log.setTarget(dto.target);
		log.setTimestamp(dto.timestamp);
		log.setModule(dto.module);
		
		auditLogRepository.save(log);
		return "Audit Log Saved";
	}
	
	public List<AuditLogDTO>getLogByModule(String module)
	{
		return auditLogRepository.findByModule(module).stream().map(this::mapToDTO).collect(Collectors.toList());
	}
	
	public List<AuditLogDTO>findByActor(String actor)
	{
		return auditLogRepository.findByActor(actor).stream().map(this::mapToDTO).collect(Collectors.toList());
	}
	
	private AuditLogDTO mapToDTO(AuditLog log)
	{
		AuditLogDTO dto = new AuditLogDTO();
		dto.setActor(log.getActor());
		dto.setAction(log.getAction());
		dto.setModule(log.getModule());
		dto.setTarget(log.getTarget());
		dto.setTimestamp(log.getTimestamp());
		
		return dto;
	}
	
	@Scheduled(cron = "0 0 2 * * ?") // Every day at 2 AM
    @Transactional
    public void deleteOldLogs() {
        LocalDateTime cutoff = LocalDateTime.now().minusMonths(6);
        auditLogRepository.deleteByTimestampBefore(cutoff);
        System.out.println("Old logs deleted before: " + cutoff);
    }
	
	public void writeLogsToCsv(PrintWriter writer) {
	    List<AuditLog> logs = auditLogRepository.findAll();
	    writer.println("ID,Actor,Action,Target,Timestamp,Module");

	    for (AuditLog log : logs) {
	        writer.printf(
	            "%d,%s,%s,%s,%s,%s%n",
	            log.getId(),
	            escapeCsv(log.getActor()),
	            escapeCsv(log.getAction()),
	            escapeCsv(log.getTarget()),
	            log.getTimestamp(),
	            escapeCsv(log.getModule())
	        );
	    }
	}

	private String escapeCsv(String value) {
	    if (value == null) return "";
	    if (value.contains(",") || value.contains("\"")) {
	        value = "\"" + value.replace("\"", "\"\"") + "\"";
	    }
	    return value;
	}
}
