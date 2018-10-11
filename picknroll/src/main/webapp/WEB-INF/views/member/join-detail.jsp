<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script type="text/javascript" src="/resources/js/member/join-detail.js"></script>
<link href="/resources/css/member/style.css" type="text/css" rel="stylesheet">
<main id="main" class="main-container">
	<section id="main-title" class="main-title">
		<h1>> 부가정보</h1>
		<div class="page-explanation">
			<h2 class="hidden">부가설명</h2> 
			<p>회원가입을 축하드립니다. 서비스에 필요한 부가정보를 입력해주세요.</p> 
		</div>
	</section>
	<section id="member-section">
		<h1 class="hidden">회원가입 폼</h1>
		<div class="member-profile">
			<h2 class="hidden">프로필사진</h2> 
			<div class="inline-center">
				<img class="photo" src="/resources/images/default_profile.png" />				
			</div>
		</div> 
		<div class="member-form">
			<h2 class="hidden">회원가입폼</h2>
			<form method="post" enctype="multipart/form-data">
				<ul>
					<li>
						<label class="input-explanation">프로필사진</label>
						<div>
							<input type="file" id="file-button" name="photo-file" hidden="true" value="파일선택" />
							<input class="button photo-button" type="button" value="파일선택" />
						</div>
					</li>
					<li>
						<label class="input-explanation">성별</label>
						<div>
							<select class="text-input" name="gender">  
								<option value="">선택</option> 
								<option value="m">남</option>
								<option value="f">여</option>
							</select>
						</div>
					</li>
					<li>
						<label class="input-explanation">생년월일</label>
						<div>
							<input class="text-input inline-left" name="birthday" type="date" value="">
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
