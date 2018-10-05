<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<main>
	<section>
		<h1>공지사항 등록</h1>
	</section>
	
	<section id="article-form-section">
		<h1>공지사항 작성폼</h1>
		<form method="post">
			<table>
				<tr>
					<th>제목</th>
					<td><input type="text" name="title" id="title" ></td>
				</tr>
				<tr>
					<th>내용</th>
					<td><textarea name="content" id="content"></textarea></td>
				</tr>
			</table>
			<input type="submit" class="write-button" value="글쓰기">
			<input type="button" class="cancel-button" value="취소">
		</form>
	</section>
</main>
<script>

var noticeParams = {
		p : blankToOne("${params.p}")
	   ,f : nullToValue("${params.f}", "title")
	   ,q : nullToValue("${params.q}", "")
	   ,w : nullToValue("${params.w}", "") 
	   ,s : nullToValue("${params.s}", "regDate")
}

window.addEventListener("load", function(){

	var articleFormSection = document.querySelector("#article-form-section");

	var title = articleFormSection.querySelector("input[name='title']");
	var content = articleFormSection.querySelector("input[name='content']");

	var writeButton = articleFormSection.querySelector(".write-button");
	var cancelButton = articleFormSection.querySelector(".cancel-button");

	writeButton.onclick = function(e){
		if(title.value == "" || content.value == ""){
			alert("내용을 입력해주세요");
			e.preventDefault();
		}
	}

	cancelButton.onclick = function(){
		var qs = createQuerystring(noticeParams);
		location.href = "list?"+qs;
	}
	
});
</script>