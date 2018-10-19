package com.picknroll.web.dao.mybatis;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.picknroll.web.dao.NoticeReplyDao;
import com.picknroll.web.entity.NoticeReply;
import com.picknroll.web.entity.Role;

@Repository
public class MybatisNoticeReplyDao implements NoticeReplyDao {
	
	@Autowired
	private SqlSession sqlSession;
	

	@Override
	public int insert(NoticeReply noticeReply) {
		NoticeReplyDao noticeReplyDao = sqlSession.getMapper(NoticeReplyDao.class);
		return noticeReplyDao.insert(noticeReply);
	}

	@Override
	public int update(NoticeReply noticeReply) {
		return 0;
	}

	@Override
	public List<NoticeReply> getList(Map<String, String> params) {
		NoticeReplyDao noticeReplyDao = sqlSession.getMapper(NoticeReplyDao.class);
		return noticeReplyDao.getList(params);
	}

	@Override
	public int getTotalCount(Map<String, String> params) {
		NoticeReplyDao noticeReplyDao = sqlSession.getMapper(NoticeReplyDao.class);
		return noticeReplyDao.getTotalCount(params);
	}

	@Override
	public int delete(Map<String, String> params) {
		NoticeReplyDao noticeReplyDao = sqlSession.getMapper(NoticeReplyDao.class);
		return noticeReplyDao.delete(params);
	}

	@Override
	public int deleteAll(Map<String, String> params) {
		NoticeReplyDao noticeReplyDao = sqlSession.getMapper(NoticeReplyDao.class);
		return noticeReplyDao.deleteAll(params);
	}

}