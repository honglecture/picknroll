package com.picknroll.web.service.mybatis;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.picknroll.web.entity.Notice;
import com.picknroll.web.service.CommunityService;

@Service
public class MybatisCommunityService implements CommunityService {

	@Override
	public List<Notice> getNoticeList(Map<String, String> param) {
		return null;
	}

	@Override
	public Notice getNotice(String id) {
		return null;
	}

	@Override
	public int insertNotice(Notice notice) {
		return 0;
	}

	@Override
	public int updateNotice(Notice notice) {
		return 0;
	}

	@Override
	public int deleteNotice(String id) {
		return 0;
	}

	@Override
	public Map<String, String> generateNoticeParam(String field, String query, String writerId, String sortField,
			int page) {
		return null;
	}

}
