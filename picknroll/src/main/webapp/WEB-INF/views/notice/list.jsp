<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<main>

	<section id="title-section">
		<h1>공지사항</h1>
	</section>
	
	<section id="search-section">
		<h1 class="hidden">글검색</h1>
		<form method="get">
			<select name="f">
				<option value="title">제목</option>
				<option value="content">내용</option>
				<option value="writerId">작성자</option>
			</select>
			<input name="q" type="text" />
			<input type="submit" value="검색" />
		</form>
	</section>
	
	<section id="article-section">
		<h1 class="hidden">글목록</h1>
		<ul>
			<li>
				<article>
					<h1 class="title"><a href="84">프로그래밍 무엇부터 시작해야 하나요?</a></h1>
					<div class="">
						<ul>
							<li>번호 : 1</li>
							<li>이름 : 관리자</li>
							<li>좋아요 : 30</li>
							<li>날짜 : 2018.08.13</li>
						</ul>
					</div>
				</article>
			</li>
		</ul>
		
<%-- 		<h1 class="hide">글목록</h1>
		<table class="table">
			<thead>
				<tr>
					<td>번호</td>
					<td>제목</td>
					<td>글쓴이</td>
					<td>조회수</td>
					<td>작성일</td>
				</tr>
			</thead>
			<tbody>
			</tbody>
		</table>
		<!-- ROLE_ 를 쓰지 않는다. -->
		<security:authorize access="hasRole('ADMIN')">  
			<div>

			</div>
		</security:authorize>
		<div>1 2 3 4 5</div> --%>
	</section>
</main>

<script> 
<input type="button" value="글쓰기" class="btn-reg">
var noticeParams = {
		p : blankToOne("${params.p}")
	   ,f : nullToValue("${params.f}", "title")
	   ,q : nullToValue("${params.q}", "")
	   ,w : nullToValue("${params.w}", "") 
	   ,s : nullToValue("${params.s}", "regDate")
}

window.addEventListener("load", function(){
	createTable();
 	var searchSection = document.querySelector("#search-section");
	var searchButton = searchSection.querySelector("input[type='submit']");
	var f = searchSection.querySelector("select[name='f']");
	var q = searchSection.querySelector("input[name='q']");
	
	var articleSection = document.querySelector("#article-section");
	var btnReg = articleSection.querySelector(".btn-reg");
	
	if(btnReg!=null){
		btnReg.onclick = function(e){
			var qs = createQuerystring(noticeParams);
			location.href = "reg?"+qs;
		}
	}
	
	searchButton.onclick = function(e){
		e.preventDefault();
		noticeParams.f = f.value;
		noticeParams.q = q.value;
		createTable();
	};
	
	
});

function createTable(){
	var articleSection = document.querySelector("#article-section");
	var editBox = articleSection.querySelector(".edit-box");
	var tbody = articleSection.querySelector(".table tbody");
	sendPostRequest("list-ajax", noticeParams, true, function(result){
		var list = result.list;
		var noticeList = "";
		for(var i=0; i<list.length; i++){  
			var qs = createQuerystring(noticeParams) + "&id=" + list[i].id;
			noticeList += '<tr>'; 
			noticeList += '<td>'+list[i].id+'</td>';
 			noticeList += '<td><a href=detail?'+qs+'>'+list[i].title+'</a></td>';
			noticeList += '<td>'+list[i].writerId+'</td>';
			noticeList += '<td>'+list[i].hit+'</td>';
			noticeList += '<td>'+list[i].regDate+'</td>';
			noticeList += '</tr>';
		}
		tbody.innerHTML = noticeList;
	});
}

</script>