<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script type="text/javascript" src="/resources/js/member/join-reg.js"></script>
<link href="/resources/css/member/style.css" type="text/css" rel="stylesheet">
<main id="main" class="main-container">

	<section id="main-title" class="main-title">
		<h1 class="hidden">이름</h1>
		<span>> 회원가입</span>
		<div class="page-explanation">
			<h2 class="hidden">부가설명</h2> 
			<p>환영합니다. PicknRoll입니다. 회원가입을 하기 위해선 아래 항목을 입력해주세요.</p> 
		</div>
	</section>
	<section id="member-section">
		<h1 class="hidden">회원가입 폼</h1>
		<div class="member-form">
			<h2 class="hidden">회원가입폼</h2>
			<form method="post">
				<ul>
					<li class="input-check-li">
						<label class="input-explanation">아이디 - 영문, 숫자 4~20자리</label>
						<span class="input-checker id-duplicate-button">중복체크</span>
						<div>
							<input type="text" class="text-input" name="id" placeholder="아이디를 입력해주세요."
							autocomplete=off />
							<span class="check-explanation id-check-explanation"></span>
						</div>
					</li>
					<li class="input-check-li">
						<label class="input-explanation">비밀번호 - 영문, 숫자 조합 6~20자리</label>
						<div>
							<input type="password" class="text-input"
							name="password" placeholder="비밀번호를 입력해주세요."
							autocomplete=off />
							<span class="check-explanation password-check-explanation"></span>
						</div>
					</li>
					<li class="input-check-li">
						<label class="input-explanation">비밀번호 확인</label>
						<div>
							<input type="password" class="text-input"
							name="password-check" placeholder="비밀번호를 입력해주세요."
							autocomplete=off />
							<span class="check-explanation password-check-explanation2"></span>
						</div>
					</li>
					<li class="input-check-li">
						<label class="input-explanation">닉네임 - 2~12자리</label>
						<span class="input-checker nickname-duplicate-button">중복체크</span>
						<div>
							<input type="text" class="text-input"
							name="nickname" placeholder="닉네임을 입력해주세요."
							autocomplete=off />
							<span class="check-explanation nickname-check-explanation"></span>
						</div>
					</li>
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
					<input class="button" type="submit" value="다음" />
				</div> 
			</form>
		</div>
	</section>
</main>