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
		<h1>ログイン</h1>
		<c:if test = "${not empty loginError }">
			<p>${loginError}</p>
		</c:if>
		<form action = "/shiftCollection/WelcomeServlet" method = "post">
			ユーザー名 : <input type = "text" name = "userName"><br>
			パスワード : <input type = "password" name = "pass"><br>
			<input type = "submit" value = "ログイン">
		</form>
		<p>修正入力エンコード</p>
	</div>
</body>
</html>