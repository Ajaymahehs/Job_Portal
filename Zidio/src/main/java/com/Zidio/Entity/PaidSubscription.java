package com.Zidio.Entity;

import java.time.LocalDate;

import com.Zidio.Enum.PaymentStatus;

import jakarta.persistence.*;



@Entity
@Table(name = "paidsubscription")
public class PaidSubscription {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private Long id;
	private String recruiterEmail;
	private String employeeEmail;
	
	private Long planId;
	private Double amount;
	private String currency;
	private String userEmail;
	private LocalDate startDate;
	private LocalDate endDate;
	private PaymentStatus paymentStatus;
	private String invoiceUrl;
	
	public PaidSubscription() {}
	public PaidSubscription(Long id,String recruiterEmail, String employeeEmail,Long planId,Double amount,String currency,String userEmail,LocalDate startDate,LocalDate endDate,PaymentStatus paymentStatus,String invoiceUrl) 
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
	
	public Long getPlanId() {
		return planId;
	}
	public void setPlanId(Long planId) {
		this.planId = planId;
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
	public String getInvoiceUrl() {
		return invoiceUrl;
	}
	public void setInvoiceUrl(String invoiceUrl) {
		this.invoiceUrl = invoiceUrl;
	}
	public PaymentStatus getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(PaymentStatus paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
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
	
}
