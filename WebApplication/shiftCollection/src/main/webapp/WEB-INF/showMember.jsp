<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix = "fn" uri = "http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name = "viewport" content = "width=device-width,user-scalable=no,maximum-scale=1"/>
<title>管理者ログイン</title>
<link rel = "stylesheet" type = "text/css" href = "/shiftCollection/css/test.css">
</head>
<body>
	<div>
		<h1>メンバー確認</h1>
		<c:if test = "${not empty executeMsg }">
			<p>${executeMsg}</p>
		</c:if>
		<c:forEach begin = "0" end = "${fn:length(members) - 1 }" step = "1" varStatus = "index">
			<c:set var = "memberIndex" value = "${index.index }" />
			<p>${members.get(memberIndex).getName() }</p><br>
		</c:forEach>
		<a href = "/shiftCollection/AddMember">メンバーの追加</a>
		<a href = "/shiftCollection/DeleteMember">メンバーの削除</a>
	</div>

</body>
</html>