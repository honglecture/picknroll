package com.picknroll.web.entity;

public class MemberApp {

	private String memberId;
	private long appId;

	public MemberApp() {
	}

	public MemberApp(String memberId, long appId) {
		this.memberId = memberId;
		this.appId = appId;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public long getAppId() {
		return appId;
	}

	public void setAppId(long appId) {
		this.appId = appId;
	}

	@Override
	public String toString() {
		return "MemberApp [memberId=" + memberId + ", appId=" + appId + "]";
	}

}
