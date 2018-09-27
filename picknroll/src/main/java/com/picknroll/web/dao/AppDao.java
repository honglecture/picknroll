package com.picknroll.web.dao;

import java.util.List;

import com.picknroll.web.entity.App;
import com.picknroll.web.entity.Role;

public interface AppDao {

	int insert(App app);
	int update(App app);
	int delete(int id);
	Role get(int id);
	List<Role> getList();

}