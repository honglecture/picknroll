package com.picknroll.web.dao;

import java.util.List;

import com.picknroll.web.entity.MemberApp;

public interface MemberAppDao {
	
	int insert(MemberApp memberApp);
	int update(MemberApp memberApp);
	int delete(MemberApp memberApp);
	MemberApp get(int id);
	List<MemberApp> getList();

}