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

.input-text{
	padding: 6px 12px;
    background: #ffffff;
    border: 1px solid #ccc;
    border-radius: 4px;
    box-shadow: inset 0 1px 1px rgba(0,0,0,.075);
    box-sizing: border-box;
    resize: none;
    font-size: 14px;
}

.textarea{
	height : 200px;
}

/*------------------------------------------------*/

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


/*---.table--------------------------------*/
   
#service-form{
	box-sizing: border-box; 
	padding: 10px;
}
    
   #service-form > table { 
		width: 100%;
		height : 100%;
		table-layout: fixed;
		border-spacing: 0px;
	}   
	  
	#service-form > table th {    
		width: 15%;      
		height : 60px;     
		text-align: right; 
		font-size: 14px;      
		color: #4e4e4e;    
	}   
	   
   	#service-form > table td {  
   		width: 85%;        
   		padding-left: 50px;  
   		text-align: left;
	}
	 
	#service-form .row-radio ul{
		display: flex;      
	} 
	
	#service-form .row-radio ul li{   
		width: 100px; 
		text-align: left; 
	}
	   
	#service-form .row-button td{    
		text-align: center;  
		margin : 30px 0px; 
		padding-left: 1px;  
	}
	  
	#service-form .row-button input{   
   		width: 100px; 
   		height: 30px;    
   		margin : 30px;   
	} 
	 
	#service-form .input-text{ 
		width: 70%;
	}
	

	
	 

</style>

<section id="service-reg" class="main-section">
	<h1>수정</h1>
	<form id="service-form">
		<table>
			<tr> 
				<th>제목</th>
				<td><input type="text" id="title" class="input-text"></td>
			</tr>
			<tr>
				<th>URL</th>
				<td><input type="text" id="url" class="input-text"></td>
			</tr>
			<tr>
				<th>아이콘</th>
				<td></td>
			</tr>
			<tr class="row-radio">
				<th>상태</th>
				<td>
					<ul>
						<li><input type="radio" name="state" > 정상</li>
						<li><input type="radio" name="state" > 중지</li>
					</ul>
				</td>
			</tr>
			<tr class="row-radio">
				<th>로그인</th>
				<td>
					<ul>
						<li><input type="radio" name="login" > 네</li>
						<li><input type="radio" name="login" > 아니오</li>
					</ul>
				</td>
			</tr>
			<tr class="row-radio">
				<th>링크</th>
				<td>
					<ul>
						<li><input type="radio" name="target"> 새창</li>
						<li><input type="radio" name="target"> 현재창</li>
					</ul>
					
					
				</td>
			</tr>
			<tr>
				<th>설명</th>
				<td>
					<textarea id="description" class="input-text textarea"></textarea>
				</td>  
			</tr> 
			<tr class="row-button">
				<td colspan="2">
					<input type="button" id="reg-button" class="black-button" value="확인">
					<input type="button" id="cancel-button" class="black-button" value="취소">
				</td>
			</tr>
		</table>
	</form>
</section>
