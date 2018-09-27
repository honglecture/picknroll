package com.picknroll.web.dao;

import java.util.List;

import com.picknroll.web.entity.MemberRestriction;

public interface MemberRestrictionDao {
	
	int insert(MemberRestriction memberRestriction);

	int update(MemberRestriction memberRestriction);

	int delete(String id);

	MemberRestriction get(String id);

	List<MemberRestriction> getList();

}
