<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script src="/resources/js/member/find-id.js"></script>
<link href="/resources/css/member/style.css" type="text/css" rel="stylesheet">
<main id="main" class="main-container">
	<section id="main-title" class="main-title">
		<h1>> 계정찾기</h1>
		<div class="page-explanation">
			<h2 class="hidden">부가설명</h2> 
			<p>가입한 계정의 이메일과 생년월일을 입력해 주세요.</p>
		</div>
	</section>
	<section id="member-section">
		<h1 class="hidden">계정찾기</h1>
		<div class="member-form">
			<h2 class="hidden">계정찾기폼</h2>
			<form method="post">
				<li>
					<label class="input-explanation">생년월일</label>
					<div>
						<input class="text-input inline-left" name="birthday" type="date" value="${member.birthday }">
					</div>
				</li>
				<ul>
					<li class="input-check-li">
						<label class="input-explanation">이메일</label>
						<span class="input-checker email-duplicate-button">인증 메일 보내기</span>
						<div>
							<input type="text" class="text-input"
							name="email" placeholder="이메일을 입력해주세요."
							autocomplete=off />
							<span class="check-explanation email-check-explanation"></span>
						</div>
					</li> 
	 			</ul> 
				<div class="submit-button">
					<p class="message inline-center hidden">입력하신 정보의 계정이 없습니다.</p>
					<input class="button" type="submit" value="다음" />
				</div> 
			</form>
		</div>
	</section>
</main>