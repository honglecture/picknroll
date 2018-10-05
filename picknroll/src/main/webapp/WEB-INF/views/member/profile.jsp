<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<main id="main"> 
	<section id="member-section">
	
		<h1 class="hidden">프로필</h1>
		
		<div>
			<h2>프로필</h2> 
		</div>
		
		<div class="member-profile">
			<h2 class="hide">프로필사진</h2>
			<div>
				<img class="photo" src="/resources/users/${member.id }/${member.photo}" />
			</div>
		</div>
		
		<div>
			<h2>홈버튼</h2>
			<input type="button" value="홈버튼" class="button home-button" />
		</div>
		
		<div class="member-form">
			<ul>
				<li><label class="list-label" for="">아이디</label> <span>${member.id }</span></li>
				<li><label class="list-label" for="">이메일</label> <span>${member.email }</span></li>
				<li><label class="list-label" for="">닉네임</label> <span>${member.nickname }</span></li>
				<li>
					<label class="list-label" for="">성별</label>
					<c:if test="${member.gender eq 'm'}">
						<span>남자</span>
					</c:if>
					<c:if test="${member.gender eq 'f'}">
						<span>여자</span>
					</c:if>
				</li>
				<li><label class="list-label" for="">생년월일</label> <span>${member.birthday }</span></li>
 			</ul>    
		</div>
		
		<div class="edit-buttons">
			<a href="pwd-edit"><span>비밀번호변경</span></a>
			<a href="detail-edit"><span>부가정보변경</span></a>
		</div>
		
	</section>

</main>