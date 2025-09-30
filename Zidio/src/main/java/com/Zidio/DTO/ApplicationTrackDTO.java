package com.Zidio.DTO;


public class ApplicationTrackDTO {
    
	public String date;
	public long totalApplications;

	public long pending;
	public long accepted;
	public long rejected;

    public ApplicationTrackDTO() {}

    public ApplicationTrackDTO(String date, long totalApplications, long pending, long accepted, long rejected) {
        this.date = date;
        this.totalApplications = totalApplications;
        this.pending = pending;
        this.accepted = accepted;
        this.rejected = rejected;
    }

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public long getTotalApplications() {
		return totalApplications;
	}

	public void setTotalApplications(long totalApplications) {
		this.totalApplications = totalApplications;
	}

	public long getPending() {
		return pending;
	}

	public void setPending(long pending) {
		this.pending = pending;
	}

	public long getAccepted() {
		return accepted;
	}

	public void setAccepted(long accepted) {
		this.accepted = accepted;
	}

	public long getRejected() {
		return rejected;
	}

	public void setRejected(long rejected) {
		this.rejected = rejected;
	}

  
}

	
	
	

