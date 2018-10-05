package com.picknroll.web.service;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import com.picknroll.web.entity.Member;

public interface MemberService {
	
	boolean isEmailDuplicated(String email);

	boolean isIdDuplicated(String id);

	boolean isNicknameDuplicated(String nickname);

	int insertMemberWithBcrypt(Member member);

	int updateMemberDetail(Member member);

	int updateMemberPassword(String id, String password);

	String insertProfilePicture(String id, MultipartFile photoFile, HttpServletRequest request) throws IOException;

	String updateProfilePicture(String id, MultipartFile photoFile, HttpServletRequest request) throws IOException;

	Member getMember(String id);

	String getMemberId(String email, String birthday);
	
}