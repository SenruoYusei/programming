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
		<h1>シフトの登録が完了しました．</h1>
		${startID }
		<a href = "/shiftCollection/WelcomeServlet">トップへ</a><br>
		<a href = "/shiftCollection/DeleteMember">メンバーの削除</a><br>
		
	</div>
</body>
</html>