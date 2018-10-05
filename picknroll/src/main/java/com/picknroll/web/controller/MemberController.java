package com.picknroll.web.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.security.Principal;
import java.util.Map;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.picknroll.web.entity.Member;
import com.picknroll.web.service.MemberService;
import com.picknroll.web.util.GenerateCertCharacter;

@Controller
@RequestMapping("/member/")
public class MemberController {

	@Autowired
	private MemberService service;

	@Autowired
	private JavaMailSender mailSender;
	
	@GetMapping("login")
	public String login() {
		return "member.login";
	}
	
	@GetMapping("join-reg")
	public String joinReg() {
		return "member.join-reg";
	}
	
	// 회원가입
	@PostMapping("join-reg")
	public String joinReg(Model model, Member member, HttpSession session) {
		if (member == null)
			return "redirect:join-error";
		int count = service.insertMemberWithBcrypt(member);
		session.setAttribute("id", member.getId());
		return "redirect:join-detail";
	}

	@GetMapping("is-id-duplicated-ajax")
	@ResponseBody
	public String isIdDuplicatedAjax(String id) {
		// 한글처리를 해줘야 한다.
		boolean duplicated = service.isIdDuplicated(id);
		if (duplicated)
			return "true";
		return "false";
	}

	@GetMapping("is-nickname-duplicated-ajax")
	@ResponseBody
	public String isNicknameDuplicatedAjax(String nickname) {
		// 한글처리를 해줘야 한다.
		boolean duplicated = service.isNicknameDuplicated(nickname);
		if (duplicated)
			return "true";
		return "false";
	}

	@GetMapping("is-email-authentication-ajax")
	@ResponseBody
	public String isEmailAuthenticationAjax(String email, HttpServletResponse response) {
		
		boolean duplicated = service.isEmailDuplicated(email);

		if (duplicated)
			return "true";

		// ---이메일 보내기-----------------------------------------------------------
		MimeMessage message = mailSender.createMimeMessage();
		String certify = GenerateCertCharacter.excuteGenerate();
		
		// ---쿠키를 심는 작업-----------------------------------------------------------
		Cookie cookie = new Cookie("joinId", certify); //식별값, 문자열만 담아야 한다.
		cookie.setPath("/member/"); // 경로 member에서만 쓴다.
		cookie.setMaxAge(60*3); // 3분
		response.addCookie(cookie);
		
		try {
			// 마임 = 멀티미디어 포함
			MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
			helper.setFrom("noreply@newlecture.com");
			helper.setTo(email);
			helper.setSubject("PicknRoll 회원가입을 위한 인증메일");
			// 이메일보낼때.. 파라미터 이름 줄여서 쓰자~
			helper.setText("<h1>PicknRoll 가입 인증 번호</h1><h2>" + certify + "</h2>", true);
		} catch (MessagingException e) {
			e.printStackTrace();
		} // 쉽게 구현해주는 객체

		mailSender.send(message);
		return "false";
	}
	
	@PostMapping("is-email-authentication-ajax")
	@ResponseBody
	public String isEmailAuthenticationAjax(
			@RequestBody Map<String, String> params,
			@CookieValue(value="joinId", defaultValue="") String joinId,
			HttpServletResponse response) {
		if(!params.get("certify").equals(joinId)) 
			return "false";
		Cookie kc = new Cookie("joinId", null); // choiceCookieName(쿠키 이름)에 대한 값을 null로 지정
		kc.setMaxAge(0); // 유효시간을 0으로 설정
		response.addCookie(kc); // 응답 헤더에 추가해서 없어지도록 함
		return "true";
	}
	
	@GetMapping("is-pwd-email-authentication-ajax")
	@ResponseBody
	public String isPwdEmailAuthenticationAjax(String email, HttpServletResponse response) {
		boolean duplicated = service.isEmailDuplicated(email);
		if (!duplicated)
			return "false"; // 이메일이 없으면

		// ---이메일 보내기-----------------------------------------------------------
		MimeMessage message = mailSender.createMimeMessage();
		String certify = GenerateCertCharacter.excuteGenerate();
		
		// ---쿠키를 심는 작업-----------------------------------------------------------
		Cookie cookie = new Cookie("pwdJoinId", certify); //식별값, 문자열만 담아야 한다.
		cookie.setPath("/member/"); // 경로 member에서만 쓴다.
		cookie.setMaxAge(60*3); // 3분
		response.addCookie(cookie);
		
		try {
			// 마임 = 멀티미디어 포함
			MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
			helper.setFrom("noreply@newlecture.com");
			helper.setTo(email);
			helper.setSubject("PicknRoll 계정찾기를 위한 인증메일");
			// 이메일보낼때.. 파라미터 이름 줄여서 쓰자~
			helper.setText("<h1>PicknRoll 계정찾기 인증 번호</h1><h2>" + certify + "</h2>", true);
		} catch (MessagingException e) {
			e.printStackTrace();
		} // 쉽게 구현해주는 객체

		mailSender.send(message);
		return "true";
	}
	
	@PostMapping("is-pwd-email-authentication-ajax")
	@ResponseBody
	public String isPwdEmailAuthenticationAjax(
			@RequestBody Map<String, String> params,
			@CookieValue(value="pwdJoinId", defaultValue="") String pwdJoinId,
			HttpServletResponse response) {
		if(!params.get("certify").equals(pwdJoinId)) 
			return "false";
		Cookie kc = new Cookie("pwdJoinId", null); // choiceCookieName(쿠키 이름)에 대한 값을 null로 지정
		kc.setMaxAge(0); // 유효시간을 0으로 설정
		response.addCookie(kc); // 응답 헤더에 추가해서 없어지도록 함
		return "true";
	}


	@GetMapping("join-error")
	public String joinError() {
		return "member.join-error";
	}

	// 세부사항 회원가입
	@GetMapping("join-detail")
	public String joinDetail(HttpSession session) {
		String id = (String) session.getAttribute("id");
		if(id==null || id.equals("")) {
			session.removeAttribute("id");
			return "redirect:join-error";
		}
		return "member.join-detail";
	}
	
	// 세부사항 회원가입
	@PostMapping("join-detail")
	public String joinDetail(Member member, HttpSession session,
			@RequestParam("photo-file") MultipartFile photoFile,
			HttpServletRequest request) {
		String id = (String) session.getAttribute("id");
		if(id==null || id.equals("")) {
			return "redirect:join-error";
		}
		member.setId(id);
		try {
			String originalFilename = photoFile.getOriginalFilename();
			String uploadedFileName = "";
			if(!originalFilename.equals("") && originalFilename != null) {
				uploadedFileName = service.insertProfilePicture(id, photoFile, request);
			}
			member.setPhoto(uploadedFileName);
			int count = service.updateMemberDetail(member);
			session.removeAttribute("id");
		} catch (IOException e) {
			e.printStackTrace();
			return "redirect:join-error";
		}
		return "redirect:../index";
	}
	
	@GetMapping("pwd-reset")
	public String pwdReset(HttpSession session) {
		String id = (String) session.getAttribute("memberId");
		if(id==null || id.equals(""))
			return "redirect:join-error";
		session.setAttribute("memberId", id);
		return "member.pwd-reset";
	}

	@PostMapping("pwd-reset")
	public String pwdReset(String password, HttpSession session) {
		String id = (String) session.getAttribute("memberId"); 
		int count = service.updateMemberPassword(id, password);
		session.removeAttribute("memberId");
		return "redirect:login";
	}
	
	@GetMapping("pwd-edit")
	public String pwdEdit() {
		return "member.pwd-edit";
	}

	
	@PostMapping("pwd-edit")
	public String pwdEdit(String password, Principal principal){
		String id = principal.getName();
		int count = service.updateMemberPassword(id, password);
		return "redirect:profile";
	}

	@GetMapping("find-id")
	public String findId() {
		return "member.find-id";
	}
	
	@PostMapping("find-id")
	@ResponseBody
	public String findId(@RequestBody Map<String, String> params, HttpSession session) {
		String id = service.getMemberId(params.get("birthday"), params.get("email"));
		if(id==null || id.equals(""))
			return "false";
		session.setAttribute("memberId", id);
		return "true";
	}

	@GetMapping("detail-edit")
	public String detailEdit(Model model, Principal principal) {
		String id = principal.getName();
		Member member = service.getMember(id);
		model.addAttribute("member", member);
		return "member.detail-edit";
	}
	
	// 세부사항 업데이트
	@PostMapping("detail-edit")
	public String detailEdit(Member member, Principal principal,
			@RequestParam("photo-file") MultipartFile photoFile,
			HttpServletRequest request) {
		String id = principal.getName();
		member.setId(id);
		try {
			if(!photoFile.getOriginalFilename().equals("")) {
				String uploadedFileName = service.updateProfilePicture(id, photoFile, request);
				System.out.println(uploadedFileName);
				member.setPhoto(uploadedFileName);
			}
			int count = service.updateMemberDetail(member);
		} catch (IOException e) {
			e.printStackTrace();
			return "redirect:join-error";
		}
		return "redirect:profile";
	}

	@GetMapping("profile")
	public String profile(Model model, Principal principal) {
		String id = principal.getName();
		Member member = service.getMember(id);
		model.addAttribute("member", member);
		return "member.profile";
	}
	
	// 동적으로 이미지 만들기 - 일단 추가해 놓는데 나중에 해봐
	@GetMapping("checker.jpg")
	public void checker(HttpSession session, HttpServletResponse response) throws IOException {
		Random rand = new Random();
		int x = rand.nextInt(100);
		int y = rand.nextInt(10);
		
		String fmtString = String.format("%d+%d=", x,y);
		
		// 세션 값에 넣기
		session.setAttribute("checker", x+y); // checker
		
		// 메모리 상의 이미지가 필요하다. 비트맵이라는 도화지
		BufferedImage img = new BufferedImage(60, 30, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g = img.createGraphics();
		g.setFont(new Font("돋움", 0, 13)); // 글씨체, 스타일, 크기
		g.setColor(Color.WHITE); 
		g.fillRect(0, 0, 60, 30); 
		g.setColor(Color.BLACK); 
		g.drawString(fmtString, 5, 19);
		response.setContentType("image/png");
		ImageIO.write(img, "png", response.getOutputStream()); // 예외처리 원래는 해야 함
		
	}

}