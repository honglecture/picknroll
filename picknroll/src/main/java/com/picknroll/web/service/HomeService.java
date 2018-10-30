package com.picknroll.web.service;

import java.util.List;
import java.util.Map;

import com.picknroll.web.entity.App;
import com.picknroll.web.entity.Member;

public interface HomeService {
	
	List<App> getAppListByMemberId(Map<String, String> params);
	
	public String getDefaultRoleName(String memberId);

	public Member getMember(String id);
	
}
