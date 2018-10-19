package com.picknroll.web.dao.mybatis;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.picknroll.web.dao.AppDao;
import com.picknroll.web.entity.App;

@Repository
public class MybatisAppDao implements AppDao {
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public int insert(App app) {
		AppDao appDao = sqlSession.getMapper(AppDao.class);
		return appDao.insert(app);
	}

	@Override
	public int update(App app) {
		AppDao appDao = sqlSession.getMapper(AppDao.class);
		return appDao.update(app);
	}

	@Override
	public App get(Map<String, String> mapping) {
		AppDao appDao = sqlSession.getMapper(AppDao.class);
		return appDao.get(mapping);
	}

	@Override
	public int delete(Map<String, String> params) {
		AppDao appDao = sqlSession.getMapper(AppDao.class);
		return appDao.delete(params);
	}

	@Override
	public List<App> getList(Map<String, String> params) {
		AppDao appDao = sqlSession.getMapper(AppDao.class);
		return appDao.getList(params);
	}

	@Override
	public int getTotalCount(Map<String, String> params) {
		AppDao appDao = sqlSession.getMapper(AppDao.class);
		return appDao.getTotalCount(params);
	}

	@Override
	public List<App> getListByMemberId(Map<String, String> params) {
		AppDao appDao = sqlSession.getMapper(AppDao.class);
		return appDao.getListByMemberId(params);
	}

	@Override
	public int getTotalCountByMemberId(Map<String, String> params) {
		AppDao appDao = sqlSession.getMapper(AppDao.class);
		return appDao.getTotalCountByMemberId(params);
	}


}