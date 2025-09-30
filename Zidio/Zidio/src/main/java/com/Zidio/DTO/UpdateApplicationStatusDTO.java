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
	public Long getApplicatiionId() {
		return applicationId;
	}
	public void setApplicatiionId(Long applicatiionId) {
		this.applicationId = applicatiionId;
	}
	public ApplicationStatus getStatus() {
		return status;
	}
	public void setStatus(ApplicationStatus status) {
		this.status = status;
	}

}
