package com.connectcard.domain;

public class City implements java.io.Serializable {

	
	
	private String cityName;
	
	private int cityId; 
	

	public City(int cityId) {
		this.cityId = cityId;
	}
	
	
	public City() {
	}


	public String getCityName() {
		return cityName;
	}


	public void setCityName(String cityName) {
		this.cityName = cityName;
	}


	public int getCityId() {
		return cityId;
	}


	public void setCityId(int cityId) {
		this.cityId = cityId;
	}
	
	
	
	
}
