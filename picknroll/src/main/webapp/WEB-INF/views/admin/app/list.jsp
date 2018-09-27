<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style>

.black-button{
	background: #5c5c5c;
	color: #ffffff;
	border-radius: 4px;
	border: none;
	cursor: pointer;
}

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

#button-menu{
	margin-top : 10px;
	text-align: right;
}

#button-menu input{
	width: 50px; 
}

/*---.table--------------------------------*/
   
   #service-table{
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
	 	text-align: center;
	 }
	 
	 .table .col-icon{
	 	display : inline-block;
	 	background: gray;
	 	width : 100px;
	 	height :50px;
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
<section id="service-table" class="main-section">
	<h1>목록</h1>
	<section id="button-menu">
		<input type="button" class="black-button" value="등록">
		<input type="button" class="black-button" value="삭제">
	</section> 
	<table class="table">
		<thead>
			<tr>
				<td class="col-sm">번호</td>
				<td class="col-ex">아이콘</td>
				<td class="col-ex">이름</td>
				<td class="col-md">URL</td>
				<td class="col-md">등록일</td>
				<td class="col-sm">상태</td>
				<td class="col-sm">선택</td>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td class="col-sm">1</td>
				<td class="col-ex"><div class="col-icon"></div></td>
				<td class="col-md">이름</td>
				<td class="col-md">URL</td>
				<td class="col-md">등록일</td>
				<td class="col-sm">정상</td>
				<td class="col-sm"><input type="checkbox"></td>
			</tr>
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
			<a href="#">&raquo;</a>
		</section>
	</div>
</section>
