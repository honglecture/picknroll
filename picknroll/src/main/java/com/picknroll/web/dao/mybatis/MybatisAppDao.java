package com.picknroll.web.dao.mybatis;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.picknroll.web.dao.AppDao;
import com.picknroll.web.entity.App;
import com.picknroll.web.entity.Role;
@Repository
public class MybatisAppDao implements AppDao {

	@Override
	public int insert(App app) {
		return 0;
	}

	@Override
	public int update(App app) {
		return 0;
	}

	@Override
	public int delete(int id) {
		return 0;
	}

	@Override
	public Role get(int id) {
		return null;
	}

	@Override
	public List<Role> getList() {
		return null;
	}

}
