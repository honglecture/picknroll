<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style>

#header{
	border-bottom: 1px solid #E7EAEC;
}  
  
#header-menu{ 
	display: flex;	  
	justify-content: space-between;
	padding: 20px;
}  

	#header-menu .logout{
		line-height: 30px;
	}
  
	#header-menu .logout > a{
		color: #999c9e;
		font-weight: bold;
	}
	
</style>
<header id="header">
	<nav id="header-menu">
		<h1>${mainTitle }</h1>
		<ul>
			<li class="logout"><a href="#">로그아웃</a></li>
		</ul>
	</nav>
</header>
