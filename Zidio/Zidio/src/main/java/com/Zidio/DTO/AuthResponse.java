package com.Zidio.DTO;

import com.Zidio.Enum.Role;

public class AuthResponse {
	public String token;
	public Role role;
	public String message;
	
	public AuthResponse(String token,Role role,String message) {
		this.token = token;
		this.role=role;
		this.message=message;
}
}
