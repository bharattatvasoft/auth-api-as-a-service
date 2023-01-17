package com.waseel.dawy.enums;

public enum Education {
	
	
	Primary("Primary"), 
	Secondary("Secondary"), 
	Graduate("Graduate"), 
	Post_Graduate("Post Graduate"), 
	HND("HND");
	
	private String name;

	private Education(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

}
