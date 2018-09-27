// 타이머
var timerID; // 타이머를 핸들링하기 위한 전역 변수
var time = 180; // 타이머 시작시의 시간

window.addEventListener("load", function(){

	// 멤버 섹션
	var memberSection = document.querySelector("#member-section");

	// 멤버 폼
	var memberForm = memberSection.querySelector(".member-form");

	// id 중복 검사
	var idDuplicateButton = memberForm.querySelector(".id-duplicate-button");
	var idInput = memberForm.querySelector("input[name='id']");

	// 닉네임 중복 검사
	var nicknameDuplicateButton = memberForm.querySelector(".nickname-duplicate-button");
	var nicknameInput = memberForm.querySelector("input[name='nickname']");

	// 이메일 검사 및 인증 메일 보내기
	var emailCheckButton = memberForm.querySelector(".email-check-button");
	var emailInput = memberForm.querySelector("input[name='email']");
	var emailAuthButton = memberForm.querySelector(".email-auth-button");
	
	// 이메일 인증
	var emailAuthLi = memberForm.querySelector(".email-auth-li");
	var certifyInput = memberForm.querySelector("input[name='certify']");
	
	// 전송
	var submitButton = memberForm.querySelector("input[type='submit']");
	var form = memberForm.querySelector("form");
	
	// 상태값
	var idCheckStatus = false;
	var nicknameCheckStatus = false;
	var emailCheckStatus = false;

	idDuplicateButton.onclick = function(){
		var id = idInput.value;
		if(id=="") return;
		var params = {id : id};
		sendGetRequest("is-id-duplicated-ajax", params, true, function(result){
			if(result){
				alert("아이디가 중복되었습니다.");
				idCheckStatus = false;
				return;
			}   
			alert("사용하셔도 좋습니다");
			idCheckStatus = true;

			// border 색깔이 바뀌어야 함 파란색으로
			
		});		
	};

	nicknameDuplicateButton.onclick = function(){
		var nickname = nicknameInput.value;
		if(nickname=="") return;
		var params = {nickname : nickname};
		sendGetRequest("is-nickname-duplicated-ajax", params, true, function(result){
			if(result){
				alert("닉네임이 중복되었습니다.");
				nicknameCheckStatus = false;
				return;
			} 
			alert("사용하셔도 좋습니다");
			nicknameCheckStatus = true;
			// border 색깔이 바뀌어야 함 파란색으로
		});		
	};

	emailCheckButton.onclick = function(){
		var email = emailInput.value;
		if(email=="") return;
		var params = {email : email};
		
		sendGetRequest("is-email-authentication-ajax", params, true, function(result){
			if(result){
				alert("이메일 중복"); 
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
		sendPostRequest("is-email-authentication-ajax", params, true, function(result){
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
/*		var idCheckStatus = false;
		var nicknameCheckStatus = false;
		var emailCheckStatus = false;*/
		e.preventDefault();
		
		if(!idCheckStatus){
			alert("아이디 중복검사 해주세요.");
			return;
		}
		
		if(!nicknameCheckStatus){
			alert("닉네임 중복검사 해주세요.");
			return;
		}
		
		if(!emailCheckStatus){
			alert("이메일 인증해주세요");
			return;
		}
		
		form.submit();
		
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