<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript">
var timer;
var time = 200;
window.addEventListener("load", function(){
	startTimer();
});

function startTimer(){
	timer = setInterval(movementTimer, 2000);
}

function movementTimer(){
	var timerSpan = document.querySelector("#timer-span");
	timerSpan.innerHTML = time;
	time = time - 1;
}
</script>

</head>
<body>
	<span id="timer-span"></span>
</body>
</html>