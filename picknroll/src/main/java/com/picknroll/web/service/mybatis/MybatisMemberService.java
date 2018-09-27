package com.picknroll.web.service.mybatis;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.picknroll.web.dao.MemberDao;
import com.picknroll.web.dao.MemberRoleDao;
import com.picknroll.web.entity.Member;
import com.picknroll.web.entity.MemberRole;
import com.picknroll.web.service.MemberService;
import com.picknroll.web.util.ParameterUtil;

@Service
public class MybatisMemberService implements MemberService {

	@Autowired
	private MemberDao memberDao;

	@Autowired
	private MemberRoleDao memberRoleDao;

	public boolean isEmailDuplicated(String email) {
		Member member = memberDao.getByEmail(ParameterUtil.mapping("email", email));
		if (member != null)
			return true;
		return false;
	}

	public boolean isIdDuplicated(String id) {
		
		Member member = memberDao.get(ParameterUtil.mapping("id", id));
		if (member != null)
			return true;
		return false;
	}

	@Override
	public boolean isNicknameDuplicated(String nickname) {
		Member member = memberDao.getByNickname(ParameterUtil.mapping("nickname", nickname));
		if (member != null)
			return true;
		return false;
	}

	@Override
	public int insertMemberWithBcrypt(Member member) {
		// 암호화
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		String encodedPwd = encoder.encode(member.getPassword());
		member.setPassword(encodedPwd);
		int memberResult = memberDao.insert(member);
		int memberRoleResult = memberRoleDao.insert(new MemberRole(member.getId(), "ROLE_CLIENT", true));
		return memberRoleResult;
	}

	@Override
	public int updateMemberDetail(Member member) {
		int result = memberDao.updateDetail(member);
		return result;
	}

	@Override
	public String insertProfilePicture(String id, MultipartFile photoFile, HttpServletRequest request)
			throws IOException {
		// 사진 저장 path 찾기
		String resLocation = "/resources/users/" + id + "/";
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
	public Member getMember(String id) {
		return memberDao.get(ParameterUtil.mapping("id", id));
	}

	@Override
	public int updateMemberPassword(String id, String newPassword) {
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		newPassword = encoder.encode(newPassword);
		int count = memberDao.updatePassword(id, newPassword);
		return count;
	}

	@Override
	public String updateProfilePicture(String id, MultipartFile photoFile, HttpServletRequest request)
			throws IOException {
		// 사진 저장 path 찾기
		String resLocation = "/resources/users/" + id + "/";
		ServletContext context = request.getServletContext();
		String homeDir = context.getRealPath(resLocation);
		String uploadedFileName = photoFile.getOriginalFilename();
		String filePath = homeDir + uploadedFileName;
		System.out.println(filePath);
		// 사진 저장
		File dir = new File(homeDir);
		if (!dir.exists())
			dir.mkdirs();
		
		// dir에 있는 파일을 다 지워야 한다.
		File[] deleteFolderList = dir.listFiles();
		for (int i = 0; i < deleteFolderList.length;)
			deleteFolderList[i].delete();
		
		
		
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
	public String getMemberId(String email, String birthday) {
		String id = memberDao.getByEmailGender(email, birthday);
		return id;
	}

}