package com.klayrocha.helpdesk.api.dto;

import java.io.Serializable;

public class Summary implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer amountNew;
	private Integer amountResolved;
	private Integer amountApproved;
	private Integer amountDisapproved;
	private Integer amountAssigned;
	private Integer amountClosed;

	public Integer getAmountNew() {
		return amountNew;
	}

	public void setAmountNew(Integer amountNew) {
		this.amountNew = amountNew;
	}

	public Integer getAmountResolved() {
		return amountResolved;
	}

	public void setAmountResolved(Integer amountResolved) {
		this.amountResolved = amountResolved;
	}

	public Integer getAmountDisapproved() {
		return amountDisapproved;
	}

	public void setAmountDisapproved(Integer amountDisapproved) {
		this.amountDisapproved = amountDisapproved;
	}

	public Integer getAmountApproved() {
		return amountApproved;
	}

	public void setAmountApproved(Integer amountApproved) {
		this.amountApproved = amountApproved;
	}

	public Integer getAmountAssigned() {
		return amountAssigned;
	}

	public void setAmountAssigned(Integer amountAssigned) {
		this.amountAssigned = amountAssigned;
	}

	public Integer getAmountClosed() {
		return amountClosed;
	}

	public void setAmountClosed(Integer amountClosed) {
		this.amountClosed = amountClosed;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
