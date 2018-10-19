package com.picknroll.web.dao;

import java.util.List;
import java.util.Map;

import com.picknroll.web.entity.NoticeReply;

public interface NoticeReplyDao {
	
	int insert(NoticeReply noticeReply);
	int update(NoticeReply noticeReply);
	List<NoticeReply> getList(Map<String, String> params);
	int getTotalCount(Map<String, String> params);
	int delete(Map<String, String> params);
	int deleteAll(Map<String, String> params);

}