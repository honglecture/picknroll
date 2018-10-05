<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script src="/resources/js/member/pwd-edit.js"></script>

<style>
	.hidden{
		display: none;
	}
</style>

<main id="main"> 
	<section id="member-section">
		<h1 class="hidden">계정찾기</h1>
		<div>
			<h2>계정찾기</h2> 
		</div>
		<div>
			<h2 class="hidden">부가설명</h2> 
			<p>
				회원님의 아이디는 ${memberId }입니다.<br />
				비밀번호를 변경하시려면 비밀번호 변경 버튼을 눌러주세요.
			</p> 
		</div>
		<div>
			<h2 class="hidden">홈버튼</h2>
			<input type="button" value="홈버튼" class="home-button" />
		</div>
		<div class="member-form">
			<h2 class="hidden">회원가입폼</h2>
			<div>
				<h2 class="hidden">리셋버튼</h2> 
				<input type="button" class="pwd-reset-button" value="비밀번호 변경" />
			</div>
			<form method="post" class="hidden">
				<ul>
					<li><label for="">새 비밀번호</label><input type="password" name="password" class="password" autocomplete=off /></li>
					<li><label for="">새 비밀번호 확인</label><input type="password" class="password-check" autocomplete=off /></li>
	 			</ul>    
	 			<div>
					<input type="submit" value="완료" />
				</div>  
			</form>
		</div>
	</section>
</main>