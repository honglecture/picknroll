package com.picknroll.web.dao.mybatis;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.picknroll.web.dao.MemberRoleDao;
import com.picknroll.web.entity.MemberRole;
@Repository
public class MybatisMemberRoleDao implements MemberRoleDao {

	@Autowired
	private SqlSession sqlSession;

	@Override
	public int insert(MemberRole memberRole) {
		MemberRoleDao memberRoleDao = sqlSession.getMapper(MemberRoleDao.class);
		return memberRoleDao.insert(memberRole);
	}

	@Override
	public int update(MemberRole memberRole) {
		MemberRoleDao memberRoleDao = sqlSession.getMapper(MemberRoleDao.class);
		return memberRoleDao.update(memberRole);
	}

	@Override
	public int delete(MemberRole memberRole) {
		MemberRoleDao memberRoleDao = sqlSession.getMapper(MemberRoleDao.class);
		return memberRoleDao.delete(memberRole);
	}

	@Override
	public MemberRole get(MemberRole memberRole) {
		MemberRoleDao memberRoleDao = sqlSession.getMapper(MemberRoleDao.class);
		return memberRoleDao.get(memberRole);
	}

    @Override
    public List<MemberRole> getList(Map<String, String> map) {
        MemberRoleDao memberRoleDao = sqlSession.getMapper(MemberRoleDao.class);
        return memberRoleDao.getList(map);
    }

}
