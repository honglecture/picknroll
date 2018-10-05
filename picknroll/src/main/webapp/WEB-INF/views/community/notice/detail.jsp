<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<main>

	<section id="title-section">
		<h1>공지사항</h1>
	</section>
	
	<section id="article-section">
		<h1>공지사항</h1>
		<div>
			<h2>${notice.title }</h2>
		</div>
		<div>
			<h2>공지사항 본문</h2>
			<div>
				<div>
					<div><img /></div>
					<div><span>${notice.writerId }</span></div>
					<div>
						<ul>
							<li><span>${notice.regDate }</span></li>
							<li><span>추천 : 7 | 조회수 : ${notice.hit }</span></li>
						</ul>
					</div>
				</div>
				<div>
					<p>본문이 여기 들어가야함</p>
				</div>
				<div>
					<div>
						<span></span>
						<img alt="따봉 아이콘"/>
					</div>
				</div>
				<div>
					<input type="button" value="삭제" />
					<input type="button" value="수정" />
					<input type="button" value="목록" />
				</div>
			</div>	
		</div>
	</section>
	
	<section id="reply-section">
		<h1>댓글리스트</h1>
		<div>
			<p>가슴이 설레는 말이다 청춘! 너의 두손을 가슴에 대고 물방아 같은 심장의 고동을 들어 보라 청춘의 피는 끓는다 끓는 피에 뛰노는 심장은 거선의 기관과 같이 힘있다 이것이다 인류의 역사를 꾸며 내려온 동력은 바로</p>
			<ul>
				<li>고슴도치가시 | 2018.08.13</li>
				<!-- 자기것만 삭제 가능해야 함 -->
				<li><input type="button" value="삭제" /></li>
			</ul>
		</div>
		<div>
			<textarea></textarea>
			<input type="button" value="등록" />
		</div>
	</section>
	
</main>

<script> 
var noticeParams = {
		p : blankToOne("${params.p}")
	   ,f : nullToValue("${params.f}", "title")
	   ,q : nullToValue("${params.q}", "")
	   ,w : nullToValue("${params.w}", "") 
	   ,s : nullToValue("${params.s}", "regDate")
	   ,i : blankToOne("${params.i}")
}

window.addEventListener("load", function(){
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

</script>