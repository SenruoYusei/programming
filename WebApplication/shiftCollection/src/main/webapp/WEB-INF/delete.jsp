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
		<h1>シフト削除画面</h1>
		<p><c:out value = "${member.name }"/>さんログイン中</p>
		<a href = "/shiftCollection/Logout">ログアウト</a>
		<p>${month + 1 }月
		<c:choose>
			<c:when test = "${term == 0 }">前半</c:when>
			<c:otherwise>後半</c:otherwise>
		</c:choose><br>
		${deletePos}
		<c:set var = "index" value = "${deletePos }"/>
		
		<p>${member.getDay(index) } : ${member.getSchedule(index) }</p>
		上記の日程を削除してもよろしいですか？
		
		<form action = "/shiftCollection/Delete" method = "post">
			<input type = "hidden" name = "pos" value = "${deletePos }">
			<button name = "flag" value = "1">はい</button>
			<button name = "flag" value = "0">いいえ</button>
		</form>
		
	</div>

</body>
</html>