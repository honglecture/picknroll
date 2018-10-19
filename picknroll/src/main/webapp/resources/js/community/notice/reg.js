let noticeParams = {};

window.addEventListener("load", function(){
	
	let qs = getQueryStringObject();
	
	noticeParams.p = blankToOne(qs.p);
	noticeParams.f = nullToValue(qs.f, "title");
    noticeParams.q = nullToValue(qs.q, "");
	noticeParams.s = nullToValue(qs.s, "regDate");
	
	CKEDITOR.replace("content");
	let articleContent = document.querySelector("#article-content");
	let inputTitle = articleContent.querySelector("input[name='title']"); 
	let regButton = articleContent.querySelector(".reg-button");
	let listButton = articleContent.querySelector(".list-button");
	
    listButton.onclick = ()=>{
  	    let qs = createQuerystring(noticeParams);
	    location.href = "list?"+qs;
    };
	
	let textareaContent = articleContent.querySelector("textarea[name='content']");
	regButton.onclick = (e)=>{
		let content = CKEDITOR.instances.content.getData();
		let title = inputTitle.value;
		if(title.trim()=="" || content.trim()==""){
			e.preventDefault(); // 막기
			return;
		}
		textareaContent.value = content;
	}
	 
});