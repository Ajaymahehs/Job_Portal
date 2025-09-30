package com.Zidio.DTO;

import java.time.LocalDateTime;

public class AuditLogDTO {
	public Long id;
	public String actor;
	public String action;
	public String target;
	
	public LocalDateTime timestamp;
	
	public String module;
	public AuditLogDTO() {}
	public AuditLogDTO(Long id,String actor,String action,String target, LocalDateTime timestamp,String module)
	{
		this.id = id;
		this.actor = actor;
		this.action = action;
		this.target = target;
		this.timestamp = timestamp;
		this.module = module;
		
		
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getActor() {
		return actor;
	}
	public void setActor(String actor) {
		this.actor = actor;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public String getTarget() {
		return target;
	}
	public void setTarget(String target) {
		this.target = target;
	}
	public LocalDateTime getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
	public String getModule() {
		return module;
	}
	public void setModule(String module) {
		this.module = module;
	}
}
