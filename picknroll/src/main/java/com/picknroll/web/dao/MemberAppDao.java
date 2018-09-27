package com.picknroll.web.dao;

import java.util.List;

import com.picknroll.web.entity.MemberApp;
import com.picknroll.web.entity.Role;

public interface MemberAppDao {
	
	int insert(MemberApp memberApp);
	int update(MemberApp memberApp);
	int delete(int id);
	Role get(int id);
	List<MemberApp> getList();

}