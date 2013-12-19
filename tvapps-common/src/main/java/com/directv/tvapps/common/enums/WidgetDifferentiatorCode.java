package com.directv.tvapps.common.enums;

/*
 * @author Paul Hsu
 */

public enum WidgetDifferentiatorCode {
	DEFAULT("DEFAULT"), 
	FEATURED("FEATURED"),
	PROMO("PROMO"), 
	NEWNOTABLE("NOTABLE"); 
	private String value;

	WidgetDifferentiatorCode(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

};