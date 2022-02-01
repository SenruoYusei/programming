<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name = "viewport" content = "width=device-width,user-scalable=no,maximum-scale=1"/>
<title>スポ館シフト提出フォーム</title>
<link rel = "stylesheet" type = "text/css" href = "/shiftCollection/css/test.css">
</head>
<body>
	<div>
		<h1>パスワードの変更</h1>
		<c:if test = "${not empty matchError }">
			<p>${matchError}</p>
		</c:if>
		<form action = "/shiftCollection/ChangePassServlet" method = "post">
			現在のパスワード : <input type = "password" name = "currentPass"><br>
			新しいパスワード : <input type = "text" name = "newPass"><br>
			<input type = "submit" value = "更新">
		</form>
	</div>
</body>
</html>