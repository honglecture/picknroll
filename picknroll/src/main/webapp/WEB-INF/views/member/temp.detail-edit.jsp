<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- <link rel="stylesheet" type="text/css" href="/resources/css/member/join-detail.css"> -->
<main id="main"> 
	<div class="main-container">
		<section id="top-menu">
			<input type="button" value="홈버튼" class="button home-button" />
		</section>
		  
		<section id="main-title"> 
			<h1>부가정보</h1> 
		</section>
		
		<section id="page-description">
			<h1 class="hide">부가설명</h1> 
			<p>서비스에 필요한 부가정보를 수정해주세요.</p> 
		</section>
		
		<section id="member-profile">
			<h1 class="hide">프로필사진</h1>
			<div>
				<img class="photo" src="/resources/users/${member.id }/${member.photo}" />				
			</div>
		</section>
		  
		<section id="member-container" class="content-container">
			<h1 class="hide">회원가입폼</h1>
			<form method="post" enctype="multipart/form-data"> 
				<ul>
					<li>
						<label class="list-label" for="">프로필사진</label>
						<input type="file" name="photo-file" hidden="true" value="파일선택" />
						<span class="photo-button">파일선택</span>
					</li>
					<li>
						<label class="list-label" for="">성별</label>
						<select name="gender" class="input-select">
						 	<c:if test="${member.gender eq  'm'}">
								<option value="m" selected="selected">남</option>
								<option value="f">여</option>						 	
						 	</c:if>
						 	<c:if test="${member.gender eq  'f'}">
								<option value="m">남</option>
								<option value="f" selected="selected">여</option>						 							 	
						 	</c:if>
						</select>
					</li>  
					<li>
						<label class="list-label" for="">생년월일</label>
						<input name="birthday" type="date" value="${member.birthday }" class="input-select">
					</li>
	 			</ul>    
				<input id="submit-button" class="button black-button bottom-button" type="submit" value="완료" />  
			</form>
		</section>
	</div>  
</main>
<script type="text/javascript">  
	window.addEventListener("load", function(){ 
		
		// 멤버 프로필 섹션
		var memberProfile = document.querySelector("#member-profile");
		var photo = memberProfile.querySelector(".photo");
		
		// 폼 섹션
		var memberContainer = document.querySelector("#member-container");

        //사진선택
        var photoButton = memberContainer.querySelector(".photo-button");
		var fileButton = memberContainer.querySelector("input[type='file']");

		// 전송 버튼
		var submitButton = memberContainer.querySelector("input[type='submit']");
		 
		// 상태값  

		fileButton.onchange = function(e){

			var file = fileButton.files[0];
			
			// 선택한 파일에 대한 조건 제어
			if(file.type.indexOf("image/") < 0){
				alert("이미지가 아닙니다.");
				return;
			}
			
			if(file.size > 1024*1024*10){
				alert("죄송합니다. 10MB를 초과할 수 없습니다.")
				return;
			}
			
			// 브라우저 메모리에 파일이 올라감
			// html5 기능 로컬 이미지 불러들이기
			var reader = new FileReader();
			reader.onload = function(evt){ 
				photo.src = evt.target.result; // 여기서 file 들어간다.
			};
			// 다 읽어 왔을 때.. background에서.. 
			reader.readAsDataURL(file);	

		};

		photoButton.onclick = function(e){
			var event = new MouseEvent("click",{
				"view" : window,
				"bubbles" : true,
				"cancelable" : true
			});
			fileButton.dispatchEvent(event);
		} 

	});
</script>