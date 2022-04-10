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
		${deleteName } さんを削除しました
		<a href = "/shiftCollection/DeleteMember">削除を続ける</a>
		<a href = "/shiftCollection/ShowMember">メンバー表示</a><%--追加に変更？ --%>
		<a href = "/shiftCollection/Logout">ログアウト</a>
	</div>
</body>
</html>