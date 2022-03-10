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
		<h1>シフト提出画面</h1>
		<p><c:out value = "${member.name }"/>さんログイン中</p>
		<a href = "/shiftCollection/Logout">ログアウト</a>
		<p>${month + 1 }月
		<c:choose>
			<c:when test = "${term == 0 }">前半</c:when>
			<c:otherwise>後半</c:otherwise>
		</c:choose><br>
		<form action = "/shiftCollection/RegisterConfirmServlet" method = "post">
			<c:forEach begin="0" end="${member.dayNum - 1}" step="1" varStatus="status">
				<c:set var = "index" value = "${ status.index}"/>
				<c:set var = "info" value = "${member.getSchedule(index) }"/>
				<p>${member.getDay(index)} : ${info }</p>
				<c:if test = "${not empty member.getDay(index)}">
					<input type = "hidden" name = "pos" value = "${index }">
					${index }
					<button name = "action" value = "modify">修正</button>
					<button name = "action" value = "delete">削除</button>
					<br>
				</c:if>
			</c:forEach>
		</form>
		<a href = "/shiftCollection/registerServlet">登録画面に戻る</a>
		<a href = "/shiftCollection/registerOKServlet">提出する</a>
	</div>
	
</body>
</html>