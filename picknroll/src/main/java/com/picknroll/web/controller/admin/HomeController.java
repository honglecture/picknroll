package com.picknroll.web.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("adminHomeController")
@RequestMapping("/admin/")
public class HomeController {

	@RequestMapping("index")
	public String index() {
		return "admin.index";
	}

}
