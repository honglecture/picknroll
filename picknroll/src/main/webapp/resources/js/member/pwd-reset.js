let pwdPattern = /^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\W\d]{8,20}$/;

let pwdPatternFlag = false;
let pwdCheckFlag = false;

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
	let form = memberSection.querySelector(".member-form form");

	let pwdResetButton = memberSection.querySelector(".pwd-reset-button");
	let loginButton = memberSection.querySelector(".login-button");
	

	// pwd 검사
	let pwdInput = memberForm.querySelector("input[name='password']");
	let pwdCheckExplanation = memberForm.querySelector(".password-check-explanation");
	let pwdCheckInput = memberForm.querySelector("input[name='password-check']");
	let pwdCheckExplanation2 = memberForm.querySelector(".password-check-explanation2");

	// submit 버튼
	let submitButton = memberForm.querySelector("input[type='submit']");
	
	pwdResetButton.onclick = ()=>{
		form.classList.remove("hidden");
		loginButton.classList.add("hidden");
		pwdResetButton.classList.add("hidden");
	}

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

	submitButton.onclick = function(e){
		if(!pwdPatternFlag || !pwdCheckFlag){
			e.preventDefault();
			return;
		}
	};

});
