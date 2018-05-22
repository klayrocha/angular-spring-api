package com.klayrocha.helpdesk.api.security.enums;

public enum StatusEnum {
	New,
	Resolved,
	Approved,
	Disapproved,
	Assigned,
	Closed;
	
	public static StatusEnum getStatus(String status) {
		switch(status) {
			case "New" : return New;
			case "Resolved" : return Resolved;
			case "Approved" : return Approved;
			case "Disapproved" : return Disapproved;
			case "Assigned" : return Assigned;
			case "Closed" : return Closed;
			default : return New;
		}
	}
}

