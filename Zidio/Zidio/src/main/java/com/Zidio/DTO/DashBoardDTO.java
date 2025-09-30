package com.Zidio.DTO;

public class DashBoardDTO {
    private long totalEmployee;
    private long totalRecruiter;
    private long totalJobs;
    private long totalApplication;

    private long activeEmployees;
    private long inactiveEmployees;

    private long activeRecruiters;
    private long inactiveRecruiters;

    private long activeJobs;
    private long closedJobs;

    private long pendingApplications;
    private long selectedApplications;
    private long rejectedApplications;

    private long totalPaidSubscriptions;

    public DashBoardDTO() {}

    public DashBoardDTO(
        long totalEmployee,
        long totalRecruiter,
        long totalJobs,
        long totalApplication,
        long activeEmployees,
        long inactiveEmployees,
        long activeRecruiters,
        long inactiveRecruiters,
        long activeJobs,
        long closedJobs,
        long pendingApplications,
        long selectedApplications,
        long rejectedApplications,
        long totalPaidSubscriptions
    ) {
        this.totalEmployee = totalEmployee;
        this.totalRecruiter = totalRecruiter;
        this.totalJobs = totalJobs;
        this.totalApplication = totalApplication;
        this.activeEmployees = activeEmployees;
        this.inactiveEmployees = inactiveEmployees;
        this.activeRecruiters = activeRecruiters;
        this.inactiveRecruiters = inactiveRecruiters;
        this.activeJobs = activeJobs;
        this.closedJobs = closedJobs;
        this.pendingApplications = pendingApplications;
        this.selectedApplications = selectedApplications;
        this.rejectedApplications = rejectedApplications;
        this.totalPaidSubscriptions = totalPaidSubscriptions;
        
    }

	public long getTotalEmployee() {
		return totalEmployee;
	}

	public void setTotalEmployee(long totalEmployee) {
		this.totalEmployee = totalEmployee;
	}

	public long getTotalRecruiter() {
		return totalRecruiter;
	}

	public void setTotalRecruiter(long totalRecruiter) {
		this.totalRecruiter = totalRecruiter;
	}

	public long getTotalJobs() {
		return totalJobs;
	}

	public void setTotalJobs(long totalJobs) {
		this.totalJobs = totalJobs;
	}

	public long getTotalApplication() {
		return totalApplication;
	}

	public void setTotalApplication(long totalApplication) {
		this.totalApplication = totalApplication;
	}

	public long getActiveEmployees() {
		return activeEmployees;
	}

	public void setActiveEmployees(long activeEmployees) {
		this.activeEmployees = activeEmployees;
	}

	public long getInactiveEmployees() {
		return inactiveEmployees;
	}

	public void setInactiveEmployees(long inactiveEmployees) {
		this.inactiveEmployees = inactiveEmployees;
	}

	public long getActiveRecruiters() {
		return activeRecruiters;
	}

	public void setActiveRecruiters(long activeRecruiters) {
		this.activeRecruiters = activeRecruiters;
	}

	public long getInactiveRecruiters() {
		return inactiveRecruiters;
	}

	public void setInactiveRecruiters(long inactiveRecruiters) {
		this.inactiveRecruiters = inactiveRecruiters;
	}

	public long getActiveJobs() {
		return activeJobs;
	}

	public void setActiveJobs(long activeJobs) {
		this.activeJobs = activeJobs;
	}

	public long getClosedJobs() {
		return closedJobs;
	}

	public void setClosedJobs(long closedJobs) {
		this.closedJobs = closedJobs;
	}

	public long getPendingApplications() {
		return pendingApplications;
	}

	public void setPendingApplications(long pendingApplications) {
		this.pendingApplications = pendingApplications;
	}

	public long getSelectedApplications() {
		return selectedApplications;
	}

	public void setSelectedApplications(long selectedApplications) {
		this.selectedApplications = selectedApplications;
	}

	public long getRejectedApplications() {
		return rejectedApplications;
	}

	public void setRejectedApplications(long rejectedApplications) {
		this.rejectedApplications = rejectedApplications;
	}

	public long getTotalPaidSubscriptions() {
		return totalPaidSubscriptions;
	}

	public void setTotalPaidSubscriptions(long totalPaidSubscriptions) {
		this.totalPaidSubscriptions = totalPaidSubscriptions;
	}

    

}
