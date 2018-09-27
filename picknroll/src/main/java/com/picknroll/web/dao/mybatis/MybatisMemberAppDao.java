package com.picknroll.web.dao.mybatis;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.picknroll.web.dao.MemberAppDao;
import com.picknroll.web.entity.MemberApp;
import com.picknroll.web.entity.Role;
@Repository
public class MybatisMemberAppDao implements MemberAppDao {

	@Override
	public int insert(MemberApp memberApp) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(MemberApp memberApp) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Role get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MemberApp> getList() {
		// TODO Auto-generated method stub
		return null;
	}

}
