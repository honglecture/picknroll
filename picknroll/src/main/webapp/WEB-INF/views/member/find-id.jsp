<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script src="/resources/js/member/find-id.js"></script>
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
			<p>가입한 계정의 이메일과 생년월일을 입력해 주세요.</p> 
		</div>
		<div>
			<h2>홈버튼</h2>
			<input type="button" value="홈버튼" class="button home-button" />
		</div>
		<div class="member-form">
			<h2 class="hidden">회원가입폼</h2>
			<form method="post">
				<ul>
					<li>
						<label>이메일</label>
						<input type="text" name="email" autocomplete=off />
						<input type="button" class="email-check-button" value="인증">
					</li>
					<li class="email-auth-li hidden">
						<label for="">이메일 인증</label>
						<input type="text" name="certify" autocomplete=off />
						<input type="button" class="email-auth-button" value="확인">
						<span class="auth-time"></span>
					</li>
					<li>
						<label>생년월일</label>
						<input type="date" name="birthday" />
					</li>
	 			</ul>      
	 			<div>
					<input type="submit" value="다음" />
				</div>
			</form>
		</div>
	</section>
</main>