package com.picknroll.web.service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import com.picknroll.web.entity.App;
import com.picknroll.web.entity.AppCategory;
import com.picknroll.web.entity.MemberApp;

public interface AppService {

	List<App> getAppList();
	
	List<App> getAppList(Map<String, String> params);
	
	List<App> getAppListByMemberId(Map<String, String> params);

	List<AppCategory> getAppCategoryList();

	int insertApp(App app);

	String insertAppPicture(MultipartFile photoFile, HttpServletRequest request) throws IOException;

	App getApp(String appId);

	int updateApp(App app);

	String updateProfilePicture(String originalIcon, MultipartFile photoFile, HttpServletRequest request) throws IOException;

	int deleteApp(long id);

	int getAppTotalCount(Map<String, String> params);
	
	int getAppTotalCountByMemberId(Map<String, String> params);

	int insertMemberApp(MemberApp memberApp);

	int deleteMemberApp(MemberApp memberApp);

	

	



}
