<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link href="/resources/css/member/style.css" type="text/css" rel="stylesheet">
<script src="/resources/js/member/pwd-reset.js"></script>

<main id="main" class="main-container">
	<section id="main-title" class="main-title">
		<h1 class="hidden">이름</h1>
		<span>> 계정찾기</span>
		<div class="page-explanation">
			<h2 class="hidden">부가설명</h2> 
			<p>
				회원님의 아이디는 ${memberId }입니다.<br />
				비밀번호를 변경하시려면 비밀번호 변경 버튼을 눌러주세요.
			</p> 
		</div>
	</section>
	<section id="member-section">
		<h1 class="hidden">계정찾기</h1>
		<div class="member-form">
			<h2 class="hidden">계정찾기폼</h2>
			<div>
				<h2 class="hidden">리셋버튼</h2> 
				<input type="button" class="button pwd-reset-button" value="비밀번호 변경" />
				<a href="login"><input type="button" class="button login-button" value="로그인" /></a>
			</div>
			<form method="post" class="hidden">
				<ul>
					<li class="input-check-li">
						<label class="input-explanation">새비밀번호 - 영문, 숫자 조합 6~20자리</label>
						<div>
							<input type="password" class="text-input"
							name="password" placeholder="비밀번호를 입력해주세요."
							autocomplete=off />
							<span class="check-explanation password-check-explanation"></span>
						</div>
					</li>
					<li class="input-check-li">
						<label class="input-explanation">새비밀번호 확인</label>
						<div>
							<input type="password" class="text-input"
							name="password-check" placeholder="비밀번호를 입력해주세요."
							autocomplete=off />
							<span class="check-explanation password-check-explanation2"></span>
						</div>
					</li>
	 			</ul>    
				<div class="submit-button">
					<input class="button" type="submit" value="완료" />
				</div> 
			</form>
		</div>
	</section>
</main>