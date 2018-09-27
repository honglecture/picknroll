package com.picknroll.web.dao;

import java.util.List;
import java.util.Map;

import com.picknroll.web.entity.MemberRole;

public interface MemberRoleDao {

	int insert(MemberRole memberRole);

	int update(MemberRole memberRole);

	int delete(MemberRole memberRole);

	MemberRole get(MemberRole memberRole);

	List<MemberRole> getList(Map<String, String> map);

}
