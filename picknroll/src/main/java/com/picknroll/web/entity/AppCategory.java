package com.picknroll.web.entity;

public class AppCategory {

	private long id;
	private String name;

	public AppCategory() {
	}

	public AppCategory(long id, String name) {
		this.id = id;
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "AppCategory [id=" + id + ", name=" + name + "]";
	}

}
