package com.picknroll.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {
	
	@GetMapping("index")
	public String index() {
		return "home.index";
	}
	
	@GetMapping("introduction")
	public String introduction() {
		return "home.intro.introduction";
	}
	
}
