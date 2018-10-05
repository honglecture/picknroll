<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript" src="/resources/js/member/login.js"></script>
<main id="main">
	<section>
		<h1>로그인</h1>
		<div>
			<h2><a href="/index"><img src="/resources/images/logo.png" alt="로고" /></a></h2>
		</div>
		<div>
			<h2>홈버튼</h2>
			<input type="button" value="홈버튼" class="button home-button" />
		</div>
	
		<div id="member-section">
			<div>
				<h2 class="hidden">회원메뉴</h2>
				<ul>
					<li><a href="join-reg">회원가입</a></li>
					<li><a href="find-id">계정찾기</a></li>
				</ul>
			</div>
			<h2 class="hidden">로그인폼</h2>
			<form method="post" class="member-form">
				<ul>
					<li><label for="username"><img
							src="/resources/images/icon-member.png" /></label> <input type="text"
						name="username" id="username" placeholder="아이디를 입력해주세요."
						autocomplete=off /></li>
					<li><label for="password"><img
							src="/resources/images/icon-lock.png" /></label> <input type="password"
						name="password" id="password" placeholder="비밀번호를 입력해주세요."
						autocomplete=off /></li>
					<li><input type="checkbox" id="auto-login" /> <label
						for="auto-login">자동로그인</label></li>
				</ul>
				<div>
					<input type="submit" value="로그인" />
				</div>
			</form>
		</div>
	</section>
</main>