<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix = "fn" uri = "http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name = "viewport" content = "width=device-width,user-scalable=no,maximum-scale=1"/>
<title>シフト確認</title>
<link rel = "stylesheet" type = "text/css" href = "/shiftCollection/css/test.css">
</head>
<body>
	<div>
		<h1>シフト確認</h1>
		<form action = "/shiftCollection/ViewShift" method = "post">
			対象期間 : <select name = "month">
				<option value = "-1" selected>なし
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
			<input type = "radio" name = "term" value = 0 checked = "checked">前半
			<input type = "radio" name = "term" value = 1>後半<br>
			<input type = "submit" name = "決定">
		</form>
		
		<c:forEach begin = "0" end = "${fn:length(output)}" step = "1" varStatus = "status">
			<c:set var = "day" value = "${status.index }"/>
			<p>${output[day]}</p><br>
		</c:forEach>
		<a href = "/shiftCollection/Output">ファイルの出力</a>
	</div>
</body>
</html>