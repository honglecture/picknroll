<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<link href="/resources/css/community/style.css" type="text/css" rel="stylesheet">
<script type="text/javascript" src="/resources/js/community/notice/detail.js"></script>
<main class="main-container">
	<section class="main-title">
		<h1><a href="list">> 공지사항</a></h1>
	</section> 
	<section class="section-margin" id="article-content"> 
		<h1 class="hidden">공지사항 글</h1>
		<h3 class="section-margin">${notice.title }
		<c:if test="${notice.replyCount ne '0'}">
			(${notice.replyCount })
		</c:if> 
		</h3>
		<%-- <div class="section-margin">${notice.title }</div> --%> 
		<div class="article-info section-margin flex flex-vertical-center">
			<div>
				<img class="photo" src="/resources/users/${notice.writerId }/${notice.photo}" />
			</div>
			<span></span>
			<ul class="noto-sans">
				<li class="jeju-gothic">${notice.nickname }</li>
				<li class="font-sm">번호 : ${notice.id }</li>
				<li class="font-sm">조회수 : ${notice.hit }</li>  
				<li class="font-sm">작성일 : <fmt:formatDate value="${notice.regDate }" pattern="yyyy-MM-dd"/></li>
			</ul>   
		</div>
		<div class="section-margin noto-sans font-md"> 
			<h2 class="hidden">공지사항 본문</h2> 
			<p>${notice.content }</p>
		</div>
		<div class="section-margin">
			<input type="button" class="list-button button" value="목록">
			<security:authorize access="isAuthenticated()">
				<security:authorize access="hasRole('ADMIN')">
					<input type="button" class="edit-button button" value="수정">
					<form action="delete" method="post">
						<input type="hidden" value="${notice.id }" name="id">
						<input type="hidden" name="s" value="${param.s}">
						<input type="hidden" name="p" value="${param.p}">
						<input type="hidden" name="q" value="${param.q}">
						<input type="hidden" name="f" value="${param.f}">
						<input class="delete-button button" type="submit" value="삭제" />
					</form>
				</security:authorize>
			</security:authorize>
		</div>	
	</section>
	
	<section class="section-margin" id="article-reply">
		<h1 class="hidden">댓글리스트</h1>
		<span class="noto-sans font-sm">댓글 총 <span class="reply-count jeju-gothic"></span>개</span>
		<div class="reply-list">
<!-- 			<div class="div-box-gray section-margin noto-sans font-md">
				<p>가슴이 설레는 말이다 청춘! 너의 두손을 가슴에 대고 물방아 같은 심장의 고동을 들어 보라 청춘의 피는 끓는다 끓는 피에 뛰노는 심장은 거선의 기관과 같이 힘있다 이것이다 인류의 역사를 꾸며 내려온 동력은 바로</p>
				<ul class="flex flex-vertical-center"> 
					<li><span class="jeju-gothic">고슴도치가시</span> | 2018.08.13 </li>
					자기것만 삭제 가능해야 함
					<li><input class="button notice-button-sm" type="button" value="삭제" /></li>
				</ul>
			</div> -->
		</div>
		
		<security:authorize access="!isAuthenticated()">
			<textarea placeholder="댓글을 작성하시려면 로그인을 해주세요." readonly="readonly"  class="div-box-gray section-margin noto-sans font-md text-input"></textarea>
		</security:authorize>
		<security:authorize access="isAuthenticated()">
			<textarea placeholder="댓글 작성 시 타인에 대한 배려와 책임을 담아주세요."  class="div-box-gray section-margin noto-sans font-md text-input"></textarea>
			<input class="button" type="submit" value="댓글등록" />
		</security:authorize>
		</section>
		
</main>