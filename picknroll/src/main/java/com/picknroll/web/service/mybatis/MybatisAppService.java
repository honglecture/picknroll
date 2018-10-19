package com.picknroll.web.service.mybatis;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.picknroll.web.dao.AppCategoryDao;
import com.picknroll.web.dao.AppDao;
import com.picknroll.web.dao.MemberAppDao;
import com.picknroll.web.entity.App;
import com.picknroll.web.entity.AppCategory;
import com.picknroll.web.entity.MemberApp;
import com.picknroll.web.service.AppService;
import com.picknroll.web.util.ParameterUtil;

@Service
public class MybatisAppService implements AppService {
	
	@Autowired
	private AppDao appDao;
	
	@Autowired
	private AppCategoryDao appCategory;
	
	@Autowired
	private MemberAppDao memberAppDao;

	@Override
	public List<App> getAppList() {
		Map<String, String> map = new HashMap<String, String>();
		return getAppList(map);
	}
	
	@Override
	public List<App> getAppList(Map<String, String> params) {
		return appDao.getList(params);
	}
	
	@Override
	public List<App> getAppListByMemberId(Map<String, String> params) {
		return appDao.getListByMemberId(params);
	}

	@Override
	public List<AppCategory> getAppCategoryList() {
		return appCategory.getList();
	}

	@Override
	public int insertApp(App app) {
		return appDao.insert(app);
	}

	@Override
	public String insertAppPicture(MultipartFile photoFile, HttpServletRequest request) throws IOException {
		// 사진 저장 path 찾기
		String resLocation = "/resources/app/icon/";
		ServletContext context = request.getServletContext();
		String homeDir = context.getRealPath(resLocation);
		String uploadedFileName = photoFile.getOriginalFilename();
		String filePath = homeDir + uploadedFileName;
		// 사진 저장
		File dir = new File(homeDir);
		if (!dir.exists())
			dir.mkdirs();
		InputStream fis = photoFile.getInputStream();
		FileOutputStream fos = new FileOutputStream(filePath);
		byte[] buf = new byte[1024];
		int size = 0;
		// fis에서 읽어서 fos으로 복사하기
		while ((size = fis.read(buf, 0, buf.length)) > 0) // 0보다 클때까지
			fos.write(buf, 0, size);
		fis.close();
		fos.close();
		return uploadedFileName;
	}

	@Override
	public App getApp(String appId) {
		return appDao.get(ParameterUtil.mapping("id", appId));
	}

	@Override
	public int updateApp(App app) {
		return appDao.update(app);
	}

	@Override
	public String updateProfilePicture(String originalIcon, MultipartFile photoFile, HttpServletRequest request)
			throws IOException {
		// 사진 저장 path 찾기
		String resLocation = "/resources/app/icon/";
		ServletContext context = request.getServletContext();
		String homeDir = context.getRealPath(resLocation);
		String uploadedFileName = photoFile.getOriginalFilename();
		String filePath = homeDir + uploadedFileName;
		// 사진 저장
		File dir = new File(homeDir);
		if (!dir.exists())
			dir.mkdirs();
		
		// 기존 사진을 지우고 새로 insert 해야하는 거임 원래는
		
		InputStream fis = photoFile.getInputStream();
		FileOutputStream fos = new FileOutputStream(filePath);
		byte[] buf = new byte[1024];
		int size = 0;
		// fis에서 읽어서 fos으로 복사하기
		while ((size = fis.read(buf, 0, buf.length)) > 0) // 0보다 클때까지
			fos.write(buf, 0, size);
		fis.close();
		fos.close();
		return uploadedFileName;
	}

	@Override
	public int deleteApp(long id) {
		return appDao.delete(ParameterUtil.mapping("id", String.valueOf(id)));
	}

	@Override
	public int getAppTotalCount(Map<String, String> params) {
		return appDao.getTotalCount(params);
	}
	
	@Override
	public int getAppTotalCountByMemberId(Map<String, String> params) {
		return appDao.getTotalCountByMemberId(params);
	}

	@Override
	public int insertMemberApp(MemberApp memberApp) {
		return memberAppDao.insert(memberApp);
	}

	@Override
	public int deleteMemberApp(MemberApp memberApp) {
		return memberAppDao.delete(memberApp);
	}


}
