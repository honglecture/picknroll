let noticeParams = {};

window.addEventListener("load", function(){
	
	let qs = getQueryStringObject();
	noticeParams.p = blankToOne(qs.p);
	noticeParams.f = nullToValue(qs.f, "title");
    noticeParams.q = nullToValue(qs.q, "");
	noticeParams.s = nullToValue(qs.s, "regDate");
	
	
	let articleContent = document.querySelector("#article-content");
	let inputTitle = articleContent.querySelector("input[name='title']"); 
	let editButton = articleContent.querySelector(".edit-button");
	let listButton = articleContent.querySelector(".list-button");
	let textareaContent = articleContent.querySelector("textarea[name='content']");
	
	CKEDITOR.replace("content");
	CKEDITOR.instances.content.setData(textareaContent.value); //값 넣어줌
	
    listButton.onclick = ()=>{
  	    let qs = createQuerystring(noticeParams);
	    location.href = "list?"+qs;
    };

    editButton.onclick = (e)=>{
		let content = CKEDITOR.instances.content.getData();
		let title = inputTitle.value;
		if(title.trim()=="" || content.trim()==""){
			e.preventDefault(); // 막기
			return;
		}
		textareaContent.value = content;
	}
	 
});