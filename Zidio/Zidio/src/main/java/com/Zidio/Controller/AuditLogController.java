package com.Zidio.Controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Zidio.DTO.AuditLogDTO;
import com.Zidio.Service.AuditLogService;

@RestController
@RequestMapping("/api/v1/auditlogs")
public class AuditLogController {
	
	@Autowired
	private AuditLogService auditLogService;
	
	@PostMapping
	public ResponseEntity<String> logAction(@RequestBody AuditLogDTO dto)
	{
		dto.setTimestamp(LocalDateTime.now()); 
		auditLogService.logAction(dto);
		return ResponseEntity.ok("Log Saved");
	}
	
	@GetMapping("/log/{module}")
	public ResponseEntity<List<AuditLogDTO>> getLogByModule(@PathVariable String module)
	{
		return ResponseEntity.ok(auditLogService.getLogByModule(module));
	}
	
	@GetMapping("/log/{actor}")
	public ResponseEntity<List<AuditLogDTO>> findByActor(@PathVariable String actor)
	{
		return ResponseEntity.ok(auditLogService.findByActor(actor));
	}
	
}
