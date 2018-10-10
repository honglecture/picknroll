<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="/resources/js/member/detail-edit.js"></script>
<link href="/resources/css/member/style.css" type="text/css" rel="stylesheet">
<main id="main" class="main-container">
	<section id="main-title" class="main-title">
		<h1 class="hidden">이름</h1>
		<span>> 부가정보 변경</span>
		<div class="page-explanation">
			<h2 class="hidden">부가설명</h2> 
			<p>서비스에 필요한 부가정보를 변경해주세요.</p> 
		</div>
	</section>
	<section id="member-section">
		<h1 class="hidden">부가정보변경</h1>
		<div class="member-profile">
			<h2 class="hidden">프로필사진</h2> 
			<div class="inline-center">
				<c:if test="${member.photo eq ''}">
					<img class="photo" src="/resources/images/default_profile.png" />
				</c:if>
				<c:if test="${member.photo ne ''}">
					<img class="photo" src="/resources/users/${member.id }/${member.photo}" />
				</c:if>
			</div>
		</div> 
		<div class="member-form">
			<h2 class="hidden">부가정보변경폼</h2>
			<form method="post" enctype="multipart/form-data">
				<ul>
					<li>
						<label class="input-explanation">프로필사진</label>
						<div>
							<input type="file" id="file-button" name="photo-file" hidden="true" value="파일선택" />
							<input class="button photo-button" type="button" value="파일선택" />
						</div>
					</li>
					<li>
						<label class="input-explanation">성별</label>
						<div>
							<select class="text-input" name="gender">  
							 	<c:if test="${member.gender eq  'm'}">
									<option value="m" selected="selected">남</option>
									<option value="f">여</option>						 	
							 	</c:if>
							 	<c:if test="${member.gender eq  'f'}">
									<option value="m">남</option>
									<option value="f" selected="selected">여</option>						 							 	
							 	</c:if>
							</select>
						</div>
					</li>
					<li>
						<label class="input-explanation">생년월일</label>
						<div>
							<input class="text-input inline-left" name="birthday" type="date" value="${member.birthday }">
						</div>
					</li>
	 			</ul>    
				<div class="submit-button">
					<input class="button" type="submit" value="완료" />
				</div> 
			</form>
		</div>
	</section>
</main>