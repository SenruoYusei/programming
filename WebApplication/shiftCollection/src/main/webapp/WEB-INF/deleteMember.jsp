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
		<c:forEach begin = "0" end = "${ fn:length(members) - 1}"step = "1" varStatus = "index">
			<c:set var = "memberIndex" value = "${index.index }"/>
			${members.get(memberIndex).getName() }
			<form action = "/shiftCollection/DeleteMember" method = "post">
				<input type = "hidden" name = "pos" value = "${index }">
				<input type = "hidden" name = "deleteName" value = "${members.get(memberIndex).getName() }">
				<button name = "action" value = "delete">削除</button>
			</form>
		</c:forEach>
		<a href = "/shiftCollection/ShowMember">メンバー表示</a>
		<a href = "/shiftCollection/Logout">ログアウト</a>
	</div>
</body>
</html>