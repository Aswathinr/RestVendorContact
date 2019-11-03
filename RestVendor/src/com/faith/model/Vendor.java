package com.faith.model;

public class Vendor {
	

	private Integer vId;
	private String vName;
	private String vAddress;
	private String vLocation;
	private String vService; 
	private Double pincode; 
	private String isActive;
	
	
	public Vendor() {
		super();
	}

	public Integer getvId(){
		return vId;
	}
	public void setvId(Integer vId) {
		this.vId = vId;
	}
	public String getvName() {
		return vName;
	}
	public void setvName(String vName) {
		this.vName = vName;
	}
	public String getvAddress() {
		return vAddress;
	}
	public void setvAddress(String vAddress) {
		this.vAddress = vAddress;
	}
	public String getvLocation() {
		return vLocation;
	}
	public void setvLocation(String vLocation) {
		this.vLocation = vLocation;
	}
	public String getvService() {
		return vService;
	}
	public void setvService(String vService) {
		this.vService = vService;
	}
	public Double getPincode() {
		return pincode;
	}
	public void setPincode(Double pincode) {
		this.pincode = pincode;
	}
	public String getIsActive() {
		return isActive;
	}
	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}
}
