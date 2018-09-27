package com.picknroll.web.dao;

import java.util.List;
import java.util.Map;

import com.picknroll.web.entity.Notice;

public interface NoticeDao {

	Notice get(String id);

	int insert(Notice notice);

	int update(Notice notice);

	int delete(String id);
	
	List<Notice> getList(Map<String, String> param);

}
