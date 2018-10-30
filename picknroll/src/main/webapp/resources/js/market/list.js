let marketParams = {
	appCategoryId : "",
	useFlag : "",
	appId : ""
};

window.addEventListener("load", function(){
	
	let appSearch = document.querySelector("#app-search"); 
	let categorySelect = appSearch.querySelector(".category-select");
	
	
/*	appLi.addEventListener("click", (e)=>{
		//e.stopPropagation();
		let target = e.currentTarget;
		let useCheck = target.querySelector(".use-check");
		let appId = target.dataset["id"];
		
		marketParams.appId = appId;
		
		if(useCheck.checked){
			useCheck.checked=false;
			marketParams.useFlag = "false";
		} else{
			useCheck.checked=true;
			marketParams.useFlag = "true";
		}
		sendPostRequest("reg-member-app-ajax", marketParams, false, function(result){
			
		});
	}, false);*/
	
	
	// createList
	createTable();
	// 바뀌면 list
	categorySelect.onchange = (e)=>{
		marketParams.appCategoryId = categorySelect.value;
		createTable();
	};
	
});
 

function createTable(){
	
	sendPostRequest("list-ajax", marketParams, false, function(result){

		let appList = result.list;
		let totalCount = result.totalCount;

		let appListSection = document.querySelector("#app-list-section");
		let appListUl = appListSection.querySelector(".app-list-ul");
		appListUl.innerHTML = '';
		
		for(let i=0; i<appList.length; i++){

			let li = document.createElement("li");
			li.classList.add("app-li");
			/*li.classList.add("div-box-black");*/
			li.setAttribute('data-id' , appList[i].id); 
	
			let article = document.createElement("article");
			article.classList.add("app-article");
	
			let div = document.createElement("div");
			div.classList.add("app-info");
			div.classList.add("flex"); 
			div.classList.add("flex-vertical-center");
	
			let img = document.createElement("img");
			img.src = "/resources/app/icon/"+appList[i].icon;
			img.classList.add("photo");
	
			let ul = document.createElement("ul");
			ul.classList.add("margin-left");

			
	
			let titleLi = document.createElement("li");
			let categoryLi = document.createElement("li");
			let regDateLi = document.createElement("li");
	
			titleLi.classList.add("text-lg");
			categoryLi.classList.add("text-sm");
			regDateLi.classList.add("text-sm");
	
			titleLi.textContent = appList[i].title;
			categoryLi.textContent = appList[i].categoryName;
			regDateLi.textContent = appList[i].regDate;
			
			let button = document.createElement("input");
			button.type = "button";
			button.value = "Pick";
			button.classList.add("use-check");
/*			let checkBox = document.createElement("input");
			checkBox.type = "checkbox";
			checkBox.classList.add("use-check");
			
			checkBox.onclick = (e)=>{
				e.preventDefault();
			};*/
			
/*			checkBox.addEventListener("click", (e)=>{
				e.preventDefault();
			}, false);*/
			if(appList[i].memberId!=null){
				button.value = "취소";
				button.classList.add("check"); 
				li.classList.add("div-box-black"); 
			} else{
				button.value = "Pick";
				button.classList.remove("check");
				li.classList.add("div-box-gray");
			}
	
			let p = document.createElement("p");
			p.classList.add("noto-sans");
			p.classList.add("text-sm");
			p.textContent = appList[i].description;
	
			li.addEventListener("click", (e)=>{
				e.preventDefault();
				e.stopPropagation();
				let target = e.currentTarget;
				let useCheck = target.querySelector(".use-check");
				let appId = target.dataset["id"];
				
				marketParams.appId = appId;
				console.log(target);
				
				if(useCheck.classList.contains("check")){
					button.value = "Pick";
					useCheck.classList.remove("check");
					li.classList.remove("div-box-black");
					li.classList.add("div-box-gray");
					marketParams.useFlag = "false";
				} else{
					button.value = "취소";
					useCheck.classList.add("check");
					li.classList.remove("div-box-gray");
					li.classList.add("div-box-black");
					marketParams.useFlag = "true";
				}
				
/*				if(useCheck.checked){
					useCheck.checked=false;
					marketParams.useFlag = "false";
				} else{
					useCheck.checked=true;
					marketParams.useFlag = "true";
				}*/
				
				sendPostRequest("reg-member-app-ajax", marketParams, false, function(result){});
			}, false);

			// 조립
			ul.appendChild(titleLi);
			ul.appendChild(categoryLi);
			ul.appendChild(regDateLi);
			div.appendChild(img);
			div.appendChild(ul);
			div.appendChild(button);
			article.appendChild(div);
			article.appendChild(p);
			li.appendChild(article);

			appListUl.appendChild(li);
		}
		
	});
	
}