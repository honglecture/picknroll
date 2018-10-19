<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<link href="/resources/css/market/style.css" type="text/css" rel="stylesheet">
<script type="text/javascript" src="/resources/js/market/list.js"></script>
<main id="main" class="main-container">

	<section class="main-title">
		<h1><a href="list">> 마켓</a></h1>
	</section>
	
	<section id="app-search" class="margin-section">
		<h1 class="hidden">검색폼</h1>
		<span class="text-sm">카테고리</span>
		<select class="category-select text-input" name="appCategoryId">
			<option value="" selected="selected">전체</option>
			<c:forEach items="${appCategoryList }" var="appCategory">
				<option value="${appCategory.id }">${appCategory.name }</option>
			</c:forEach>									
		</select>
	</section> 
	
	<section id="app-list-section" class="margin-section"> 
		<h1 class="hidden">앱목록</h1>
		<ul class="app-list-ul">
<!-- 			<li class="app-li div-box-black" data-id="3">
				<article class="app-article">
					reletive
					<div class="app-info flex flex-vertical-center">
						<img src="/resources/images/home.png" class="photo" />
						<ul> 
							<li class="text-lg">TodoList</li>
							<li class="text-sm">교육</li>
							<li class="text-sm">2018.08.13</li>
						</ul> 
						<input type="checkbox" class="use-check" />
					</div>
					<p class="noto-sans text-sm">
						나는설명충입니다.~~~~~~~~
						나는설명충입니다.~~~~~~~~
						나는설명충입니다.~~~~~~~~
						나는설명충입니다.~~~~~~~~
					</p>
				</article>
			</li> -->
			
		</ul>
	</section>
	
</main>