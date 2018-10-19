package com.picknroll.web.service.mybatis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.picknroll.web.dao.NoticeDao;
import com.picknroll.web.dao.NoticeReplyDao;
import com.picknroll.web.entity.Notice;
import com.picknroll.web.entity.NoticeReply;
import com.picknroll.web.service.CommunityService;

@Service
public class MybatisCommunityService implements CommunityService {

	@Autowired
	private NoticeDao noticeDao;
	
	@Autowired
	private NoticeReplyDao noticeReplyDao;

	@Override
	public List<Notice> getNoticeList(Map<String, String> param) {
		int p = Integer.parseInt(param.get("p"));
		param.put("p", String.valueOf((p-1)*10));
		return noticeDao.getList(param);
	}

	@Override
	public Notice getNotice(String id) {
		return noticeDao.get(id);
	}

	@Override
	public int insertNotice(Notice notice) {
		return noticeDao.insert(notice);
	}

	@Override
	public int updateNotice(Notice notice) {
		return noticeDao.update(notice);
	}

	@Override
	public Map<String, String> generateNoticeParam(String field, String query, String sortField,
			int page) {
		Map<String, String> param = new HashMap<String, String>();
		param.put("f", field);
		param.put("q", query);
		param.put("s", sortField);
		param.put("p", String.valueOf(page));
		return param;
	}

	@Override
	public int getNoticeTotalCount(Map<String, String> params) {
		return noticeDao.getTotalCount(params);
	}

	@Override
	public List<NoticeReply> getNoticeReply(Map<String, String> params) {
		return noticeReplyDao.getList(params);
	}

	@Override
	public int getNoticeReplyTotalCount(Map<String, String> params) {
		return noticeReplyDao.getTotalCount(params);
	}

	@Override
	public int insertNoticeReply(NoticeReply noticeReply) {
		return noticeReplyDao.insert(noticeReply);
	}

	@Override
	public int deleteNoticeReply(Map<String, String> params) {
		return noticeReplyDao.delete(params);

	}

	@Override
	public int deleteNotice(Map<String, String> params) {
		noticeReplyDao.deleteAll(params);
		return noticeDao.delete(params);
	}

	
}