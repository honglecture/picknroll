package com.picknroll.web.entity;

import java.util.Date;

public class NoticeReply {

	private long id;
	private String title;
	private String content;
	private Date regDate;
	private Date editDate;
	private String writerId;
	private long noticeId;

	public NoticeReply() {}

	public NoticeReply(long id, String title, String content, Date regDate, Date editDate, String writerId,
			long noticeId) {
		this.id = id;
		this.title = title;
		this.content = content;
		this.regDate = regDate;
		this.editDate = editDate;
		this.writerId = writerId;
		this.noticeId = noticeId;
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

	@Override
	public String toString() {
		return "NoticeReply [id=" + id + ", title=" + title + ", content=" + content + ", regDate=" + regDate
				+ ", editDate=" + editDate + ", writerId=" + writerId + ", noticeId=" + noticeId + "]";
	}

}