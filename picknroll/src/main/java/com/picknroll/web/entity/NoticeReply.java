package com.picknroll.web.entity;

import java.util.Date;

public class NoticeReply {

	private long id;
	private String content;
	private Date regDate;
	private Date editDate;
	private String writerId;
	private long noticeId;

	// 닉네임
	private String nickname;

	public NoticeReply() {
	}

	public NoticeReply(long id, String content, Date regDate, Date editDate, String writerId, long noticeId,
			String nickname) {
		this.id = id;
		this.content = content;
		this.regDate = regDate;
		this.editDate = editDate;
		this.writerId = writerId;
		this.noticeId = noticeId;
		this.nickname = nickname;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
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

	public long getNoticeId() {
		return noticeId;
	}

	public void setNoticeId(long noticeId) {
		this.noticeId = noticeId;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

}