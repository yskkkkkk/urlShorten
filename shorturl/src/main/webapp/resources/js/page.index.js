$(document).ready(function() {
	const urlKey = document.getElementById("urlKey").value;
	if (urlKey != "") {
		$.get_origin_url(urlKey);
	}
});

function Enter_Check(){
	if (window.event.keyCode == 13) {
		if(document.activeElement.id == "origin"){
			$.get_url_key();
		} else if(document.activeElement.id == "input_key_url"){
			var data = document.getElementById("input_key_url").value;
			$.get_origin_url(data.split("/")[data.split("/").length-1]);
		}
	}
}

$(document.getElementById("trans_btn")).on("click", function() {
	$.get_url_key();
});

$(document.getElementById("send_btn")).on("click", function() {
	var data = document.getElementById("input_key_url").value;
	$.get_origin_url(data.split("/")[data.split("/").length-1]);
});

$.get_origin_url = function (urlKey) {
	$.ajax({
		type: "GET",
		url: "/url/url?urlKey="+urlKey,
		dataType: "text",
		async:false,
		success: function(result) {
			window.location.href = result;	
		},
		error: function(request, status, error) {   // 오류가 발생했을 때 호출된다. 
			alert('존재하지 않는 주소입니다.');
			console.warn("code:" + request.status + "\n" + "message:" + request.responseText + "\n" + "error:" + error);
		},
	});
}

$.get_url_key = function () {
	var nullFlag = false;
	if (document.getElementById("origin").value == "" || document.getElementById("origin").value == undefined) {
		alert('변환할 주소를 입력해주세요');
		nullFlag = true;
	}
	if (nullFlag) return;
	
	var data = document.getElementById("origin").value;
	data = data.substring(0.4) == "http" ? data : "http://" + data;

	let regex = /(http(s)?:\/\/)([a-z0-9\w]+\.{1})+[a-z0-9]{2,4}/gi
	if(!regex.test(data)){
		alert('형식에 맞는 주소를 입력해주세요');
		nullFlag = true;
	}
	if (nullFlag) return;
	const urlDTO = {};
	urlDTO["origin_url"] = data;
	$.ajax({
		type: "POST",
		url: "/url/url",
		data: JSON.stringify(urlDTO),
		dataType: "text",
		async:false,
		contentType: "application/json; charset=utf-8",
		success: function(result) {
			$('#result').val("http://localhost/"+result);
			$('#result').css("display","block");
		},
		error: function(request, status, error) {   // 오류가 발생했을 때 호출된다. 
			console.warn("code:" + request.status + "\n" + "message:" + request.responseText + "\n" + "error:" + error);
		},
	});
}

function sel(){
	$(event.target).select();
}


