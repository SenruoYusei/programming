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
		<h1>メンバー追加</h1>
		<form action = "/shiftCollection/AddMember" method = "post">
			<c:forEach begin = "0" end = "10" step = "1" varStatus = "status">
				<c:set var = "index" value = "${status .index }"/>
					名前 : <input type = "text" name = name[] >
					パスワード : <input type = "text" name = pass[] value = "1111">
			</c:forEach>
			<input type = "submit" value = "決定">
		</form>
	</div>
</body>
</html>