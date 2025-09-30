package com.Zidio.Entity;

import jakarta.persistence.*;


@Entity
@Table(name = "plans")
public class SubscriptionPlan {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String name;
	
	private int maxJob;
	private int maxProfiles;
	private int validityDays;
	private int prices;
	
	public SubscriptionPlan() {}
	public SubscriptionPlan(Long id, String name, int maxJob,int maxProfiles,
	int validityDays,int prices)
	{
		this.id=id;
		this.name=name;
		this.maxJob = maxJob;
		this.maxProfiles = maxProfiles;
		this.validityDays = validityDays;
		this.prices = prices;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMaxJob() {
		return maxJob;
	}
	public void setMaxJob(int maxJob) {
		this.maxJob = maxJob;
	}
	public int getMaxProfiles() {
		return maxProfiles;
	}
	public void setMaxProfiles(int maxProfiles) {
		this.maxProfiles = maxProfiles;
	}
	public int getValidityDays() {
		return validityDays;
	}
	public void setValidityDays(int validityDays) {
		this.validityDays = validityDays;
	}
	public int getPrices() {
		return prices;
	}
	public void setPrices(int prices) {
		this.prices = prices;
	}
	
	
}
