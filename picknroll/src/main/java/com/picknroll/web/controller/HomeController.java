package com.picknroll.web.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.picknroll.web.entity.Member;
import com.picknroll.web.service.HomeService;

@Controller
@RequestMapping("/")
public class HomeController {
	
	@Autowired
	private HomeService homeService;
	
	@GetMapping("index")
	public String index(Principal principal, Model model) {
		if(principal!=null) {
			Member member = homeService.getMember(principal.getName());
			model.addAttribute("member", member);
		}
		return "home.index";
	}
	
	@GetMapping("introduction")
	public String introduction() {
		return "home.intro.introduction";
	}
	
}
