// 타이머
var timerID; // 타이머를 핸들링하기 위한 전역 변수
var time = 180; // 타이머 시작시의 시간

window.addEventListener("load", function(){

	// 멤버 섹션
	var memberSection = document.querySelector("#member-section");

	// 멤버 폼
	var memberForm = memberSection.querySelector(".member-form");
	
	// 이메일 검사 및 인증 메일 보내기
	var emailCheckButton = memberForm.querySelector(".email-check-button");
	var emailInput = memberForm.querySelector("input[name='email']");
	var emailAuthButton = memberForm.querySelector(".email-auth-button");
	
	// 이메일 인증
	var emailAuthLi = memberForm.querySelector(".email-auth-li");
	var certifyInput = memberForm.querySelector("input[name='certify']");
	
	// 생일
	var birthdayInput = memberForm.querySelector("input[name='birthday']");
	
	// 전송
	var submitButton = memberForm.querySelector("input[type='submit']");
	var form = memberForm.querySelector("form");
	
	var emailCheckStatus = false;
	
	emailCheckButton.onclick = function(){
		var email = emailInput.value;
		if(email=="") return;
		var params = {email : email};
		sendGetRequest("is-pwd-email-authentication-ajax", params, true, function(result){
			if(!result){
				alert("입력한 이메일이 없습니다."); 
				return;
			}
			alert("인증 메일을 보냈습니다.");
			emailAuthLi.classList.remove("hidden"); // 보이게 한다.
			startTimer();
		});		
	};
	
	emailAuthButton.onclick = function(){
		var certify = certifyInput.value;
		if(certify=="") return;
		var params = {certify : certify};
		sendPostRequest("is-pwd-email-authentication-ajax", params, true, function(result){
			if(!result){
				alert("인증 번호가 다릅니다."); return;
				emailCheckStatus = false;
			}
			alert("인증되었습니다.");
			emailCheckStatus = true; // 인증 상태 완료
			emailAuthLi.classList.add("hidden"); // 안보이게 한다.
			emailCheckButton.classList.add("hidden");
			emailInput.readOnly = true;
			// border 색깔이 바뀌어야 함 파란색으로
		});
	};
	
	
	submitButton.onclick = function(e){
		e.preventDefault();
		var email = emailInput.value;
		var birthday = birthdayInput.value;
		if(!emailCheckStatus){
			alert("이메일 인증해주세요");
			return;
		}
		var params = {email : email, birthday : birthday};
		sendPostRequest("find-id", params, true, function(result){
			if(!result){
				alert("생년월일이 다릅니다.");
				return;
			}
			alert("인증되었습니다.");
			location.href="pwd-reset";
		});
	};
});

function startTimer() {
	timerID = setInterval(decrementTime, 1000);
}

/* 남은 시간을 감소시키는 함수 */
function decrementTime() {
	var memberSection = document.querySelector("#member-section");
	var memberForm = memberSection.querySelector(".member-form");
	var authTime = memberForm.querySelector(".auth-time");
	authTime.innerHTML = toHourMinSec(time);
	if(time > 0) time--;
	else { 
		// 시간이 0이 되었으므로 타이머를 중지함
		clearInterval(timerID);
		// 시간이 만료되고 나서 할 작업을 여기에 작성
		/*document.form.submit();*/ // 예: 강제로 form 실행
	}
}

function toHourMinSec(t) { 
	var hour;
	var min;
	var sec;
	// 정수로부터 남은 시, 분, 초 단위 계산
	hour = Math.floor(t / 3600);
	min = Math.floor( (t-(hour*3600)) / 60 );
	sec = t - (hour*3600) - (min*60);
	// hh:mm:ss 형태를 유지하기 위해 한자리 수일 때 0 추가
	if(hour < 10) hour = "0" + hour;
	if(min < 10) min = "0" + min;
	if(sec < 10) sec = "0" + sec;
	return(min + ":" + sec);
}