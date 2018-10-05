window.addEventListener("load", function(){

	var memberSection = document.querySelector("#member-section");
	var memberForm = memberSection.querySelector(".member-form");
	
	var form = memberSection.querySelector(".member-form > form");
	
	//패스워드 input
	var passwordInput = memberForm.querySelector(".password");
	var passwordCheckInput = memberForm.querySelector(".password-check");
	var submitButton = memberForm.querySelector("input[type='submit']");
	
	var pwdResetButton = memberForm.querySelector(".pwd-reset-button");
	
	pwdResetButton.onclick = function(e){
		form.classList.remove("hidden"); // 보이게 한다.
		pwdResetButton.classList.add("hidden"); // 보이게 한다.
	};
	
	submitButton.onclick = function(e){
		var password = passwordInput.value.trim();
		var passwordCheck = passwordCheckInput.value.trim();
		if(password=="" || passwordCheck=="" || password!=passwordCheck){
			e.preventDefault();
			alert("비밀번호를 다시 확인해 주세요");
			return;
		}
	};
	
});