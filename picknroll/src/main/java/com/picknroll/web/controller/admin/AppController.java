package com.picknroll.web.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.picknroll.web.entity.App;
import com.picknroll.web.entity.AppCategory;
import com.picknroll.web.service.AppService;

@Controller("adminAppController")
@RequestMapping("/admin/app/")
public class AppController {
	
	@Autowired
	private AppService service;
	
	@GetMapping("list")
	public String list(Model model) {
		
		List<App> appList = service.getAppList();
		model.addAttribute("appList", appList);
		
		return "admin.app.list";
	}
	
	@GetMapping("reg")
	public String reg(Model model) {
		List<AppCategory> list = service.getAppCategoryList();
		model.addAttribute("appCategoryList", list);
		return "admin.app.reg";
	}
	
	@GetMapping("edit/{appId}")
	public String edit(Model model, @PathVariable String appId) {
		List<AppCategory> list = service.getAppCategoryList();
		App app = service.getApp(appId);
		model.addAttribute("appCategoryList", list);
		model.addAttribute("app", app);
		return "admin.app.edit";
	}
	
	@PostMapping("edit/{appId}")
	public String edit(@PathVariable String appId, App app,
			@RequestParam("photo-file") MultipartFile photoFile, String originalIcon,
			HttpServletRequest request) {
		try {
			if(!photoFile.getOriginalFilename().equals("")) {
				String uploadedFileName = service.updateProfilePicture(originalIcon, photoFile, request);
				System.out.println(uploadedFileName);
				app.setIcon(uploadedFileName);
			}
			app.setId(Long.parseLong(appId));
			int result = service.updateApp(app);
		} catch (IOException e) {
			e.printStackTrace();
			return "redirect:join-error";
		}
		return "redirect:../list";
	}
	
	@PostMapping("reg")
	public String reg(App app, @RequestParam("photo-file") MultipartFile photoFile,
			HttpServletRequest request) {
		try {
			String originalFilename = photoFile.getOriginalFilename();
			System.out.println(originalFilename);
			String uploadedFileName = "";
			if(!originalFilename.equals("") && originalFilename != null) 
				uploadedFileName = service.insertAppPicture(photoFile, request);
			app.setIcon(uploadedFileName);
			int result = service.insertApp(app);
		} catch (IOException e) {
			e.printStackTrace();
			return "redirect:join-error";
		}
		return "redirect:list";
	}
	

	@PostMapping("delete")
	public String delete(long id) {
		int result = service.deleteApp(id);
		return "redirect:list";
	}
	
}