package com.directv.tvapps.common.enums;

/*
 * @author Paul Hsu
 */

public enum WidgetType {
	ALL, 
	NEW, 
	FEATURED, 
	TOPRATED, 
	NEWNOTABLE,
	PROMO;

	static public void main(String arg[])
	{
		System.out.println(WidgetType.ALL);
		String s = "NEW";
		WidgetType p = WidgetType.valueOf(s);
		switch(p){
		case ALL:
			System.out.println("all");
			break;
		case NEW:
			System.out.println("NEWADD");
			break;
		case NEWNOTABLE:
			System.out.println("NEWNOTABLE");
			break;
		}

	}

};