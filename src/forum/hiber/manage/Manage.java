package forum.hiber.manage;

import java.util.Date;

/**
 * Manage entity. @author MyEclipse Persistence Tools
 */

public class Manage implements java.io.Serializable {

	// Fields

	private Integer manageid;
	private Byte adminid;
	private String operation;
	private Date mtimee;

	// Constructors

	/** default constructor */
	public Manage() {
	}

	/** minimal constructor */
	public Manage(Integer manageid) {
		this.manageid = manageid;
	}

	/** full constructor */
	public Manage(Integer manageid, Byte adminid, String operation, Date mtimee) {
		this.manageid = manageid;
		this.adminid = adminid;
		this.operation = operation;
		this.mtimee = mtimee;
	}

	// Property accessors

	public Integer getManageid() {
		return this.manageid;
	}

	public void setManageid(Integer manageid) {
		this.manageid = manageid;
	}

	public Byte getAdminid() {
		return this.adminid;
	}

	public void setAdminid(Byte adminid) {
		this.adminid = adminid;
	}

	public String getOperation() {
		return this.operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public Date getMtimee() {
		return this.mtimee;
	}

	public void setMtimee(Date mtimee) {
		this.mtimee = mtimee;
	}

}