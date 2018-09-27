<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script type="text/javascript" src="/resources/js/member/join-detail.js"></script>
<main id="main"> 
	<section id="member-section">
		<h1 class="hidden">부가정보</h1>
		<div>
			<h2>부가정보</h2> 
		</div>
		<div>
			<h2 class="hidden">부가설명</h2> 
			<p>회원가입을 축하드립니다. 서비스에 필요한 부가정보를 입력해주세요.</p> 
		</div>
		
		<div>
			<h2>홈버튼</h2>
			<input type="button" value="홈버튼" class="button home-button" />
		</div>
		
		<div class="member-profile">
			<h2 class="hide">프로필사진</h2>
			<div>
				<img class="photo" src="/resources/images/anonymous.jpg" />				
			</div>
		</div>
		
		<div class="member-form">
			<h2 class="hidden">회원가입폼</h2>
			<form method="post" enctype="multipart/form-data">  
				<ul>
					<li>
						<label>프로필사진</label>
						<input type="file" id="file-button" name="photo-file" hidden="true" value="파일선택" />
						<span class="photo-button">파일선택</span>
					</li>
					<li>
						<label>성별</label>
						<select name="gender"> 
							<option value="m">남</option>
							<option value="f">여</option>
						</select>
					</li>  
					<li>
						<label>생년월일</label>
						<input name="birthday" type="date" value="">
					</li>
	 			</ul>    
	 			<div>
					<input type="submit" value="완료" />
				</div>  
			</form>
		</div>
	</section>
</main>