<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<script type="text/javascript">
	window.addEventListener("load", ()=>{
		
		let appSection = document.querySelector("#app-section");
		let deleteForm = appSection.querySelector(".delete-form");
		let deleteInput = deleteForm.querySelector("input[type='hidden']");
		
		
		appSection.onclick = (e)=>{
			
			let target = e.target;
			
			if(target.type != "button")
				return;
			 
			if(target.classList.contains("edit-button")){
				// 수정
				let appId = target.parentElement.dataset["id"];
				location.href="edit/"+appId; 
			}
			 
			if(target.classList.contains("delete-button")){
				// 삭제
				let appId = target.parentElement.dataset["id"];
				
				// 폼전송
				deleteInput.value = appId;
				deleteForm.submit();
			}
			
		}
	});
</script>
<main>
	<section>
		<h1><a href="list">앱관리 - 목록</a></h1>
	</section>
	<section id="app-section">
		<div><a href="reg"><input type="button" value="등록" /></a></div>
		<table border="1">
			<thead>
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>url</th>
					<th>상태</th>
					<th>로그인</th>
					<th>카테고리</th>
					<th>등록일</th>
					<th>수정/삭제</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${appList }" var="app">
				<tr>
					<td>${app.id }</td>
					<td>${app.title }</td>
					<td>${app.url }</td>
					<td>${app.status }</td>
					<td>${app.isLogin }</td>
					<td>${app.categoryName }</td>
					<td>${app.regDate }</td>
					<td data-id="${app.id }"> 
						<input type="button" class="edit-button" value="수정">
						<input type="button" class="delete-button" value="삭제">
					</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
		<form class="delete-form" method="post" action="delete">
			<input type="hidden" name="id" />
		</form>	
	</section>
	
</main>