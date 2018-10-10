window.addEventListener("load", function(){
	
	let memberSection = document.querySelector("#member-section");
	
	// 멤버 프로필
	let memberProfile = memberSection.querySelector(".member-profile");
	let photo = memberProfile.querySelector(".photo");
	
	// 멤버 폼
	let memberForm = memberSection.querySelector(".member-form");

    //사진선택
    let photoButton = memberForm.querySelector(".photo-button");
	let fileButton = memberForm.querySelector("input[type='file']");

	//date
	let birthdayInput = memberForm.querySelector("input[name='birthday']");
	let genderInput = memberForm.querySelector("select[name='gender']");

	// 전송 버튼
	let submitButton = memberForm.querySelector("input[type='submit']");
	 
	// 상태값  

	fileButton.onchange = function(e){

		let file = fileButton.files[0];
		
		// 선택한 파일에 대한 조건 제어
		
		console.log(file.type); //image/jpeg
		
		if(file.type.indexOf("image/") < 0){
			alert("이미지가 아닙니다.");
			return;
		}
		
		if(file.size > 1024*1024*10){
			alert("죄송합니다. 10MB를 초과할 수 없습니다.")
			return;
		}
		
		// 브라우저 메모리에 파일이 올라감
		// html5 기능 로컬 이미지 불러들이기
		let reader = new FileReader();
		reader.onload = function(evt){ 
			photo.src = evt.target.result; // 여기서 file 들어간다.
		};
		// 다 읽어 왔을 때.. background에서.. 
		reader.readAsDataURL(file);	
		console.log(file);

	};

	photoButton.onclick = function(e){
		let event = new MouseEvent("click",{
			"view" : window,
			"bubbles" : true,
			"cancelable" : true
		});
		fileButton.dispatchEvent(event);
	}
	
	submitButton.onclick = function(e){
		let birthday = birthdayInput.value;
		let gender = genderInput.value;
		if(birthday=="" || gender ==""){
			e.preventDefault();
			return;
		}
	}

});