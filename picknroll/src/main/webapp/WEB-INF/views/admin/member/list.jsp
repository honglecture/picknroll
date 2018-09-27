<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<style>
.main-section {
	border-top: 2px solid #e7eaec;
	box-sizing: border-box;
	background: #ffffff;
	margin-bottom: 30px;
	width: 90%;
}

.main-section > h1 {
	color: #686b6d;
	font-size: 16px;
	font-weight: bold;
	padding: 10px;
	border-bottom: 1px solid #e7eaec;
}

#search-form form {
	box-sizing: border-box;
	height: 70px;
	padding: 20px;
	font-weight: 700;
	color: #686b6d;
	font-size: 14px;
	display: flex;
	justify-content: space-between;
}

#search-form form input {
	height: 20px;
	width: 150px;
}

#search-form form select {
	height: 25px;
	width: 80px;
	color: #686b6d;
}

#search-form #search-date {
	margin-left: 20px;
}

#search-form #search-btn {
	background: pink;
	height: 25px;
	width: 25px;
	margin-left: 20px;
}

   /*---.table--------------------------------*/
   
   #member-table{
   		box-sizing: border-box; 
   		padding: 5px;
   }
    
     .table { 
        margin-top : 10px; 
    	font-weight: lighter;  
		width: 100%;
		height : 100%;
		table-layout: fixed;
		border-spacing: 0px;
	 }
  
      .table tr { 
		height: 30px;
		/* tr은 border가 적용이 안된다. */
	 }
 
	 .table thead{
	 	background: #404040;
	 	color: #ffffff;
	 	font-size: 13px;    
	 	font-weight: bold;
	 }
 
	 .table td { 
	  	border-bottom: 1px solid #e9e9e9;
	 	padding : 0px;
	 	text-align: center; 
	 }
	 
	 .table tbody td { 
		color: #333333; 
		font-size: 12px;
	 }
	 
	 .table .col-sm {
	 	width: 60px;
	 }
	 
	 .table .col-md {
	 	width: 100px;
	 }

	 .table .col-md {
	 	width: 100px;
	 }
	 
	 .table .col-ex {
	 	width: calc(100% - 320px);
	 }
	 		 
	 .table tbody td.col-title a {
	 	text-decoration: none; 
	 	color: #808080;
	 }
	 
/*--pagination------------------*/

#pagination-wrapper{ 
	text-align: center;
} 

.pagination { 
    display: inline-block;
    margin-top : 10px;
}
  
.pagination a {
    color: black;
    float: left;
    padding: 8px 16px;
    text-decoration: none;
    transition: background-color .3s;
}

.pagination a.active {
    background-color: #18a689;
    color: white;
}

.pagination a:hover:not(.active) {background-color: #ddd;}

</style>
<section id="search-form" class="main-section">
	<h1>검색</h1>
	<form>
		<section id="search-keyword">
			<span>키워드 : </span> <select>
				<option>아이디</option>
				<option>닉네임</option>
				<option>이메일</option>
			</select> <input type="text" placeholder="검색어를 입력해주세요" />
		</section>
		<section id="search-date">
			<span>가입기간 : </span> <input type="text" placeholder="날짜 입력" /> ~ <input
				type="text" placeholder="날짜 입력" />
		</section>
		<section id="search-btn"></section>
	</form>
</section>

<section id="member-table" class="main-section">
	<h1>목록</h1>
	<table class="table">
		<thead>
			<tr>
				<td class="col-sm">번호</td>
				<td class="col-sm">사진</td>
				<td class="col-md">아이디</td>
				<td class="col-ex">닉네임</td>
				<td class="col-ex">이메일</td>
				<td class="col-sm">성별</td>
				<td class="col-md">가입일</td>
				<td class="col-sm">상태</td>
				<td class="col-sm">제재</td>
			</tr>
		</thead>
		<tbody>
			<%for(int i=0; i<10; i++){ %>
			<tr>
				<td class="col-sm">1</td>
				<td class="col-sm">사진</td>
				<td class="col-md">flwjflwj</td>
				<td class="col-ex">고슴도치가시</td>
				<td class="col-ex">flwj@naver.com</td>
				<td class="col-sm">남</td>
				<td class="col-md">2018.08.20</td>
				<td class="col-sm">정상</td>
				<td class="col-sm"><input type="button" value="제재"></td>
			</tr>
			<%} %>
		</tbody>
	</table>
	<div id="pagination-wrapper">
		<section class="pagination">
			<a href="#">&laquo;</a>
			<a href="#">1</a>
			<a href="#" class="active">2</a>
			<a href="#">3</a>
			<a href="#">4</a>
			<a href="#">5</a>
			<a href="#">6</a>
			<a href="#">&raquo;</a>
		</section>
	</div>
</section>