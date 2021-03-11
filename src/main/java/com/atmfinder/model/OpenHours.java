package com.atmfinder.model;

import java.util.List;

public class OpenHours {
	private String dayOfWeek;
	private List<Hours> hours;

	public String getDayOfWeek() {
		return dayOfWeek;
	}

	public void setDayOfWeek(String dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}

	public List<Hours> getHours() {
		return hours;
	}

	public void setHours(List<Hours> hours) {
		this.hours = hours;
	}

	@Override
	public String toString() {
		return "OpenHours [dayOfWeek=" + dayOfWeek + ", hours=" + hours + "]";
	}

}
