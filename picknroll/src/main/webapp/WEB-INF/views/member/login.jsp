<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript" src="/resources/js/member/login.js"></script>
<link href="/resources/css/member/login.css" type="text/css" rel="stylesheet">
<main id="main" class="main-container">
	<section id="main-title" class="main-title">
		<h1>> 로그인</h1>
	</section>
	<section id="member-section">
		<h1 class="hidden">로그인 폼</h1>
		<div class="member-menu">
			<h2 class="hidden">회원메뉴</h2>
			<ul>
				<li><a href="join-reg">회원가입 | </a></li>
				<li><a href="find-id">계정찾기</a></li>
			</ul>
		</div>
		<form method="post" class="member-form">
			<ul>
				<li><label for="username"></label> <input type="text" class="text-input"
					name="username" id="username" placeholder="아이디를 입력해주세요."
					autocomplete=off /></li>
				<li><label for="password"></label> <input type="password" class="text-input"
					name="password" id="password" placeholder="비밀번호를 입력해주세요."
					autocomplete=off /></li>
				<li><input type="checkbox" id="auto-login" /><label
					for="auto-login" >자동로그인</label></li>
			</ul>
			<div class="submit-button">
				<input class="button" type="submit" value="로그인" />
			</div>
		</form>
	</section>
	
</main>