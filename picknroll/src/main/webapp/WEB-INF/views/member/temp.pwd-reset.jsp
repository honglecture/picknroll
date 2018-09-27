<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- <link rel="stylesheet" type="text/css" href="/resources/css/member/pwd-reset.css"> -->
<main id="main"> 
	<div class="main-container">
		<section id="top-menu">
			<input type="button" value="홈버튼" class="button home-button" />
		</section>
		
		<section id="main-title"> 
			<h1>계정찾기</h1> 
		</section>
		
		<section id="page-description">
			<h1 class="hide">부가설명</h1> 
			<p>
				회원님의 아이디는 ${id }입니다.<br />
				비밀번호를 변경하시려면 비밀번호 변경 버튼을 눌러주세요.
			</p> 
		</section>
		
		<section id="pwd-reset" class="">
			<h1 class="hide">리셋버튼</h1> 
			<input type="button" class="button blue-button wide-button" value="비밀번호 변경" />
		</section>
		
		<section id="member-container" class="content-container">
			<h1 class="hide">회원가입폼</h1> 
			<form action="pwd-reset" method="post" id="member-form">
				<input type="hidden" value="${id }" name="id">
				<ul class="hide">
					<li><label class="list-label" for="">새 비밀번호</label><input type="password" class="input-underline" name="new-password" id="new-password"  autocomplete=off /></li>
					<li><label class="list-label" for="">새 비밀번호 확인</label><input type="password" class="input-underline" id="new-password-check"  autocomplete=off /></li>
	 			</ul>    
				<input id="submit-button" class="button black-button bottom-button" type="submit" value="완료" />  
			</form>
		</section>
	</div>  
</main>