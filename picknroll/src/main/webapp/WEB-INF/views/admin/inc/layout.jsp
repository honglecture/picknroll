<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>PicknRoll 관리자</title>
<style>
body{
	margin: 0px;
	padding: 0px;
}

ul{
	margin: 0px;
	padding: 0px;
}

h1{
	margin: 0px;
	padding: 0px;
}

a{
	text-decoration: none;
}

li{
	list-style-type: none;
}

body{
	background : #2f4050;
}

.hide{ 
	display: none;
}

#wrapper{
	display: flex;
}

#main{
	background: #f3f3f4;
	flex-grow: 1;
	/* height: 100vh; */ 
	box-sizing: border-box;
	
}

#main-wrapper{    
	margin : 20px; 
	min-width : 800px; 
}  
</style>
<script type="text/javascript">
var resizeMain = function(){
    var main = document.querySelector("#main");  
    var windowHeight = window.innerHeight;
    main.style["min-height"] = windowHeight + "px";
};       
window.addEventListener("resize", resizeMain); 
window.addEventListener("load", resizeMain);
</script> 
</head>
<body>
	<div id="wrapper">
		<tiles:insertAttribute name="nav" />
		<main id="main">
			<tiles:insertAttribute name="header" />
			<div id="main-wrapper">
				<tiles:insertAttribute name="main" />
			</div>
		</main>
	</div> 
</body>
</html>