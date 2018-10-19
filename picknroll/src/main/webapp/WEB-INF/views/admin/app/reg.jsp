<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript">
	window.addEventListener("load",()=>{
		
		let appForm = document.querySelector("#app-form");

		//사진선택
		let photoButton = appForm.querySelector(".photo-button");
		let fileButton = appForm.querySelector("input[type='file']");
		let photo = appForm.querySelector(".photo");

		fileButton.onchange = function(e){

			let file = fileButton.files[0];

			// 선택한 파일에 대한 조건 제어

			console.log(file.type); //image/jpeg

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
			let reader = new FileReader();
			reader.onload = function(evt){ 
				photo.src = evt.target.result; // 여기서 file 들어간다.
			};
			// 다 읽어 왔을 때.. background에서.. 
			reader.readAsDataURL(file);	
			console.log(file);

			};

			photoButton.onclick = function(e){
			let event = new MouseEvent("click",{
				"view" : window,
				"bubbles" : true,
				"cancelable" : true
			});
			fileButton.dispatchEvent(event);
		}

	});
</script>
<main>
	<section>
		<h1><a href="list">앱관리 - 등록</a></h1>
	</section>
	<section id="app-form">
		<form method="post" enctype="multipart/form-data">
			<table>
				<tr>
					<th>제목</th>
					<td><input type="text" name="title" class="input-text"></td>
				</tr>
				<tr>
					<th>URL</th>
					<td><input type="text" name="url" class="input-text"></td>
				</tr>
				<tr>
					<th>이미지</th>
					<td>
						<img class="photo" src="" />
					</td>
				</tr>
				<tr>
					<th>아이콘</th>
					<td>
					
						<input type="file" id="file-button" name="photo-file" hidden="true" value="파일선택" />
						<input class="button photo-button" type="button" value="파일선택" />
					</td>
				</tr>
				<tr>
					<th>카테고리</th>
					<td>
						<select name="appCategoryId">
							<c:forEach items="${appCategoryList }" var="appCategory">
								<option value="${appCategory.id }">${appCategory.name }</option>
							</c:forEach>								
						</select>
					</td>
				</tr>
				<tr>
					<th>상태</th>
					<td>
						<ul>
							<li><input type="radio" name="status" value="1" >정상</li>
							<li><input type="radio" name="status" value="0" >중지</li>
						</ul>
					</td>
				</tr>
				<tr>
					<th>로그인</th>
					<td>
						<ul>
							<li><input type="radio" name="isLogin" value="1" > 네</li>
							<li><input type="radio" name="isLogin" value="0" > 아니오</li>
						</ul>
					</td>
				</tr>
				<tr>
					<th>링크</th>
					<td>
						<ul>
							<li><input type="radio" name="target" value="_blank">새창</li>
							<li><input type="radio" name="target" value="_self">현재창</li>
						</ul>
					</td>
				</tr>
				<tr>
					<th>설명</th>
					<td>
						<textarea name="description"></textarea>
					</td>  
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="등록">
						<a href="list"><input type="button" value="취소"></a>
					</td>
				</tr>
			</table>
		</form>
	</section>
</main>