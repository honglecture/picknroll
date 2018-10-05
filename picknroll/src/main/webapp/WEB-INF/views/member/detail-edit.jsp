<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="/resources/js/member/detail-edit.js"></script>
<main id="main">
	<section id="member-section">
		<h1 class="hidden">부가정보</h1>
		<div>
			<h2>부가정보</h2> 
		</div>
		<div>
			<h2 class="hidden">부가설명</h2> 
			<p>서비스에 필요한 부가정보를 수정해주세요.</p> 
		</div>
		<div>
			<h2>홈버튼</h2>
			<input type="button" value="홈버튼" />
		</div>
		<div class="member-profile">
			<h2 class="hide">프로필사진</h2>
			<div>
				<c:if test="${member.photo eq ''}">
					<img class="photo" src="/resources/images/anonymous.jpg" />
				</c:if>
				<c:if test="${member.photo ne ''}">
					<img class="photo" src="/resources/users/${member.id }/${member.photo}" />
				</c:if>
			</div>
		</div>
		<div class="member-form">
			<h2 class="hidden">회원가입폼</h2>
			<form method="post" enctype="multipart/form-data"> 
				<ul>
					<li>
						<label>프로필사진</label>
						<input type="file" name="photo-file" hidden="true" value="파일선택" />
						<span class="photo-button">파일선택</span>
					</li>
					<li>
						<label>성별</label>
						<select name="gender">
						 	<c:if test="${member.gender eq  'm'}">
								<option value="m" selected="selected">남</option>
								<option value="f">여</option>						 	
						 	</c:if>
						 	<c:if test="${member.gender eq  'f'}">
								<option value="m">남</option>
								<option value="f" selected="selected">여</option>						 							 	
						 	</c:if>
						</select>
					</li>  
					<li>
						<label>생년월일</label>
						<input name="birthday" type="date" value="${member.birthday }">
					</li>
	 			</ul>    
				<input type="submit" value="완료" />
			</form>
		</div>
	</section>
</main>