package com.picknroll.web.dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.picknroll.web.dao.AppDao;
import com.picknroll.web.dao.MemberAppDao;
import com.picknroll.web.entity.MemberApp;

@Repository
public class MybatisMemberAppDao implements MemberAppDao {
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public int insert(MemberApp memberApp) {
		MemberAppDao memberAppDao = sqlSession.getMapper(MemberAppDao.class);
		return memberAppDao.insert(memberApp);
	}

	@Override
	public int update(MemberApp memberApp) {
		return 0;
	}

	@Override
	public int delete(MemberApp memberApp) {
		MemberAppDao memberAppDao = sqlSession.getMapper(MemberAppDao.class);
		return memberAppDao.delete(memberApp);
	}

	@Override
	public MemberApp get(int id) {
		return null;
	}

	@Override
	public List<MemberApp> getList() {
		return null;
	}



}
