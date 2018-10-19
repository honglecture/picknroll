package com.picknroll.web.service;

import java.util.List;
import java.util.Map;

import com.picknroll.web.entity.Notice;
import com.picknroll.web.entity.NoticeReply;
import com.picknroll.web.util.Pagination;

public interface CommunityService {

	List<Notice> getNoticeList(Map<String, String> param);

	Notice getNotice(String id);

	int insertNotice(Notice notice);

	int updateNotice(Notice notice);

	Map<String, String> generateNoticeParam(String field, String query, String sortField, int page);
	
	int getNoticeTotalCount(Map<String, String> params);

	List<NoticeReply> getNoticeReply(Map<String, String> params);

	int getNoticeReplyTotalCount(Map<String, String> params);

	int insertNoticeReply(NoticeReply noticeReply);

	int deleteNoticeReply(Map<String, String> params);

	int deleteNotice(Map<String, String> params);

}