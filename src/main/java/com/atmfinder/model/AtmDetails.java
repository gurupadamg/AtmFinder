package com.atmfinder.model;

import java.util.List;

public class AtmDetails {

	private Address address;
	private String distance;
	private List<OpenHours> openingHours;
	private String functionality;
	private String type;
	
	

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getDistance() {
		return distance;
	}

	public void setDistance(String distance) {
		this.distance = distance;
	}

	public List<OpenHours> getOpeningHours() {
		return openingHours;
	}

	public void setOpeningHours(List<OpenHours> openingHours) {
		this.openingHours = openingHours;
	}

	public String getFunctionality() {
		return functionality;
	}

	public void setFunctionality(String functionality) {
		this.functionality = functionality;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "AtmDetails [address=" + address + ", distance=" + distance + ", openingHours=" + openingHours
				+ ", functionality=" + functionality + ", type=" + type + "]";
	}

}
