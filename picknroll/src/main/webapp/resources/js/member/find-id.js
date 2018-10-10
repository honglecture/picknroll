// 타이머
let timerID; // 타이머를 핸들링하기 위한 전역 변수
let time = 180; // 타이머 시작시의 시간

let emailPatteren =  /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
let emailPatternFlag = false;
let emailDuplicateFlag = false;
let certifyCheckFlag = false;

function emailPatternCheck(email){
	if(!emailPatteren.test(email)){
		emailPatternFlag = false;
		emailDuplicateFlag = false;
		return false;
	} else{
		emailPatternFlag = true;
		emailDuplicateFlag = false;
		return true;
	} 
}

window.addEventListener("load", function(){

	// 멤버 섹션
	let memberSection = document.querySelector("#member-section");

	// 멤버 폼
	let memberForm = memberSection.querySelector(".member-form");
	let memberFormUl = memberSection.querySelector(".member-form ul");

	// email 검사
	let emailInput = memberForm.querySelector("input[name='email']");
	let emailCheckExplanation = memberForm.querySelector(".email-check-explanation");
	let emailDuplicateButton = memberForm.querySelector(".email-duplicate-button");

	// birthday
	let birthdayInput = memberForm.querySelector("input[name='birthday']");
	
	// message
	let message = memberForm.querySelector(".message");


	// submit 버튼
	let submitButton = memberForm.querySelector("input[type='submit']");

	emailInput.addEventListener("keyup", (e)=>{
		let email = emailInput.value;
		emailInput.classList.remove("input-success");
		if(!emailPatternCheck(email)){
			emailCheckExplanation.textContent = "형식에 맞지 않음";
			return;
		}
		emailCheckExplanation.textContent = "";
	});


	emailDuplicateButton.onclick = (e)=>{
		let email = emailInput.value;

		if(!emailPatternCheck(email)){
			emailCheckExplanation.textContent = "형식에 맞지 않음";
			emailInput.classList.remove("input-success");
			return;
		}
		emailInput.classList.remove("input-success");

		var params = {email : email};
		emailCheckExplanation.textContent = "잠시만요";
		 
 		sendGetRequest("is-pwd-email-authentication-ajax", params, true, function(result){
 		 	if(!result){
		 		emailCheckExplanation.textContent = "해당 이메일 없음";
		 		emailDuplicateFlag = false;
		 		emailInput.classList.remove("input-success");
	 	   		return;
			}
 		 	
			emailCheckExplanation.textContent = "";
			emailDuplicateFlag = true;
			emailInput.readOnly = true;
			certifyCheckFlag = false;

			let liName = memberFormUl.lastElementChild.name;
			if(liName == "certify-li"){
				timerID = null;
				time = 180; // 타이머 시작시의 시간
				memberFormUl.lastElementChild.remove();
			}

			 //동적으로  생성해야 함
			 let li = document.createElement("li");
			 li.classList.add("input-check-li");
			 li.name = "certify-li";
			 let label = document.createElement("label");
			 label.classList.add("input-explanation");

			 let buttonSpan = document.createElement("span");
			 buttonSpan.textContent = "인증";
			 buttonSpan.classList.add("input-checker");
			 buttonSpan.classList.add("certify-check-button");

			 let div = document.createElement("div");
			 
			 let certifyInput = document.createElement("input");
			 certifyInput.type = "text";
			 certifyInput.classList.add("text-input");
			 certifyInput.name = "certify";
			 certifyInput.placeholder = "인증번호를 입력해주세요.";
			 certifyInput.autocomplete = "off";
			 let checkSpan = document.createElement("span");
			 checkSpan.classList.add("check-explanation");
			 checkSpan.classList.add("certify-check-explanation");

			 div.appendChild(certifyInput);
			 div.appendChild(checkSpan);

			 li.appendChild(label);
			 li.appendChild(buttonSpan);
			 li.appendChild(div);

			 memberFormUl.appendChild(li);
			 startTimer(label);


			 buttonSpan.onclick = ()=>{
				var certify = certifyInput.value;
					if(certify.trim()=="") return;		 
			 		var params = {certify : certify};
			 		sendPostRequest("is-pwd-email-authentication-ajax", params, true, function(result){
			 			if(!result){
							checkSpan.textContent = "인증 번호 다름";
							certifyCheckFlag = false;
							return;
		 				}			 			
						certifyCheckFlag = true;
						clearInterval(timerID);
						timerID = null;
						time = 180; // 타이머 시작시의 시간
						memberFormUl.lastElementChild.remove();
						emailCheckExplanation.textContent = "OK";
						emailInput.classList.add("input-success");
			 	});
			 };
 		 });
	};

	submitButton.onclick = function(e){
		e.preventDefault();
		var birthday = birthdayInput.value;
		var email = emailInput.value;
		if(birthday=="" || !emailPatternFlag || !emailDuplicateFlag || !certifyCheckFlag){
			return;
		}
		
		// 생년월일과 이메일을 보내고 true가 나오면 페이지를 이동한다.
 		var params = {birthday : birthday, email : email};
		 sendPostRequest("find-id", params, true, function(result){
		 	if(!result){
		 		// 정보가 맞지 않음
		 		message.classList.remove("hidden");
		 		return;
		 	} 
		 	location.href = "pwd-reset";
		 });	
	};

});

function startTimer(element) {
	// 멤버 섹션
	let memberSection = document.querySelector("#member-section");
	// 멤버 폼
	let memberFormUl = memberSection.querySelector(".member-form ul");
	timerID = setInterval(()=>{
		let label = element;
		let str = "이메일 인증 - "; 
		label.textContent = str + toHourMinSec(time);
		if(time > 0) {
			time--;
		} else { 
			// 시간이 0이 되었으므로 타이머를 중지함
			clearInterval(timerID);
			certifyCheckFlag = false;
			timerID = null;
			time = 180; // 타이머 시작시의 시간
			memberFormUl.lastElementChild.remove();
			// 시간이 만료되고 나서 할 작업을 여기에 작성
			/*document.form.submit();*/ // 예: 강제로 form 실행
		}
	}, 1000);
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