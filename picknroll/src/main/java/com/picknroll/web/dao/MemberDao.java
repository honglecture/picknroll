package com.picknroll.web.dao;

import java.util.List;
import java.util.Map;

import com.picknroll.web.entity.Member;

public interface MemberDao {

	int insert(Member member);
	
	int updateDetail(Member member);

	int update(Member member);

	int delete(String id);

	Member get(Map<String,String> params);

	List<Member> getList(String field ,String query, int page);

	Member getByEmail(Map<String,String> params);

	Member getByNickname(Map<String,String> params);

	int updatePassword(String id, String oldPassword);

	String getByEmailGender(String email, String birthday);

}
