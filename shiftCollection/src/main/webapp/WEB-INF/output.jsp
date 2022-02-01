<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name = "viewport" content = "width=device-width,user-scalable=no,maximum-scale=1"/>
<title>ファイル出力</title>
<link rel = "stylesheet" type = "text/css" href = "/shiftCollection/css/test.css">
</head>
<body>
	<%--
	<form name = "download" action = "/shiftCollection/Output" method = "post">
		<a href = "" onClick = "download.submit();">ダウンロード</a>
		<input type = "button" value = "ダウンロード" onclick = "location.href = '/shiftCollection/Output'"><br>
	</form>
	--%>
	<div>
		<input type = "button" value = "csvダウンロード" onclick = "location.href='GenerateCsv'"><br>
	</div>
</body>
</html>