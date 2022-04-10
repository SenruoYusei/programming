<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix = "fn" uri = "http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>スポ館シフト提出フォーム</title>
<link rel = "stylesheet" type = "text/css" href = "/shiftCollection/css/test.css">
</head>
<body>
	<div>
		<h1>メンバーの削除</h1>
		<c:if test = "${not empty executeMsg }">
			<p>${executeMsg}</p>
		</c:if>
		<c:forEach begin = "0" end = "${ fn:length(members) - 1}" step = "1" varStatus = "status">
			<c:set var = "index" value = "${status.index }"/>
			<form action = "/shiftCollection/DeleteMember" method = "post">
				<input type = "hidden" name = "pos" value = "${ members.get(index).getId() }">
				<input type = "hidden" name = "deleteName" value = "${members.get(index).getName() }">
				${members.get(index).getName() }
				<button name = "action" value = "delete">削除</button>
			</form>
		</c:forEach>
		<a href = "/shiftCollection/ShowMember">メンバー表示</a>
		<a href = "/shiftCollection/Logout">ログアウト</a>
	</div>
</body>
</html>