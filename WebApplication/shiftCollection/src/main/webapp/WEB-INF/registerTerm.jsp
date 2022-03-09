<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<%-- 月と期間(前半 or 後半) の登録をするページ --%>
<html>
<head>
<meta charset="UTF-8">
<meta name = "viewport" content = "width=device-width,user-scalable=no,maximum-scale=1"/>
<title>スポ館シフト提出フォーム</title>
<link rel = "stylesheet" type = "text/css" href = "/shiftCollection/css/test.css">
</head>
<body>
	<div>
		<h1>月，期間登録ページ</h1>
		<p>
		<c:if test = "${not empty inputError }">
			${inputError }
		</c:if>
		<c:out value="${member.name }"/>さん，ログイン中
		<a href = "/shiftCollection/Logout">ログアウト</a>
		</p>
		<form action = "/shiftCollection/termServlet" method = "post">
			<select name = "month">
				<option value = "0">1
				<option value = "1">2
				<option value = "2">3
				<option value = "3">4
				<option value = "4">5
				<option value = "5">6
				<option value = "6">7
				<option value = "7">8
				<option value = "8">9
				<option value = "9">10
				<option value = "10">11
				<option value = "11">12
			</select>
			月<br>
			<input type = "radio" name = "term" value = 0 checked = "checked">前半<br>
			<input type = "radio" name = "term" value = 1>後半<br>
			<input type = "submit" value = "月・期間決定">
		</form>
		<c:if test = "${not empty errorMsg }">
			<p>${errorMsg }</p>
		</c:if>
		<c:if test = "${not empty month}">
			<p>
				${month  + 1}月
				<c:choose>
					<c:when test="${term == 0 }">前半</c:when>
					<c:otherwise>後半</c:otherwise>
				</c:choose>
				でよろしいですか？
				<a href = "/shiftCollection/registerServlet">はい</a>
				<a href = "/shiftCollection/termServlet">やり直す</a>
			</p>
		</c:if>
	</div>
</body>
</html>