<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- <link rel="stylesheet" type="text/css" href="/resources/css/member/profile.css"> -->
<main id="main"> 
	<div class="main-container">  
		<section id="top-menu">
			<input type="button" value="홈버튼" class="button home-button" />
		</section>
		
		<section id="main-title"> 
			<h1>프로필</h1> 
		</section>
		
		<section id="member-profile">
			<h1 class="hide">프로필사진</h1>
			<div>
				<img class="photo" src="/resources/users/${member.id }/${member.photo}" />
			</div>
		</section>
		  
		<section id="member-container" class="content-container">
			<h1 class="hide">프로필</h1>
			<div action="" id="member-form">
				<ul>
					<li><label class="list-label" for="">아이디</label> <span>${member.id }</span></li>
					<li><label class="list-label" for="">이메일</label> <span>${member.email }</span></li>
					<li><label class="list-label" for="">닉네임</label> <span>${member.nickname }</span></li>
					<li><label class="list-label" for="">성별</label> <span>${member.gender }</span></li>
					<li><label class="list-label" for="">생년월일</label> <span>${member.birthday }</span></li>
	 			</ul>    
			</div>
		</section>
		<section id="edit-buttons">
			<a href="pwd-edit"><span>비밀번호변경</span></a>
			<a href="detail-edit"><span>부가정보변경</span></a>
<!-- 			<input id="password-button" class="button black-button bottom-button-md" type="button" value="비밀번호변경" />
			<input id="detail-button" class="button black-button bottom-button-md" type="button" value="부가정보변경" /> -->
		</section>
	</div>  
</main>