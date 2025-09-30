package com.Zidio.DTO;

import com.Zidio.Enum.ApplicationStatus;

public class UpdateApplicationStatusDTO {
	public Long applicationId;
	public ApplicationStatus status;
	
	
	public UpdateApplicationStatusDTO() {}
	public UpdateApplicationStatusDTO(Long applicationId,ApplicationStatus status) {
		this.applicationId=applicationId;
		this.status=status;
	}
    
	public Long getApplicationId() {
		return applicationId;
	}
	public void setApplicationId(Long applicationId) {
		this.applicationId = applicationId;
	}
	public ApplicationStatus getStatus() {
		return status;
	}
	public void setStatus(ApplicationStatus status) {
		this.status = status;
	}

}
