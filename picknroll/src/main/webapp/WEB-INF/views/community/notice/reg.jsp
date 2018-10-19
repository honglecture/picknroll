<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<link href="/resources/css/community/style.css" type="text/css" rel="stylesheet">
<script type="text/javascript" src="/resources/js/community/notice/reg.js"></script>
<script type="text/javascript" src="/resources/ckeditor/ckeditor.js"></script>
<main class="main-container">
	<section class="main-title">
		<h1><a href="list">> 공지사항 등록</a></h1>
	</section> 
	<section class="section-margin" id="article-content">
		<h1 class="hidden">공지사항 등록</h1>
		<form method="post">
			<div class="section-margin">
				<input type="text" class="text-input" name="title"> 
			</div>
			<div class="section-margin noto-sans font-md"> 
				<textarea name="content" id="content"></textarea>
			</div>
			<input type="submit" class="section-margin reg-button button" value="등록">
		</form>
		<input type="button" class="section-margin list-button button" value="목록">	
	</section>
</main>