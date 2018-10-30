<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="/resources/css/index.css" type="text/css" rel="stylesheet">
<main id="main" class="main-container">
	<section id="menu-list" class="content-wrapper"> 
		<h1 class="hidden">메뉴 리스트</h1>
		<ul>
			<security:authorize access="!isAuthenticated()">
				<li class="app-item">
					<a href="/member/login">
						<div class="app-image" style="background: url('/resources/images/person.png') no-repeat center black; background-size: cover;"></div>
						<span class="app-title">로그인</span>
					</a>
				</li>
				<li class="app-item">
					<a href="/member/join-reg">
						<div class="app-image" style="background: url('/resources/images/person_add.png') no-repeat center black; background-size: cover;"></div>
						<span class="app-title">회원가입</span>
					</a>
				</li>
			</security:authorize>
			<security:authorize access="isAuthenticated()">
				<c:if test="${empty member.photo}">
					<li class="app-item">
						<a href="/member/profile">
							<div class="app-image" style="background: url('/resources/images/default_profile.png') no-repeat center; background-size: cover;"></div>
							<span class="app-title">프로필</span>
						</a>
					</li>
				</c:if>
				<c:if test="${not empty member.photo}">
					<li class="app-item">
						<a href="/member/profile">
							<div class="app-image" style="background: url('/resources/users/${member.id}/${member.photo }') no-repeat center; background-size: cover;"></div>
							<span class="app-title">프로필</span>
						</a>
					</li>
				</c:if>
			</security:authorize>
			
			<li class="app-item">
				<a href="/intro/introduction">
					<div class="app-image" style="background: url('/resources/images/face.png') no-repeat center black; background-size: cover;"></div>
					<span class="app-title">사이트소개</span>
				</a>
			</li>
			<li class="app-item">
				<a href="/notice/list">
					<div class="app-image" style="background: url('/resources/images/notice.png') no-repeat center black; background-size: cover;"></div>
					<span class="app-title">공지사항</span>
				</a>
			</li>
			<li class="app-item">
				<a href="/market/list">
					<div class="app-image" style="background: url('/resources/images/store.png') no-repeat center black; background-size: cover;"></div>
					<span class="app-title">마켓</span>
				</a>
			</li>
			<security:authorize access="isAuthenticated()">
				<c:forEach items="${appList }" var="app">
					<c:if test="${app.status && app.memberId ne null}">
						<li class="app-item">
							<a href="${app.url }" target="${app.target }">
								<div class="app-image" style="background: url('/resources/app/icon/${app.icon}') no-repeat center; background-size: cover;"></div>
								<span class="app-title">${app.title }</span>
							</a>
						</li>
					</c:if>
				</c:forEach>
			</security:authorize>
		</ul>
		<security:authorize access="hasRole('ADMIN')">  
			<div class="section-margin">
				<a href="/admin/index"><input type="button" value="관리자페이지" class="button"></a>
			</div>
		</security:authorize>
		</section>
</main>