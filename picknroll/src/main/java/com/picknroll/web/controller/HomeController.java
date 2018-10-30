package com.picknroll.web.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.picknroll.web.entity.App;
import com.picknroll.web.entity.Member;
import com.picknroll.web.service.HomeService;
import com.picknroll.web.util.ParameterUtil;

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
			String memberId = principal.getName();
			List<App> appList = homeService.getAppListByMemberId(ParameterUtil.mapping("memberId",memberId));
			model.addAttribute("appList", appList);
		}
		return "home.index";
	}
	
	@GetMapping("/intro/introduction")
	public String introduction() {
		return "home.intro.introduction";
	}
	
}
