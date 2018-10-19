let noticeParams = {
}

window.addEventListener("load", function(){
	
	  let searchSection = document.querySelector("#search-section");
	  let searchButton = searchSection.querySelector("input[type='submit']");
	  let f = searchSection.querySelector("select[name='f']");
	  let q = searchSection.querySelector("input[name='q']");
	  let articleList = document.querySelector("#article-list");
	  
	  let regButton = articleList.querySelector(".reg-button");
	  
	  let qs = getQueryStringObject();
	  noticeParams.p = blankToOne(qs.p);
	  noticeParams.f = nullToValue(qs.f, "title");
	  noticeParams.q = nullToValue(qs.q, "");
	  noticeParams.s = nullToValue(qs.s, "regDate");
	  
	  createTable();
	  
	  searchButton.onclick = (e)=>{
		 e.preventDefault();
		 noticeParams.f = nullToValue(f.value, "title");
		 noticeParams.q = nullToValue(q.value, "");
		 createTable();
	  };	
	  
	  if(regButton!=null){
		  regButton.onclick = (e)=>{
		  	 let qs = createQuerystring(noticeParams);
			 location.href = "reg?"+qs;
		  };
	  }
	
});

function createTable(){
	let articleList = document.querySelector("#article-list");
	let articleListUl = articleList.querySelector("ul");
	let paginationDiv = articleList.querySelector(".pagination");
	sendPostRequest("list-ajax", noticeParams, false, function(result){
		let list = result.list;
		let totalCount = result.totalCount;
		let noticeList = "";
		for(let i=0; i<list.length; i++){  
			let qs = createQuerystring(noticeParams) + "&id=" + list[i].id;
			let replyCount = "";
			if(list[i].replyCount!=0)
				replyCount = "("+list[i].replyCount+")";
			noticeList += '<li>';
			noticeList += '	<a href="detail?'+qs+'">';
			noticeList += '		<article class="article">';
			noticeList += '			<span>'+list[i].title+' '+replyCount+'</span>';
			noticeList += '			<div class="article-info"> ';
			noticeList += '				<ul>';
			noticeList += '					<li>'+list[i].id+' |</li> ';
			noticeList += '					<li>작성자 : '+list[i].nickname+' |</li>';
			noticeList += '					<li>조회수 : '+list[i].hit+' |</li>';
			noticeList += '					<li>'+list[i].regDate+'</li>';
			noticeList += '				</ul>';
			noticeList += '			</div>'; 
			noticeList += '		</article>';
			noticeList += '	</a>';
			noticeList += '</li>';
		}
		articleListUl.innerHTML = noticeList;
		makePagination(noticeParams.p, totalCount);
	});
}


function makePagination(pageNum, totalCount){
	
	let articleList = document.querySelector("#article-list");
	let paginationUl = articleList.querySelector(".pagination > ul");
	
	let pageSize = 10;
	let pageBlock = 5; 
	
	let totalPage = parseInt(Math.ceil(parseFloat(totalCount)/pageSize));
	let startRow = (pageNum - 1) * pageSize + 1;
	let endRow = pageNum * pageSize;
	let startPage = parseInt((pageNum - 1) / pageBlock) * pageBlock + 1;
	let endPage = startPage + pageBlock - 1;
	
	if (endPage > totalPage)
		endPage = totalPage;
	
	let html = "";
	html += '<li class="pagination-item" onclick="javascript:movePage(\'';
	html += 1;
	html += '\')">&lt;&lt;</li>';
	// Page클래스 변경 부분
	if (startPage < pageBlock) {
		//비활성화 <
		html += '<li class="pagination-item">&lt;</li>';
	} else {
		//활성화 <
		html += '<li class="pagination-item" onclick="javascript:movePage(\'';
		html += startPage - pageBlock;
		html += '\')">&lt;</li>';
	}
	
	for (let i = startPage; i <= endPage; i++) {
		if (i == pageNum) {
			// 비활성화 i
			html += '<li class="pagination-item pagination-item-disabled">';
			html += i;
			html += '</li>';
		} else {
			// 활성화 i
			html += '<li class="pagination-item" onclick="javascript:movePage(\'';
			html += i;
			html += '\')">'+i+'</li>';
		}
	} 
	
	if (endPage < totalPage) {
		//활성화 >
		html += '<li class="pagination-item" onclick="javascript:movePage(\'';
		html += startPage + pageBlock;
		html += '\')">&gt;</li>';
	} else {
		// 비활성화 >
		html += '<li class="pagination-item">&gt;</li>';
	}
	
	html += '<li class="pagination-item" onclick="javascript:movePage(\'';
	html += totalPage;
	html += '\')">&gt;&gt;</li>';
	
	paginationUl.innerHTML = html;
	
}

function movePage(page){
	noticeParams.p = page;
	createTable();
}