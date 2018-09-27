package com.picknroll.web.dao;

import java.util.List;

import com.picknroll.web.entity.NoticeReply;
import com.picknroll.web.entity.Role;

public interface NoticeReplyDao {
	
	int insert(NoticeReply noticeReply);
	int update(NoticeReply noticeReply);
	int delete(int id);
	Role get(int id);
	List<NoticeReply> getList();

}
