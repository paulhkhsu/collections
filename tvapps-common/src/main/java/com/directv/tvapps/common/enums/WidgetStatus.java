package com.directv.tvapps.common.enums;
/*
 * @author Paul Hsu
 */

public enum WidgetStatus {
	DISAPPROVED((short) 0), 
	APPROVED((short) 1),
	PENDING((short) 2), 
	RESUBMITTED((short) 3), 
	ALL((short) 4), 
	DELETED((short) 5);
	
	private short value;

	WidgetStatus(short value) {
		this.value = value;
	}

	public short getValue() {
		return value;
	}
};