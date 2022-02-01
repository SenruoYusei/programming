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
		<p>ようこそ<c:out value = "${member.name}"/>さん</p>
		<a href = "/shiftCollection/termServlet">シフト登録へ</a><br>
		<a href = "/shiftCollection/ChangePassServlet">パスワードの変更</a><br>
		<a href = "/shiftCollection/WelcomeServlet">トップへ</a><br>
	</div>
</body>
</html>