package com.picknroll.web.service;

import java.util.List;
import java.util.Map;

import com.picknroll.web.entity.Notice;

public interface CommunityService {

	List<Notice> getNoticeList(Map<String, String> param);

	Notice getNotice(String id);

	int insertNotice(Notice notice);

	int updateNotice(Notice notice);

	int deleteNotice(String id);

	Map<String, String> generateNoticeParam(String field, String query, String writerId, String sortField, int page);

}