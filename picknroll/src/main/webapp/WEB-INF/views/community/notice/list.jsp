<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<main>
	<h1>공지사항</h1>
	<section id="search-section">
		<h1 class="hidden">글검색</h1>
		<form method="get">
			<select name="f">
				<option value="title">제목</option>
				<option value="content">내용</option>
				<option value="writerId">작성자</option>
			</select>
			<input name="q" type="text" />
			<input type="submit" value="검색" />
		</form>
	</section>
	
	<section id="article-section">
		<h1 class="hidden">글목록</h1>
		<ul>
			<li>
				<article>
					<h1><a href="84">프로그래밍 무엇부터 시작해야 하나요?</a></h1>
					<div class="">
						<ul>
							<li>번호 : 1</li>
							<li>이름 : 관리자</li>
							<li>좋아요 : 30</li>
							<li>날짜 : 2018.08.13</li>
						</ul>
					</div>
				</article>
			</li>
		</ul>
		<div>1 2 3 4 5</div>
	</section>
	<security:authorize access="hasRole('ADMIN')">  
		<div>
			<input type="button" value="글쓰기" class="reg-button">
		</div>
	</security:authorize>
</main>