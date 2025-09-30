package com.Zidio.DTO;

import com.Zidio.Enum.Role;

public class AdminDTO {
	public Long id;
	public String email;
	public Role role;
	public boolean active;
	public String userEmail;
	
	public AdminDTO() {}
	public AdminDTO(Long id,String email,Role role,boolean active,String userEmail) {
		this.id=id;
		this.email=email;
		this.role=role;
		this.active=active;
		this.userEmail = userEmail;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	
}
