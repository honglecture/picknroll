package com.picknroll.web.entity;

public class MemberRole {

	private String roleName;
	private String memberId;
	private boolean defaultRole;
	
	public MemberRole() {
	}

	public MemberRole(String memberId, String roleName, boolean defaultRole) {
		this.memberId = memberId;
		this.roleName = roleName;
		this.defaultRole = defaultRole;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public boolean getDefaultRole() {
		return defaultRole;
	}

	public void setDefaultRole(boolean defaultRole) {
		this.defaultRole = defaultRole;
	}

	@Override
	public String toString() {
		return "MemberRole [roleName=" + roleName + ", memberId=" + memberId + ", defaultRole=" + defaultRole + "]";
	}
	
}
