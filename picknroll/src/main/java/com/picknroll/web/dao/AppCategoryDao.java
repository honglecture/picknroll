package com.picknroll.web.dao;

import java.util.List;

import com.picknroll.web.entity.AppCategory;

public interface AppCategoryDao {

	int insert(AppCategory appCategory);

	int update(AppCategory appCategory);

	int delete(int id);

	AppCategory get(int id);

	List<AppCategory> getList();

}