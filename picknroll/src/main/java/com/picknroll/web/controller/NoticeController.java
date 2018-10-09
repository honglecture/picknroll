package com.picknroll.web.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

}