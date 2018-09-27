package com.picknroll.web.entity;

import java.util.Date;

public class Board {

	private long id;
	private String title;
	private String content;
	private long hit;
	private String writerId;
	private Date regDate;
	private Date editDate;
	private long boardTypeId;
	
	public Board() {
	}

	public Board(long id, String title, String content, long hit, String writerId, Date regDate, Date editDate,
			long boardTypeId) {
		this.id = id;
		this.title = title;
		this.content = content;
		this.hit = hit;
		this.writerId = writerId;
		this.regDate = regDate;
		this.editDate = editDate;
		this.boardTypeId = boardTypeId;
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

	public String getWriterId() {
		return writerId;
	}

	public void setWriterId(String writerId) {
		this.writerId = writerId;
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

	public long getBoardTypeId() {
		return boardTypeId;
	}

	public void setBoardTypeId(long boardTypeId) {
		this.boardTypeId = boardTypeId;
	}

	@Override
	public String toString() {
		return "Board [id=" + id + ", title=" + title + ", content=" + content + ", hit=" + hit + ", writerId="
				+ writerId + ", regDate=" + regDate + ", editDate=" + editDate + ", boardTypeId=" + boardTypeId + "]";
	}

}
