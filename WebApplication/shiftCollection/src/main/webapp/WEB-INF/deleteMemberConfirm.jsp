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
		<p>${members.get(deletePos)} さんを削除してもよろしいですか？</p>
		<c:set var = "deleteID" value = "${members.get(deletePos).getId() }"/>
		${deleteID }
		<form action = "/shiftCollection/DeleteMember" method = "post">
			<input type = "hidden" name = "id" value = "${deleteID }">
			<button name = "flag" value = "1">はい</button>
			<button name = "flag" value = "0">いいえ</button>
		</form>
		<a href = "/shiftCollection/ShowMember">メンバー表示</a>
		<a href = "/shiftCollection/Logout">ログアウト</a>
	</div>
</body>
</html>