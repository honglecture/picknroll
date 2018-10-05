package com.picknroll.web.service;

import com.picknroll.web.entity.Member;

public interface HomeService {
	
	public String getDefaultRoleName(String memberId);

	public Member getMember(String id);
	
}
