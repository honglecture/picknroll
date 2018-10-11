<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link href="/resources/css/member/style.css" type="text/css" rel="stylesheet">
<script src="/resources/js/member/pwd-edit.js"></script>
<main id="main" class="main-container">
	<section id="main-title" class="main-title">
		<h1>> 비밀번호 변경</h1>
		<div class="page-explanation">
			<h2 class="hidden">부가설명</h2> 
			<p>비밀번호는 주기적으로 변경해주세요.</p> 
		</div>
	</section>
	<section id="member-section">
		<h1 class="hidden">비밀번호변경</h1>
		<div class="member-form">
			<h2 class="hidden">비밀번호변경폼</h2>
			<form method="post">
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