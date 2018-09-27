<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<header id="header"> 
	<h1>  
		<a href="/index">
			<picture>
				 <!-- 최소 700이상이면 바뀐다. -->
			 	 <!-- <source media="(min-width: 700px)" srcset="/resources/images/okinawa.jpg"> -->
				 <img src="/resources/images/logo.png">
			</picture>
		</a>   
	</h1>  
	   
	<section id="menu-button">  
		<h1 class="hidden">메뉴 버튼</h1> 
		<input class="button hamburger-button" type="button" value="메뉴보기">
	</section>
	
	<section id="header-buttons">  
		<h1 class="hidden">헤더 버튼</h1> 
		<input class="button notification-button" type="button" value="메뉴보기">
	</section>
	
	<aside id="notification-container"> 
		<h1 class="hidden">알림창</h1>     
		<section class="notification-arrow">
		</section>  
		<section class="notification-info">
			<ul>
				<li>나는 알람입니다. 잘부탁드립니다.</li>
			</ul>
		</section>
	</aside>
	
	<!-- aside로 묶는다. -->
	<aside id="login-info">
		<h1 class="hidden">로그인 정보</h1>
		<section class="profile">
			<h1 class="hidden">프로필</h1>
			<div>
				<div class="photo" style="background: url('/resources/images/okinawa.jpg') no-repeat center; background-size: cover; "></div>
				<div class="uid"><span>newlec</span></div>
				<!-- 인증한 놈 볼 수 없게 -->
				<!-- https://docs.spring.io/spring-security/site/docs/current/reference/html/el-access.html -->
				<div class="auth-status">
				
					<security:authorize access="!isAuthenticated()">
						<a href="/member/login">로그인</a>
						<!-- <a href="/member/join">회원가입</a> -->
					</security:authorize>
					
					<security:authorize access="isAuthenticated()">
						<a href="/member/logout"><security:authentication property="name"/> 님 로그아웃</a>
					</security:authorize>
						
				</div>
				  
				 <!-- ROLE_ 를 쓰지 않는다. -->
				<security:authorize access="hasRole('ADMIN')">  
					<div class="/admin/index"><span>강사공지 : </span><a href="#">3</a></div>
				</security:authorize>
				
			</div>     
		</section>   
		<section id="teacher-menu">
			<h1 class="hidden">메뉴</h1>
			<ul>
				<li><a href=/introduction>홈페이지 소개</a></li>
				<li><a href="/notice/list">공지사항</a></li>
				<li><a href="/make/list">만들어주세요</a></li>
				<li><a href="/fix/list">고쳐주세요</a></li>
				<li><a href="/free/list">자유게시판</a></li>
			</ul>
		</section>
	</aside>
	
</header>
<script>
window.addEventListener("load", function(){
    var header = document.querySelector("#header");
    var menuButton = document.querySelector("#menu-button");
    var headerButtons = document.querySelector("#header-buttons");
    var notificationContainer = document.querySelector("#notification-container");
    var notificationButton = headerButtons.querySelector(".notification-button");
    
    var loginInfo = document.querySelector("#login-info");
    
    var photo = loginInfo.querySelector(".photo");
    
    photo.onlick = function(e){
		location.href = "/member/profile";    	
    }
    
    header.onclick = function(e){
        var el = e.target; 
        if(el.nodeName =="HEADER"){
            header.classList.remove("menu-show");
        	header.classList.remove("notification-show");
        }
        else   
            return;  
    };   
      
    notificationButton.onclick = function(e){ 
    	header.classList.add("notification-show");  
        e.stopPropagation();    
    }
    
    menuButton.onclick = function(e){
        header.classList.add("menu-show"); 
        e.stopPropagation();
    };
    
});
</script>