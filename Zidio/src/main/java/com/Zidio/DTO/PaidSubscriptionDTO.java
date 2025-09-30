package com.Zidio.DTO;

import java.time.LocalDate;

import com.Zidio.Enum.PaymentStatus;

public class PaidSubscriptionDTO {
	public Long id;
	public String recruiterEmail;
	public String employeeEmail;
	
	public Long planId;
	public Double amount;
	public String currency;
	public String userEmail;
	public LocalDate startDate;
	public LocalDate endDate;
	public PaymentStatus paymentStatus;
	public String invoiceUrl;
	
	public PaidSubscriptionDTO() {}
	public PaidSubscriptionDTO(Long id,String recruiterEmail, String employeeEmail,Long planId,Double amount,String currency,String userEmail,LocalDate startDate,LocalDate endDate,PaymentStatus paymentStatus,String invoiceUrl) 
	{
		this.id = id;
		this.recruiterEmail=recruiterEmail;
		this.employeeEmail = employeeEmail;
		this.planId = planId;
		this.amount = amount;
		this.currency = currency;
		this.userEmail=userEmail;
		this.startDate = startDate;
		this.endDate = endDate;
		this.endDate = endDate;
		this.paymentStatus=paymentStatus;
		this.invoiceUrl = invoiceUrl;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getRecruiterEmail() {
		return recruiterEmail;
	}
	public void setRecruiterEmail(String recruiterEmail) {
		this.recruiterEmail = recruiterEmail;
	}
	public String getEmployeeEmail() {
		return employeeEmail;
	}
	public void setEmployeeEmail(String employeeEmail) {
		this.employeeEmail = employeeEmail;
	}
	public Long getPlanId() {
		return planId;
	}
	public void setPlanId(Long planId) {
		this.planId = planId;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public LocalDate getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
	public PaymentStatus getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(PaymentStatus paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	public String getInvoiceUrl() {
		return invoiceUrl;
	}
	public void setInvoiceUrl(String invoiceUrl) {
		this.invoiceUrl = invoiceUrl;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	
	
}
