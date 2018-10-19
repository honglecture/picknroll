let noticeParams = {};
let id = null;

window.addEventListener("load", function(){
	  //URL에서 쿼리스트링 값 가져오기
	  let qs = getQueryStringObject();
	  id = qs.id;
	  noticeParams.p = blankToOne(qs.p);
	  noticeParams.f = nullToValue(qs.f, "title");
	  noticeParams.q = nullToValue(qs.q, "");
	  noticeParams.s = nullToValue(qs.s, "regDate");
	  createReply();
	  
	  
	  let articleContent = document.querySelector("#article-content");
	  let listButton = articleContent.querySelector(".list-button");
	  let editButton = articleContent.querySelector(".edit-button");
	  
	  let articleReply = document.querySelector("#article-reply");
	  let textarea = articleReply.querySelector("textarea");
	  let regButton = articleReply.querySelector("input[type='submit']");
	  
	  if(editButton!=null){
		  editButton.onclick = ()=>{
			  let qs = createQuerystring(noticeParams);
			  location.href = "edit?"+qs+"&id="+id;
		  };
	  }
	  
	  listButton.onclick = ()=>{
		  let qs = createQuerystring(noticeParams);
		  location.href = "list?"+qs;
	  };
	  
	  if(regButton!=null){
		  regButton.onclick = (e)=>{
			  e.preventDefault();
			  let content = textarea.value.trim();
			  if(content=="")
				  return;
			  let params = {content : content, noticeId : id};
			  sendPostRequest("reply-reg-ajax", params, true, function(result){
				  if(result){ //등록되면
					  createReply();
					  textarea.value = "";
					  return;
				  }
			  });
		  }
	  }

});

function createReply(){
	let articleReply = document.querySelector("#article-reply");
	let replyCount = articleReply.querySelector(".reply-count");
	let replyList = articleReply.querySelector(".reply-list");
	let params = {id, id};
	sendPostRequest("reply-list-ajax", params, true, function(result){
		let totalCount = result.totalCount;
		let loginId = result.loginId;
		let list = result.list;
		replyCount.textContent = totalCount;
		let html = "";
		for(let i=0; i<list.length; i++){
			html += '<div class="div-box-gray section-margin noto-sans font-md">';
			html += '	<p>';
			html += 	list[i].content;
			html += '	<p>';
			html += '	<ul class="flex flex-vertical-center">';
			html += '		<li><span class="jeju-gothic">'+list[i].nickname+'</span> | '+list[i].regDate+' </li>';
			if(list[i].writerId == loginId)
				html += '		<li><input class="button button-inline notice-button-sm" onclick="javascript:deleteReply('+list[i].id+')" type="button" value="삭제" /></li>';
			html += '	</ul>';
			html += '</div>';
		}
		replyList.innerHTML = html;
	});
}

function deleteReply(replyId){
	let params = {id : replyId};
	sendPostRequest("reply-delete-ajax", params, true, function(result){
		if(result){ //등록되면
			createReply();
			return;
		}
	});
}