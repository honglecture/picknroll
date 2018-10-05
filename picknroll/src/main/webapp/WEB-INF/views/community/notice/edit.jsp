<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<c:set var="qs" value="f=${param.f }&q=${param.q }&w=${param.w }&s=${param.s }&p=${param.p }" />
<main>
	<section>
		<h1>공지사항 등록</h1>
	</section>
	<section id="article-form-section">
		<h1>공지사항 작성폼</h1>
		<form method="post">
			<input type="hidden" name="id" value="${notice.id}">
			<input type="hidden" name="w" value="${param.w}">
			<input type="hidden" name="s" value="${param.s}">
			<input type="hidden" name="p" value="${param.p}">
			<table>
				<tr>
					<th>제목</th>
					<td><input type="text" value="${notice.title}" name="title" id="title" ></td>
				</tr>
				<tr>
					<th>내용</th>
					<td><textarea name="content" id="content">${notice.content }</textarea></td>
				</tr>
			</table>
			<input type="submit" class="edit-button" value="글수정">
			<input type="button" class="cancel-button" value="취소">
		</form>
	</section>
</main>
<script>
window.addEventListener("load", function(){
	
	var articleFormSection = document.querySelector("#article-form-section");

	var title = articleFormSection.querySelector("input[name='title']");
	var content = articleFormSection.querySelector("input[name='content']");

	var writeButton = articleFormSection.querySelector(".edit-button");
	var cancelButton = articleFormSection.querySelector(".cancel-button");

	writeButton.onclick = function(e){
		if(title.value == "" || content.value == ""){
			alert("내용을 입력해주세요");
			e.preventDefault();
		}
	}

	cancelButton.onclick = function(){
		location.href = "list?${qs}";
	}
	
});
</script>