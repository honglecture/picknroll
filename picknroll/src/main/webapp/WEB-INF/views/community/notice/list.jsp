<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<link href="/resources/css/community/style.css" type="text/css" rel="stylesheet">
<script type="text/javascript" src="/resources/js/community/notice/list.js"></script>
<main id="main" class="main-container">
	<section class="main-title">
		<h1><a href="list">> 공지사항</a></h1>
	</section>
	<section id="search-section">
		<h1 class="hidden">글검색</h1>
		<form class="search-form" method="get">
			<select class="text-input" name="f">
<!-- 				<option value="title">제목</option>
				<option value="content">내용</option>
				<option value="nickname">작성자</option> -->
				<option value="title" <c:if test="${param.f eq 'title'}">selected</c:if>>제목</option>
	    		<option value="content" <c:if test="${param.f eq 'content'}">selected</c:if>>내용</option>
			    <option value="nickname" <c:if test="${param.f eq 'nickname'}">selected</c:if>>작성자</option>
			</select>
			<input type="text" class="text-input" name="q" value="${param.q }" placeholder="검색어를 입력해주세요." autocomplete=off />
			<input type="submit" class="button" value="검색" />
		</form>
	</section>
	
	<section id="article-list">
		<h1 class="hidden">글목록</h1>
		<ul>
<!-- 
			<li>
				<a href="detail?">
					<article class="article">
						<span>프로그래밍 무엇부터 시작해야 하나요?</span> 
						<div class="article-info"> 
							<ul>
								<li>번호 : 1 |</li> 
								<li>작성자 : 관리자 |</li>
								<li>조회수 : 3 |</li>
								<li>작성일 : 2018.08.13</li>
							</ul>
						</div>
					</article>
				</a>
			</li>
 -->
		</ul>
		
 		<div class="pagination">
 			<ul class="flex flex-center section-margin">
<!--  				<li class="pagination-item">&lt;&lt;</li>
	 			<li class="pagination-item">&lt;</li>
	 			<li class="pagination-item">1</li>
	 			<li class="pagination-item">2</li>
	 			<li class="pagination-item">3</li>
	 			<li class="pagination-item">4</li>
	 			<li class="pagination-item">5</li>
	 			<li class="pagination-item">&gt;</li>
	 			<li class="pagination-item">&gt;&gt;</li> -->
 			</ul>
		</div>
		
	 	<security:authorize access="hasRole('ADMIN')">  
			<div class="section-margin">
				<input type="button" value="글쓰기" class="reg-button button">
			</div>
		</security:authorize>
	
	</section>
</main>