<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style>
#nav{
	background : #2f4050;
	color: white;
	font-weight:bold;
	min-width: 250px;
}

#side-menu{
	box-sizing: border-box;
	position: fixed;
	top: 0px;
	left: 0px;
	width: 250px;
}

	#side-menu ul{
    	color: #676a6c;
	}
	
	#side-menu ul > li{
	}
	
	#side-menu .profile{
		background: #293848;
		padding-left :22px;
		padding-top : 22px;
		height : 150px;
	}
	
	#side-menu .profile div{
		background : white;
   		width: 100px; height: 100px;
   	 	object-fit: cover;
    	border-radius: 50%;
	}
	
	#side-menu .profile h1{
		color: white;
		font-size: 13px;
		margin-top: 5px;
	}
	
	
	#side-menu > ul > li > a{
		font-size: 13px;
		display: block;
		color: #a7b1c2;
    	font-weight: 600;
    	padding: 14px 20px 14px 25px;
	}
	
	#side-menu > ul > li > a:hover{
		background: #293848;
	}
</style>
<nav id="nav">
	<h1 class="hide">내비게이션</h1>
	<section id="side-menu">  
		<h1 class="hide">관리목록</h1>
		<ul>
			<li class="profile">
				<div></div>
				<h1>관리자 | flwj@naver.com</h1>
			</li>
			<li><a href="#">회원관리</a></li>
			<li><a href="#">서비스관리</a></li>
			<li><a href="#">앞으로 추가</a></li>
		</ul>
	</section>
</nav>
<script>
</script>