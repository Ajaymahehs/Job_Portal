package com.Zidio.DTO;

public class UserStatusUpdateDTO {
	public String email;
	public boolean active;
	
	
	public UserStatusUpdateDTO() {}
	public UserStatusUpdateDTO(String email,boolean active) {
		this.email=email;
		this.active=active;
		
	}

	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}

}
