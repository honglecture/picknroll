package com.picknroll.web.dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.picknroll.web.dao.AppCategoryDao;
import com.picknroll.web.entity.AppCategory;

@Repository
public class MybatisAppCategoryDao implements AppCategoryDao {
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public int insert(AppCategory appCategory) {
		return 0;
	}

	@Override
	public int update(AppCategory appCategory) {
		return 0;
	}

	@Override
	public int delete(int id) {
		return 0;
	}

	@Override
	public AppCategory get(int id) {
		return null;
	}

	@Override
	public List<AppCategory> getList() {
		AppCategoryDao appCategoryDao = sqlSession.getMapper(AppCategoryDao.class);
		return appCategoryDao.getList();
	}

}
