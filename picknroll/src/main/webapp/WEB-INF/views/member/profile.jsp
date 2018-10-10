<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="/resources/css/member/style.css" type="text/css" rel="stylesheet">
<main id="main" class="main-container">
	<section id="main-title" class="main-title">
		<h1 class="hidden">이름</h1>
		<span>> 프로필</span>
	</section>
	<section id="member-section">
		<h1 class="hidden">회원가입 폼</h1>
		<div class="member-profile">
			<h2 class="hidden">프로필사진</h2> 
			<div class="inline-center">
				<c:if test="${empty member.photo}">
					<img class="photo" src="/resources/images/default_profile.png" />
				</c:if>
				<c:if test="${not empty member.photo}">
					<img class="photo" src="/resources/users/${member.id }/${member.photo}" />
				</c:if>
			</div>
		</div> 
		<div class="member-form">
			<h2 class="hidden">회원가입폼</h2>
			<ul>
				<li>
					<label class="input-explanation">아이디</label>
					<div>
						<input type="text" class="text-input" value="${member.id }" readonly="readonly"
						autocomplete=off />
					</div>
				</li>
				<li>
					<label class="input-explanation">이메일</label>
					<div>
						<input type="text" class="text-input" value="${member.email }" readonly="readonly"
						autocomplete=off />
					</div>
				</li>
				<li>
					<label class="input-explanation">닉네임</label>
					<div>
						<input type="text" class="text-input" value="${member.nickname }" readonly="readonly"
						autocomplete=off />
					</div>
				</li>
				<li>
					<label class="input-explanation">성별</label>
					<div>
						<c:if test="${member.gender eq 'm'}">
							<input type="text" class="text-input" value="남" readonly="readonly" autocomplete=off />						
						</c:if>
						<c:if test="${member.gender eq 'f'}">
							<input type="text" class="text-input" value="여" readonly="readonly" autocomplete=off />
						</c:if>
					</div>
				</li>
				<li>
					<label>생년월일</label>
					<div>
						<input type="text" class="text-input" value="${member.birthday }" readonly="readonly"
						autocomplete=off />
					</div>
				</li>
 			</ul>    
			<div class="submit-button">
				<a href="pwd-edit"><input class="button" type="button" value="비밀번호 변경" /></a>
				<a href="detail-edit" ><input class="button" type="button" value="부가정보 변경" /></a>
				<a href="/member/logout" ><input class="button" type="button" value="로그아웃" /></a>
			</div> 
		</div>
	</section>
</main>