package com.Zidio.DTO;

public class AnalyticsResponse {
	private Long totalAuth;
	private Long totalStudents;
	private Long totalRecruiters;
	private Long totalJobPosts;
	private Long totalApplications;
	private Long totalFileUpload;
	private Long totalSubscriptionPlan;
	private Long totalPayment;
	private Long totalUserPaymentStatus;
	
	public AnalyticsResponse() {}
	
	public AnalyticsResponse(Long totalAuth,
			Long totalStudents,
			Long totalRecruiters,
			Long totalJobPosts,
			Long totalApplications,
			Long totalFileUplaod,
			
			Long totalSubscriptionPlan,
			Long totalPayment,
			Long totalUserPaymentStatus) {
		
		this.totalAuth=totalAuth;
		this.totalStudents=totalStudents;
		this.totalRecruiters=totalRecruiters;
		this.totalJobPosts=totalJobPosts;
		this.totalApplications=totalApplications;
		this.totalFileUpload=totalFileUplaod;
	
		this.totalSubscriptionPlan=totalSubscriptionPlan;
		this.totalPayment=totalPayment;
		this.totalUserPaymentStatus=totalUserPaymentStatus;
	}

	public Long getTotalAuth() {
		return totalAuth;
	}

	public void setTotalAuth(Long totalAuth) {
		this.totalAuth = totalAuth;
	}

	public Long getTotalStudents() {
		return totalStudents;
	}

	public void setTotalStudents(Long totalStudents) {
		this.totalStudents = totalStudents;
	}

	public Long getTotalRecruiters() {
		return totalRecruiters;
	}

	public void setTotalRecruiters(Long totalRecruiters) {
		this.totalRecruiters = totalRecruiters;
	}

	public Long getTotalJobPosts() {
		return totalJobPosts;
	}

	public void setTotalJobPosts(Long totalJobPosts) {
		this.totalJobPosts = totalJobPosts;
	}

	public Long getTotalApplications() {
		return totalApplications;
	}

	public void setTotalApplications(Long totalApplications) {
		this.totalApplications = totalApplications;
	}

	public Long getTotalFileUpload() {
		return totalFileUpload;
	}

	public void setTotalFileUpload(Long totalFileUpload) {
		this.totalFileUpload = totalFileUpload;
	}



	public Long getTotalSubscriptionPlan() {
		return totalSubscriptionPlan;
	}

	public void setTotalSubscriptionPlan(Long totalSubscriptionPlan) {
		this.totalSubscriptionPlan = totalSubscriptionPlan;
	}

	public Long getTotalPayment() {
		return totalPayment;
	}

	public void setTotalPayment(Long totalPayment) {
		this.totalPayment = totalPayment;
	}

	public Long getTotalUserPaymentStatus() {
		return totalUserPaymentStatus;
	}

	public void setTotalUserPaymentStatus(Long totalUserPaymentStatus) {
		this.totalUserPaymentStatus = totalUserPaymentStatus;
	}
	
	
}
