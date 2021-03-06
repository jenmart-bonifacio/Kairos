package com.kairos.ebillquezelco.domain.adjustment;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tblAdjustment")
public class Adjustment implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1195543876643450561L;
	
	@Id
	private String adjustmentId;
	private String billId;
	private String accountId;
	private String adjustmentType;
	private Boolean adjustmentStatus;
	private Date adjustmentDate;
	private BigDecimal adjustmentAmount;
	private String comments;

	
	public String getAdjustmentId() {
		return adjustmentId;
	}
	public void setAdjustmentId(String adjustmentId) {
		this.adjustmentId = adjustmentId;
	}
	public String getBillId() {
		return billId;
	}
	public void setBillId(String billId) {
		this.billId = billId;
	}
	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	public String getAdjustmentType() {
		return adjustmentType;
	}
	public void setAdjustmentType(String adjustmentType) {
		this.adjustmentType = adjustmentType;
	}
	public Boolean getAdjustmentStatus() {
		return adjustmentStatus;
	}
	public void setAdjustmentStatus(Boolean adjustmentStatus) {
		this.adjustmentStatus = adjustmentStatus;
	}
	public Date getAdjustmentDate() {
		return adjustmentDate;
	}
	public void setAdjustmentDate(Date adjustmentDate) {
		this.adjustmentDate = adjustmentDate;
	}
	public BigDecimal getAdjustmentAmount() {
		return adjustmentAmount;
	}
	public void setAdjustmentAmount(BigDecimal adjustmentAmount) {
		this.adjustmentAmount = adjustmentAmount;
	}
	
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
}