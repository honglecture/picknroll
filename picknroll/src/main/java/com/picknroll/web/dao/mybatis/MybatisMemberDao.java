package com.picknroll.web.dao.mybatis;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.picknroll.web.dao.MemberDao;
import com.picknroll.web.entity.Member;

@Repository
public class MybatisMemberDao implements MemberDao {
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public int insert(Member member) {
		MemberDao memberDao = sqlSession.getMapper(MemberDao.class);
		return memberDao.insert(member);
	}
	
	@Override
	public int updateDetail(Member member) {
		MemberDao memberDao = sqlSession.getMapper(MemberDao.class);
		return memberDao.updateDetail(member);
	}

	@Override
	public int update(Member member) {
		MemberDao memberDao = sqlSession.getMapper(MemberDao.class);
		return memberDao.update(member);
	}

	@Override
	public int delete(String id) {
		MemberDao memberDao = sqlSession.getMapper(MemberDao.class);
		return memberDao.delete(id);
	}

	@Override
	public Member get(Map<String, String> params) {
		MemberDao memberDao = sqlSession.getMapper(MemberDao.class);
		return memberDao.get(params);
	}

	@Override
	public List<Member> getList(String field ,String query, int page) {
		MemberDao memberDao = sqlSession.getMapper(MemberDao.class);
		return memberDao.getList(field, query, page);
	}

	@Override
	public Member getByEmail(Map<String,String> params) {
		MemberDao memberDao = sqlSession.getMapper(MemberDao.class);
		return memberDao.getByEmail(params);
	}

	@Override
	public Member getByNickname(Map<String,String> params) {
		MemberDao memberDao = sqlSession.getMapper(MemberDao.class);
		return memberDao.getByNickname(params);
	}

	@Override
	public int updatePassword(String id, String newPassword) {
		MemberDao memberDao = sqlSession.getMapper(MemberDao.class);
		return memberDao.updatePassword(id, newPassword);
	}

	@Override
	public String getByEmailGender(String email, String birthday) {
		MemberDao memberDao = sqlSession.getMapper(MemberDao.class);
		return memberDao.getByEmailGender(email, birthday);
	}

}