package com.picknroll.web.dao.mybatis;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.picknroll.web.dao.NoticeReplyDao;
import com.picknroll.web.entity.NoticeReply;
import com.picknroll.web.entity.Role;

@Repository
public class MybatisNoticeReplyDao implements NoticeReplyDao {

	@Override
	public int insert(NoticeReply noticeReply) {
		return 0;
	}

	@Override
	public int update(NoticeReply noticeReply) {
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
	public List<NoticeReply> getList() {
		return null;
	}

}