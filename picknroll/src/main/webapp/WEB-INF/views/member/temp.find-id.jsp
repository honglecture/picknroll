<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- <link rel="stylesheet" type="text/css" href="/resources/css/member/find-id.css"> -->
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
			<p>가입한 계정의 이메일과 생년월일을 입력해 주세요.</p> 
		</section>
		
		<section id="member-container" class="content-container">
			<h1 class="hide">계정찾기폼</h1>
			<form method="post" id="member-form">
				<ul>
					<li><label class="list-label" for="">이메일</label><input type="text" class="input-underline" name="email" id="email"  autocomplete=off /></li>
					<li>
						<label class="list-label" for="">생년월일</label>
						<input type="date" name="birthday" class="input-select">
					</li>
					
	 			</ul>    
				<input id="submit-button" class="button black-button bottom-button" type="submit" value="다음" />  
			</form>
		</section>
	</div>
</main>