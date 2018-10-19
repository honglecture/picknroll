package com.picknroll.web.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("adminMemberController")
@RequestMapping("/admin/member/")
public class MemberController {
	@RequestMapping("list")
	public String list(Model model) {
		return "admin.member.list";
	}
}
