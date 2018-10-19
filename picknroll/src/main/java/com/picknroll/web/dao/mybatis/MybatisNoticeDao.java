package com.picknroll.web.dao.mybatis;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.picknroll.web.dao.NoticeDao;
import com.picknroll.web.entity.Notice;

@Repository
public class MybatisNoticeDao implements NoticeDao {

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<Notice> getList(Map<String, String> param) {
		NoticeDao noticeDao = sqlSession.getMapper(NoticeDao.class);
		return noticeDao.getList(param);
	}

	@Override
	public Notice get(String id) {
		NoticeDao noticeDao = sqlSession.getMapper(NoticeDao.class);
		return noticeDao.get(id);
	}

	@Override
	public int insert(Notice notice) {
		NoticeDao noticeDao = sqlSession.getMapper(NoticeDao.class);
		return noticeDao.insert(notice);
	}

	@Override
	public int update(Notice notice) {
		NoticeDao noticeDao = sqlSession.getMapper(NoticeDao.class);
		return noticeDao.update(notice);
	}

	@Override
	public int getTotalCount(Map<String, String> params) {
		NoticeDao noticeDao = sqlSession.getMapper(NoticeDao.class);
		return noticeDao.getTotalCount(params);
	}

	@Override
	public int delete(Map<String, String> params) {
		NoticeDao noticeDao = sqlSession.getMapper(NoticeDao.class);
		return noticeDao.delete(params);
	}

}