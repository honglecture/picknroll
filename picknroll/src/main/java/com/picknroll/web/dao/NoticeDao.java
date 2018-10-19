package com.picknroll.web.dao;

import java.util.List;
import java.util.Map;

import com.picknroll.web.entity.Notice;

public interface NoticeDao {

	Notice get(String id);

	int insert(Notice notice);

	int update(Notice notice);

	List<Notice> getList(Map<String, String> param);

	int getTotalCount(Map<String, String> map);

	int delete(Map<String, String> params);

}
