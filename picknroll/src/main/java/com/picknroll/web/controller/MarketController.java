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
import org.springframework.web.bind.annotation.ResponseBody;

import com.picknroll.web.entity.App;
import com.picknroll.web.entity.AppCategory;
import com.picknroll.web.entity.MemberApp;
import com.picknroll.web.service.AppService;

@Controller
@RequestMapping("/market/")
public class MarketController {
	
	@Autowired
	private AppService service;
	
	@GetMapping("list")
	public String list(Model model) {
		List<AppCategory> appCategoryList = service.getAppCategoryList();
		model.addAttribute("appCategoryList", appCategoryList);
		return "market.list";
	}
	
	@PostMapping("list-ajax")
	@ResponseBody
	public String listAjax(@RequestBody Map<String, String> params, Principal principal) {
		String memberId = principal.getName();
		//List<App> appList = service.getAppList(params);
		params.put("memberId", memberId);
		List<App> appList = service.getAppListByMemberId(params);
		
		//int totalCount = service.getAppTotalCount(params);
		int totalCount = service.getAppTotalCountByMemberId(params);
		JSONObject returnObject = new JSONObject();
		JSONArray array = new JSONArray();
		for(App app : appList) {
			JSONObject object = new JSONObject();
			object.put("id", app.getId());
			object.put("title", app.getTitle());
			object.put("url", app.getUrl());
			object.put("icon", app.getIcon());
			object.put("status", app.getStatus());
			object.put("isLogin", app.getIsLogin());
			object.put("description", app.getDescription());
			object.put("target", app.getTarget());
			object.put("categoryName", app.getCategoryName());
			object.put("appCategoryId", app.getAppCategoryId());
			object.put("regDate", new SimpleDateFormat("yyyy-MM-dd").format(app.getRegDate()));
			object.put("editDate", new SimpleDateFormat("yyyy-MM-dd").format(app.getEditDate()));
			object.put("memberId", app.getMemberId());
			array.add(object);
		}
		returnObject.put("totalCount", totalCount);
		returnObject.put("list", array);
		return returnObject.toJSONString();
	}
	
	@PostMapping("reg-member-app-ajax")
	@ResponseBody
	public String regMemberAppAjax(@RequestBody Map<String, String> params, Principal principal) {
		
		String memberId = principal.getName();
		String useFlag = params.get("useFlag");
		
		MemberApp memberApp = new MemberApp(memberId, Long.parseLong(params.get("appId")));
		
		if(useFlag.equals("true")) {
			int result = service.insertMemberApp(memberApp);
		} else {
			int result = service.deleteMemberApp(memberApp);
		}
		
		return "true";
	}
	
	
	
}