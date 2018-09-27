package com.picknroll.web.entity;

import java.util.Date;

public class App {
	private long id;
	private String title;
	private String url;
	private String icon;
	private boolean status;
	private boolean isLogin;
	private String description;
	private String target;
	private long appCategoryId;
	private Date regDate;
	private Date editDate;

	public App() {
	}

	public App(long id, String title, String url, String icon, boolean status, boolean isLogin, String description,
			String target, long appCategoryId, Date regDate, Date editDate) {
		this.id = id;
		this.title = title;
		this.url = url;
		this.icon = icon;
		this.status = status;
		this.isLogin = isLogin;
		this.description = description;
		this.target = target;
		this.appCategoryId = appCategoryId;
		this.regDate = regDate;
		this.editDate = editDate;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public boolean getIsLogin() {
		return isLogin;
	}

	public void setLogin(boolean isLogin) {
		this.isLogin = isLogin;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public long getAppCategoryId() {
		return appCategoryId;
	}

	public void setAppCategoryId(long appCategoryId) {
		this.appCategoryId = appCategoryId;
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
		return "App [id=" + id + ", title=" + title + ", url=" + url + ", icon=" + icon + ", status=" + status
				+ ", isLogin=" + isLogin + ", description=" + description + ", target=" + target + ", appCategoryId="
				+ appCategoryId + ", regDate=" + regDate + ", editDate=" + editDate + "]";
	}

}
