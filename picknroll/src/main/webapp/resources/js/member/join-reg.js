// 타이머
let timerID; // 타이머를 핸들링하기 위한 전역 변수
let time = 180; // 타이머 시작시의 시간

let idPattern = /^[A-Za-z0-9]{4,20}$/;
let pwdPattern = /^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\W\d]{8,20}$/;
				

let nicknamePattern = /^[\w\Wㄱ-ㅎㅏ-ㅣ가-힣]{2,12}$/;
let emailPatteren =  /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;

let idPatternFlag = false;
let idDuplicateFlag = false;
 
let pwdPatternFlag = false;
let pwdCheckFlag = false;

let nicknamePatternFlag = false;
let nicknameDuplicateFlag = false;

let emailPatternFlag = false;
let emailDuplicateFlag = false;

let certifyCheckFlag = false;

function idPatternCheck(id){
	if(!idPattern.test(id)){
		idPatternFlag = false;
		idDuplicateFlag = false;
		return false;
	} else{
		idPatternFlag = true;
		idDuplicateFlag = false;
		return true;
	}
}

function nicknamePatternCheck(nickname){
	if(!nicknamePattern.test(nickname)){
		nicknamePatternFlag = false;
		nicknameDuplicateFlag = false;
		return false;
	} else{
		nicknamePatternFlag = true;
		nicknameDuplicateFlag = false;
		return true;
	}
}

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

function pwdPatternCheck(pwd){
	if(!pwdPattern.test(pwd)){
		pwdPatternFlag = false;
		pwdCheckFlag = false;
		return false;
	} else{
		pwdPatternFlag = true;
		pwdCheckFlag = false;
		return true;
	}
}

window.addEventListener("load", function(){

	// 멤버 섹션
	let memberSection = document.querySelector("#member-section");

	// 멤버 폼
	let memberForm = memberSection.querySelector(".member-form");
	let memberFormUl = memberSection.querySelector(".member-form ul");

	// id 중복 검사
	let idInput = memberForm.querySelector("input[name='id']");
	let idCheckExplanation = memberForm.querySelector(".id-check-explanation");
	let idDuplicateButton = memberForm.querySelector(".id-duplicate-button");

	// nickname 중복 검사
	let nicknameInput = memberForm.querySelector("input[name='nickname']");
	let nicknameCheckExplanation = memberForm.querySelector(".nickname-check-explanation");
	let nicknameDuplicateButton = memberForm.querySelector(".nickname-duplicate-button");

	// pwd 검사
	let pwdInput = memberForm.querySelector("input[name='password']");
	let pwdCheckExplanation = memberForm.querySelector(".password-check-explanation");
	let pwdCheckInput = memberForm.querySelector("input[name='password-check']");
	let pwdCheckExplanation2 = memberForm.querySelector(".password-check-explanation2");

	// email 검사
	let emailInput = memberForm.querySelector("input[name='email']");
	let emailCheckExplanation = memberForm.querySelector(".email-check-explanation");
	let emailDuplicateButton = memberForm.querySelector(".email-duplicate-button");

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
		 
 		sendGetRequest("is-email-authentication-ajax", params, true, function(result){
 		 	if(result){
		 		emailCheckExplanation.textContent = "이메일 중복";
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
			 		sendPostRequest("is-email-authentication-ajax", params, true, function(result){
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

	nicknameInput.addEventListener("keyup", (e)=>{
		let nickname = nicknameInput.value;
		nicknameInput.classList.remove("input-success");
		if(!nicknamePatternCheck(nickname)){
			nicknameCheckExplanation.textContent = "형식에 맞지 않음";
			return;
		}
		nicknameCheckExplanation.textContent = "";
	});

	nicknameDuplicateButton.onclick = (e)=>{
		let nickname = nicknameInput.value;
		if(!nicknamePatternCheck(nickname)){
			nicknameCheckExplanation.textContent = "형식에 맞지 않음";
			nicknameInput.classList.remove("input-success");
			return;
		}
		nicknameCheckExplanation.textContent = "";

 		var params = {nickname : nickname};
 		 sendGetRequest("is-nickname-duplicated-ajax", params, true, function(result){
 		 	if(result){
		 		nicknameCheckExplanation.textContent = "닉네임 중복";
	 	 		nicknameDuplicateFlag = false;
		 		nicknameInput.classList.remove("input-success");
	 	  		return;
		 	 } 
			nicknameCheckExplanation.textContent = "OK";
			nicknameDuplicateFlag = true;
			nicknameInput.classList.add("input-success");
 		 });	   	
	};

	pwdInput.addEventListener("keyup", (e)=>{
		let pwdCheck = pwdCheckInput.value;
		let pwd = pwdInput.value;

		if(!pwdPatternCheck(pwd)){
			pwdCheckExplanation.textContent = "형식에 맞지 않음";
			pwdInput.classList.remove("input-success");

			pwdCheckExplanation2.textContent = "";
			pwdCheckInput.classList.remove("input-success");
			return;
		}
		pwdCheckExplanation.textContent = "OK";
		pwdInput.classList.add("input-success");
		
		if(pwd!=pwdCheck){
			pwdCheckExplanation2.textContent = "일치하지 않음";
			pwdCheckInput.classList.remove("input-success");
			return;
		}
		pwdCheckExplanation2.textContent = "OK";
		pwdCheckInput.classList.add("input-success");
		pwdCheckFlag = true;
	});

	pwdCheckInput.addEventListener("keyup", (e)=>{
		let pwdCheck = pwdCheckInput.value;
		let pwd = pwdInput.value;
		if(pwd.trim()=="")
			return;
		if(!pwdPatternCheck(pwd)){
			pwdCheckExplanation.textContent = "형식에 맞지 않음";
			pwdInput.classList.remove("input-success");
			return;
		}
		if(pwd!=pwdCheck){
			pwdCheckExplanation2.textContent = "일치하지 않음";
			pwdCheckInput.classList.remove("input-success");
			return;
		}
		pwdCheckExplanation2.textContent = "OK";
		pwdCheckInput.classList.add("input-success");
		pwdCheckFlag = true;
	});

	idInput.addEventListener("keyup", (e)=>{
		let id = idInput.value;
		idInput.classList.remove("input-success");
		if(!idPatternCheck(id)){
			idCheckExplanation.textContent = "형식에 맞지 않음";
			return;
		}
		idCheckExplanation.textContent = "";
	});

	idDuplicateButton.onclick = (e)=>{
		let id = idInput.value;
		if(!idPatternCheck(id)){
			idCheckExplanation.textContent = "형식에 맞지 않음";
			idInput.classList.remove("input-success");
			return;
		}
		idCheckExplanation.textContent = "";
 		var params = {id : id};
 		 sendGetRequest("is-id-duplicated-ajax", params, true, function(result){
 		 	if(result){
		 		idCheckExplanation.textContent = "아이디 중복";
		 		idDuplicateFlag = false;
		      idInput.classList.remove("input-success");
 		 		return;
 		 	}   
 			 idCheckExplanation.textContent = "OK";
			 idDuplicateFlag = true;
			 idInput.classList.add("input-success");
		});	
	};

	submitButton.onclick = function(e){
		if(!idPatternFlag || !idDuplicateFlag || !pwdPatternFlag || !pwdCheckFlag ||
			!nicknamePatternFlag || !nicknameDuplicateFlag|| !emailPatternFlag || !emailDuplicateFlag
			|| !certifyCheckFlag){
			e.preventDefault();
			return;
		}
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