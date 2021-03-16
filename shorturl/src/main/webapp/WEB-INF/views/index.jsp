<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<link rel="shortcut icon" href="#">

<meta charset="UTF-8">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
</head>
<body>
	<input type="hidden" value="${originUrl}" id="orgin_url">
	<div>
		<form class="well form-search">
			<input type="text" class="input-medium search-query"
				placeholder="url 입력" id="origin" />
			<button type="button" class="btn" id="trans_btn">변환</button>
			<input type="text" class="input-medium search-query" readonly="readonly" id="result" style="display: none;" />
		</form>
	</div>
	<div>
		<form class="well form-search">
			<input type="text" class="input-medium search-query"
				placeholder="단축 url 입력" />
			<button type="button" class="btn">주소 입력</button>
		</form>
	</div>


</body>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/resources/js/page.index.js"></script>

</html>

