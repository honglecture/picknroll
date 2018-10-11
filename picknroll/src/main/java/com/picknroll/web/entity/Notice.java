package com.picknroll.web.entity;

import java.util.Date;

public class Notice {

	private long id;
	private String title;
	private String content;
	private long hit;
	private Date regDate;
	private Date editDate;
	private String writerId;
	
	// 추가함
	private String nickname;

	public Notice() {
	}
	
	public Notice(long id, String title, String content, long hit, Date regDate, Date editDate, String writerId,
			String nickname) {
		this.id = id;
		this.title = title;
		this.content = content;
		this.hit = hit;
		this.regDate = regDate;
		this.editDate = editDate;
		this.writerId = writerId;
		this.nickname = nickname;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public long getHit() {
		return hit;
	}

	public void setHit(long hit) {
		this.hit = hit;
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

	public String getWriterId() {
		return writerId;
	}

	public void setWriterId(String writerId) {
		this.writerId = writerId;
	}

	@Override
	public String toString() {
		return "Notice [id=" + id + ", title=" + title + ", content=" + content + ", hit=" + hit + ", regDate="
				+ regDate + ", editDate=" + editDate + ", writerId=" + writerId + "]";
	}

}