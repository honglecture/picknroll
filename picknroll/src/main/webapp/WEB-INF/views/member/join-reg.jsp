<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script type="text/javascript" src="/resources/js/member/join-reg.js"></script>
<style>
	.hidden{
		display: none;
	}
</style>
<main id="main">
	<section id="member-section">
		<h1 class="hidden">회원가입</h1>
		<div>
			<h2>회원가입</h2> 
		</div>
		<div>
			<h2 class="hidden">부가설명</h2> 
			<p>환영합니다. PicknRoll입니다. 회원가입을 하기 위해선 아래 항목을 입력해주세요.</p> 
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
						<label for="">아이디</label>
						<input type="text" name="id" autocomplete=off />
						<input type="button" class="id-duplicate-button" value="중복확인">
					</li>
					<li>
						<label for="">비밀번호</label>
						<input type="password" name="password" id="password"  autocomplete=off />
					</li>
					<li>
						<label class="list-label" for="">비밀번호확인</label>
						<input type="password" id="password-check"  autocomplete=off />
					</li>
					<li>
						<label for="">닉네임</label>
						<input type="text" name="nickname" autocomplete=off />
						<input type="button" class="nickname-duplicate-button" value="중복확인">
					</li>
					<li>
						<label for="">이메일</label>
						<input type="text" name="email" autocomplete=off />
						<input type="button" class="email-check-button" value="인증">
					</li>
					<li class="email-auth-li hidden">
						<label for="">이메일 인증</label>
						<input type="text" name="certify" autocomplete=off />
						<input type="button" class="email-auth-button" value="확인">
						<span class="auth-time"></span>
					</li>
	 			</ul>    
	 			<div>
					<input type="submit" value="다음" />
				</div>  
			</form>
		</div>
	</section>
</main>