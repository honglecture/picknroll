package com.picknroll.web.controller;

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
import com.picknroll.web.service.CommunityService;

@Controller
@RequestMapping("/notice/")
public class NoticeController {
	
	@Autowired
	private CommunityService service;
	
	@GetMapping("list")
	public String list(Model model, @RequestParam Map<String, String> params) {
		model.addAttribute("params", params);
		return "community.notice.list";
	}
	
	@PostMapping("list-ajax")
	@ResponseBody
	public String listAjax(@RequestBody Map<String, String> map) {
		List<Notice> noticeList = service.getNoticeList(map);
		JSONObject returnObject = new JSONObject();
		JSONArray array = new JSONArray();
		for(Notice notice : noticeList) {
			JSONObject object = new JSONObject();
			object.put("id", notice.getId());
			object.put("title", notice.getTitle());
			object.put("nickname", notice.getNickname());
			object.put("hit", notice.getHit());
			object.put("regDate", new SimpleDateFormat("yyyy-MM-dd").format(notice.getRegDate()));
			array.add(object);
		}
		returnObject.put("list", array);
		return returnObject.toJSONString();
	}

}