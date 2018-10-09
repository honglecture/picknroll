function sendPostRequest(url, params, asyn, callback){
	let request = new XMLHttpRequest();
	request.onload = function(e){ 
		if (request.status === 200) {
			let result = JSON.parse(request.responseText);
			callback(result);
		} else{  
			alert('request에 뭔가 문제가 있어요.');
		}  
	}
	request.open("post", url, asyn);
	request.setRequestHeader("Content-Type", "application/json; charset=UTF-8");
	request.send(JSON.stringify(params));
}

function sendGetRequest(url, params, asyn, callback){
	let request = new XMLHttpRequest();
	request.onload = function(e){ 
		if (request.status === 200) {
			let result = JSON.parse(request.responseText);
			callback(result);
		} else{  
			alert('request에 뭔가 문제가 있어요.');
		}  
	}
	request.open("get", url+"?"+createQuerystring(params), asyn);
	request.send();
}

function blankToZero(num){
	if(num==0 || num=='' || num==undefined)
		return 0;
	return Number(num);
}

function blankToOne(num){
	if(num==0 || num=='' || num==undefined)
		return 1;
	return Number(num);
}

function nullToValue(str, value){
	if(str==0 || str=='' || str==undefined)
		return value;
	return str;
}

function createQuerystring(params){
	let qs = "";
	let size = 0;
	let temp = 0;
	for (let key in params){
		if (params.hasOwnProperty(key)) 
			size++;
	}
	for (let key in params) {
		temp++;
		qs += key + "=" + params[key];
		if(temp!=size)
			qs += "&";
	}
	return qs;
}
