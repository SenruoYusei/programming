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
		<c:set var = "index" value = "${deletePos  + 1}"/>
		<h1>シフト修正画面</h1>
		<p><c:out value = "${member.name }"/>さんログイン中</p>
		<a href = "/shiftCollection/Logout">ログアウト</a>
		<p>${month + 1 }月
		<c:choose>
			<c:when test = "${term == 0 }">前半</c:when>
			<c:otherwise>後半</c:otherwise>
		</c:choose><br>
		変更前<br>
		<p>${member.getDay(index)} : ${member.getSchedule(index)}</p>
		
		修正後<br>
		<form action = "/shiftCollection/Modify" method = "post">
			${member.getDay(index)}
			<input type = "hidden" name = "ModifyPos" value = "${index}">
			<select name = "beginHour">
				<option ${beginHour == 8 ? "selected" : ""} value = "8">8
				<option ${beginHour == 9 ? "selected" : ""} value = "9">9
				<option ${beginHour == 10 ? "selected" : ""} value = "10">10
				<option ${beginHour == 11 ? "selected" : ""} value = "11">11
				<option ${beginHour == 12 ? "selected" : ""} value = "12">12
				<option ${beginHour == 13 ? "selected" : ""} value = "13">13
				<option ${beginHour == 14 ? "selected" : ""} value = "14">14
				<option ${beginHour == 15 ? "selected" : ""} value = "15">15
				<option ${beginHour == 16 ? "selected" : ""} value = "16">16
				<option ${beginHour == 17 ? "selected" : ""} value = "17">17
				<option ${beginHour == 18 ? "selected" : ""} value = "18">18
				<option ${beginHour == 19 ? "selected" : ""} value = "19">19
				<option ${beginHourH == 20 ? "selected" : ""} value = "20">20
				<option ${beginHour == 21 ? "selected" : ""} value = "21">21
				<option ${beginHour == 22 ? "selected" : ""} value = "22">22
			</select> : 
			<select name = "beginMinute">
				<option ${beginMinute == 00 ? "selected" : ""} value = "00">00
				<option ${beginMinute == 15 ? "selected" : ""} value = "15">15
				<option ${beginMinute == 30 ? "selected" : ""} value = "30">30
			</select> ~
			<select name = "endHour">
				<option ${endHour == 8 ? "selected" : ""} value = "8">8
				<option ${endHour == 9 ? "selected" : ""} value = "9">9
				<option ${endHour == 10 ? "selected" : ""} value = "10">10
				<option ${endHour == 11 ? "selected" : ""} value = "11">11
				<option ${endHour == 12 ? "selected" : ""} value = "12">12
				<option ${endHour == 13 ? "selected" : ""} value = "13">13
				<option ${endHour == 14 ? "selected" : ""} value = "14">14
				<option ${endHour == 15 ? "selected" : ""} value = "15">15
				<option ${endHour == 16 ? "selected" : ""} value = "16">16
				<option ${endHour == 17 ? "selected" : ""} value = "17">17
				<option ${endHour == 18 ? "selected" : ""} value = "18">18
				<option ${endHour == 19 ? "selected" : ""} value = "19">19
				<option ${endHour == 20 ? "selected" : ""} value = "20">20
				<option ${endHour == 21 ? "selected" : ""} value = "21">21
				<option ${endHour == 22 ? "selected" : ""} value = "22">22
			</select> : 
			<select name = "endMinute">
				<option ${endMinute == 00 ? "selected" : ""} value = "00">00
				<option ${endMinute == 15 ? "selected" : ""} value = "15">15
				<option ${endMinute == 30 ? "selected" : ""} value = "30">30
			</select>
			備考欄 : <input type = "text" name = "memo">
			<input type = "submit" value = "修正"><br>
		</form>
		変更後 : <p>${member.getDay(index)} :${member.getSchedule(index)} </p>
		以上でよろしいですか？
		<a href = "/shiftCollection/RegisterConfirmServlet">はい</a>
		<a href = "/shiftCollection/Modify">やり直す</a><br>
	</div>
</body>
</html>