package com.picknroll.web.dao;

import java.util.List;
import java.util.Map;

import com.picknroll.web.entity.App;

public interface AppDao {

	int insert(App app);
	int update(App app);
	List<App> getList(Map<String, String> params);
	App get(Map<String, String> params);
	int delete(Map<String, String> params);
	int getTotalCount(Map<String, String> params);
	List<App> getListByMemberId(Map<String, String> params);
	int getTotalCountByMemberId(Map<String, String> params);

}