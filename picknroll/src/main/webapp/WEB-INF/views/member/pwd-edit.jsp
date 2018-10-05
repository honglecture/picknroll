<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script src="/resources/js/member/pwd-edit.js"></script>
<main id="main"> 
	<section id="member-section">
		<h1 class="hidden">비밀번호 변경</h1>
		<div>
			<h2>비밀번호 변경</h2> 
		</div>
		<div>
			<h2 class="hidden">부가설명</h2> 
			<p>비밀번호는 주기적으로 변경해주세요.</p> 
		</div>
		
		<div>
			<h2>홈버튼</h2>
			<input type="button" value="홈버튼" class="button home-button" />
		</div>
		
		<div class="member-form">
			<h2 class="hidden">회원가입폼</h2>
			<form method="post">
				<ul>
					<li><label for="">새 비밀번호</label><input type="password" name="password" class="password" autocomplete=off /></li>
					<li><label for="">새 비밀번호 확인</label><input type="password" class="password-check"  autocomplete=off /></li>
	 			</ul>    
	 			<div>
					<input type="submit" value="완료" />
				</div>  
			</form>
		</div>
		
	</section>
</main>