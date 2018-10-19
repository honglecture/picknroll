package com.picknroll.web.controller;

import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.picknroll.web.entity.Notice;
import com.picknroll.web.entity.NoticeReply;
import com.picknroll.web.service.CommunityService;

@Controller
@RequestMapping("/notice/")
public class NoticeController {
	
	@Autowired
	private CommunityService service;
	
	@GetMapping("list")
	public String list(Model model, @RequestParam Map<String, String> param) {
		model.addAttribute("param", param);
		return "community.notice.list";
	}
	
	@PostMapping("list-ajax")
	@ResponseBody
	public String listAjax(@RequestBody Map<String, String> params) {
		List<Notice> noticeList = service.getNoticeList(params);
		int totalCount = service.getNoticeTotalCount(params);
		//Pagination pagination = service.makePagination(params);
		JSONObject returnObject = new JSONObject();
		JSONArray array = new JSONArray();
		for(Notice notice : noticeList) {
			JSONObject object = new JSONObject();
			object.put("id", notice.getId());
			object.put("replyCount", notice.getReplyCount());
			object.put("title", notice.getTitle());
			object.put("nickname", notice.getNickname());
			object.put("hit", notice.getHit());
			object.put("regDate", new SimpleDateFormat("yyyy-MM-dd").format(notice.getRegDate()));
			array.add(object);
		}
		returnObject.put("totalCount", totalCount);
		returnObject.put("list", array);
		return returnObject.toJSONString();
	}
	
	@PostMapping("reply-list-ajax")
	@ResponseBody
	public String replyListAjax(@RequestBody Map<String, String> params, Principal principal) {
		String loginId = "";
		List<NoticeReply> noticeReplyList = service.getNoticeReply(params);
		int totalCount = service.getNoticeReplyTotalCount(params);
		JSONObject returnObject = new JSONObject();
		JSONArray array = new JSONArray();
		for(NoticeReply noticeReply : noticeReplyList) {
			JSONObject object = new JSONObject();
			object.put("id", noticeReply.getId());
			object.put("content", noticeReply.getContent());
			object.put("nickname", noticeReply.getNickname());
			object.put("writerId", noticeReply.getWriterId());
			object.put("regDate", new SimpleDateFormat("yyyy-MM-dd").format(noticeReply.getRegDate()));
			array.add(object);
		}
		returnObject.put("loginId", principal!=null ? principal.getName() : "");
		returnObject.put("totalCount", totalCount);
		returnObject.put("list", array);
		return returnObject.toJSONString();
	}
	
	@PostMapping("reply-reg-ajax")
	@ResponseBody
	public String replyRegAjax(@RequestBody NoticeReply noticeReply, Principal principal) {
		String loginId = principal.getName();
		if(loginId==null)
			return "false";
		noticeReply.setWriterId(loginId);
		int result = service.insertNoticeReply(noticeReply);
		return "true";
	}
	
	@PostMapping("reply-delete-ajax")
	@ResponseBody
	public String replyDeleteAjax(@RequestBody Map<String, String> params) {
		int result = service.deleteNoticeReply(params);
		return "true";
	}
	
	@GetMapping("detail")
	public String detail(Model model, String id
			,@RequestParam(value="f", defaultValue="title") String field
			,@RequestParam(value="q", defaultValue="") String query
			,@RequestParam(value="s", defaultValue="regDate") String sortField
			,@RequestParam(value="p", defaultValue="1") String page) {
		Notice notice = service.getNotice(id);
		Map<String, String> param = service.generateNoticeParam(field, query,  sortField, Integer.parseInt(page));
		model.addAttribute("notice", notice);
		model.addAttribute("param", param);
		return "community.notice.detail";
	}
	
	@GetMapping("reg")
	public String reg(Model model, String id
			,@RequestParam(value="f", defaultValue="title") String field
			,@RequestParam(value="q", defaultValue="") String query
			,@RequestParam(value="s", defaultValue="regDate") String sortField
			,@RequestParam(value="p", defaultValue="1") String page) {
		Map<String, String> param = service.generateNoticeParam(field, query,  sortField, Integer.parseInt(page));
		model.addAttribute("param", param);
		return "community.notice.reg";
	}
	
	@PostMapping("reg")
	public String reg(Notice notice, Principal principal) {
		String writerId = principal.getName();
		notice.setWriterId(writerId);
		int result = service.insertNotice(notice);
		return "redirect:list";
	}
	
	@GetMapping("edit")
	public String edit(Model model, String id
			,@RequestParam(value="f", defaultValue="title") String field
			,@RequestParam(value="q", defaultValue="") String query
			,@RequestParam(value="s", defaultValue="regDate") String sortField
			,@RequestParam(value="p", defaultValue="1") String page) {
		
		Notice notice = service.getNotice(id);
		
		Map<String, String> param = service.generateNoticeParam(field, query,  sortField, Integer.parseInt(page));
		
		model.addAttribute("param", param);
		model.addAttribute("notice", notice);
		
		return "community.notice.edit";
	}
	
	@PostMapping("edit")
	public String edit(Notice notice
			,@RequestParam(value="f", defaultValue="title") String field
			,@RequestParam(value="q", defaultValue="") String query
			,@RequestParam(value="s", defaultValue="regDate") String sortField
			,@RequestParam(value="p", defaultValue="1") String page) {
		int result = service.updateNotice(notice);
		String queryString = "p="+page+"&f="+field+"&q="+query+"&s=regDate";
		return "redirect:list?"+queryString;
	}
	
	@PostMapping("delete")
	public String delete(@RequestParam Map<String, String> params, Model model
			,@RequestParam(value="f", defaultValue="title") String field
			,@RequestParam(value="q", defaultValue="") String query
			,@RequestParam(value="s", defaultValue="regDate") String sortField
			,@RequestParam(value="p", defaultValue="1") String page) {
		int result = service.deleteNotice(params);
		String queryString = "p="+page+"&f="+field+"&q="+query+"&s=regDate";
		return "redirect:list?"+queryString;
	}

}