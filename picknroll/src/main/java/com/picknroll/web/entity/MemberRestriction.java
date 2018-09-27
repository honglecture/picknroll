package com.picknroll.web.entity;

import java.util.Date;

public class MemberRestriction {

	private long id;
	private String memberId;
	private String type;
	private String description;
	private Date regDate;
	private Date editDate;

	public MemberRestriction() {

	}

	public MemberRestriction(long id, String memberId, String type, String description, Date regDate, Date editDate) {
		this.id = id;
		this.memberId = memberId;
		this.type = type;
		this.description = description;
		this.regDate = regDate;
		this.editDate = editDate;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public Date getEditDate() {
		return editDate;
	}

	public void setEditDate(Date editDate) {
		this.editDate = editDate;
	}

	@Override
	public String toString() {
		return "MemberRestriction [id=" + id + ", memberId=" + memberId + ", type=" + type + ", description="
				+ description + ", regDate=" + regDate + ", editDate=" + editDate + "]";
	}

}
