package com.picknroll.web.dao;

import java.util.List;
import java.util.Map;

import com.picknroll.web.entity.Role;

public interface RoleDao {
	
	int insert(Role role);

	int update(Role role);

	int delete(Map<String, String> map);

	Role get(Map<String, String> map);

	List<Role> getList();
	
}