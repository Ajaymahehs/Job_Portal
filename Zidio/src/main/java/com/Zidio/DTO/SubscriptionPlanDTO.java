package com.Zidio.DTO;

public class SubscriptionPlanDTO {
	public Long id;
	public String name;
	
	public int maxJob;
	public int maxProfiles;
	public int validityDays;
	public int prices;
	
	public SubscriptionPlanDTO() {}
	public SubscriptionPlanDTO(Long id, String name, int maxJob,int maxProfiles,
	int validityDays,int prices)
	{
		this.id=id;
		this.name=name;
		this.maxJob = maxJob;
		this.maxProfiles = maxProfiles;
		this.validityDays = validityDays;
		this.prices = prices;
	}
}
