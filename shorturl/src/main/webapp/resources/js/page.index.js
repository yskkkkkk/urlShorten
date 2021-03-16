$(document).ready(function() {
	const url = document.getElementById("orgin_url").value;
	if (url != "") window.location.href = url;

	$(document.getElementById("trans_btn")).on("click", function() {
		var nullFlag = false;
		if (document.getElementById("origin").value == "" || document.getElementById("origin").value == undefined) {
			alert('변환할 주소를 입력해주세요');
			nullFlag = true;
		}
		
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
				console.log("code:" + request.status + "\n" + "message:" + request.responseText + "\n" + "error:" + error);
			},
		});
	});
});