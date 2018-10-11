let noticeParams = {
/*		p : blankToOne("${params.p}")
	   ,f : nullToValue("${params.f}", "title")
	   ,q : nullToValue("${params.q}", "")
	   ,s : nullToValue("${params.s}", "regDate")*/
}

window.addEventListener("load", function(){
	
	  let searchSection = document.querySelector("#search-section");
	  let searchButton = searchSection.querySelector("input[type='submit']");
	  let f = searchSection.querySelector("select[name='f']");
	  let q = searchSection.querySelector("input[name='q']");
	 
	  let articleList = document.querySelector("#article-list");
	  let p = articleList.querySelector("input[name='p']");
	  let s = articleList.querySelector("input[name='s']");
	  
	  noticeParams.p = blankToOne(p.value);
	  noticeParams.f = nullToValue(f.value, "title");
	  noticeParams.q = nullToValue(q.value, "");
	  noticeParams.s = nullToValue(s.value, "regDate");
	  
	  createTable();
	  
	  searchButton.onclick = (e)=>{
		 e.preventDefault();
		 noticeParams.f = nullToValue(f.value, "title");
		 noticeParams.q = nullToValue(q.value, "");
		 createTable();
	  }
	  
/*	  let btnReg = articleSection.querySelector(".btn-reg");*/
	
	// if(btnReg!=null){
	// 	btnReg.onclick = function(e){
	// 		let qs = createQuerystring(noticeParams);
	// 		location.href = "reg?"+qs;
	// 	}
	// }
	
	// searchButton.onclick = function(e){
	// 	e.preventDefault();
	// 	noticeParams.f = f.value;
	// 	noticeParams.q = q.value;
	// 	createTable();
	// };
	
	
});

function createTable(){
	let articleList = document.querySelector("#article-list");
	let articleListUl = articleList.querySelector("ul");
	sendPostRequest("list-ajax", noticeParams, true, function(result){
		let list = result.list;
		let noticeList = "";
		for(let i=0; i<list.length; i++){  
			let qs = createQuerystring(noticeParams) + "&id=" + list[i].id;

			noticeList += '<li>';
			noticeList += '	<a href="detail?'+qs+'">';
			noticeList += '		<article class="article">';
			noticeList += '			<span>'+list[i].title+'</span> ';
			noticeList += '			<div class="article-info"> ';
			noticeList += '				<ul>';
			noticeList += '					<li>번호 : '+list[i].id+' |</li> ';
			noticeList += '					<li>작성자 : '+list[i].nickname+' |</li>';
			noticeList += '					<li>조회수 : '+list[i].hit+' |</li>';
			noticeList += '					<li>작성일 : '+list[i].regDate+'</li>';
			noticeList += '				</ul>';
			noticeList += '			</div>';
			noticeList += '		</article>';
			noticeList += '	</a>';
			noticeList += '</li>';
		}
		articleListUl.innerHTML = noticeList;
	});
}