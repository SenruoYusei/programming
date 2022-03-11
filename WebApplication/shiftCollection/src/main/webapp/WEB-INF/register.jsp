<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%-- シフト日程の入力 --%>
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
		<!-- 
		dayPos = "${dayPos }"
		beginHour = "${beginHour }"
		beginMinute = "${beginMinute }"
		endHour = "${endHour }"
		endMinute = "${endMinute }"
		-->
		<c:set var = "tNum" value = "${member.termNum == 0 ? 0 : 15 }"/>
		<c:if test = "${not empty registerError }">
			<p>${registerError}</p>
		</c:if>
		<form action = "/shiftCollection/registerServlet" method = "post">
			<select name = "dayPos">
				<option ${dayPos == null ? "selected" : ""} value = "-1">なし
				<option ${dayPos == -1 ? "selected" : ""} value = "0">${tNum + 1 }
				<option ${dayPos == 0 ? "selected" : ""} value = "1">${tNum + 2 }
				<option ${dayPos == 1 ? "selected" : ""} value = "2">${tNum + 3 }
				<option ${dayPos == 2 ? "selected" : ""} value = "3">${tNum + 4 }
				<option ${dayPos == 3 ? "selected" : ""} value = "4">${tNum + 5 }
				<option ${dayPos == 4 ? "selected" : ""} value = "5">${tNum + 6 }
				<option ${dayPos == 5 ? "selected" : ""} value = "6">${tNum + 7 }
				<option ${dayPos == 6 ? "selected" : ""} value = "7">${tNum + 8 }
				<option ${dayPos == 7 ? "selected" : ""} value = "8">${tNum + 9 }
				<option ${dayPos == 8 ? "selected" : ""} value = "9">${tNum + 10 }
				<option ${dayPos == 9 ? "selected" : ""} value = "10">${tNum + 11 }
				<option ${dayPos == 10 ? "selected" : ""} value = "11">${tNum + 12 }
				<option ${dayPos == 11 ? "selected" : ""} value = "12">${tNum + 13 }
				<c:if test = "${member.dayNum > 13 }">
					<option ${dayPos == 12 ? "selected" : ""} value = "13">${tNum + 14 }
					<c:if test = "${member.dayNum > 14 }">
						<option ${dayPos == 13 ? "selected" : ""} value = "14">${tNum + 15 }
						<c:if test = "${member.dayNum > 15 }">
							<option ${dayPos == 14 ? "selected" : ""} value = "15">${tNum + 16 }
						</c:if>
					</c:if>
				</c:if>
			</select>
			日 : 
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
				<option ${beginHour == 20 ? "selected" : ""} value = "20">20
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
			<input type = "submit" value = "提出"><br>
			提出後の訂正は下記のリンクをクリックしてください．
		</form>
		<c:if test = "${not empty registerError }">
			<p>${registerError}</p>
		</c:if>
		<c:forEach begin="0" end="${member.dayNum - 1}" step="1" varStatus="status">
	
			<c:set var = "index" value = "${ status.index}"/>
			<c:set var = "info" value = "${member.getSchedule(index) }"/>
			<p>${member.getDay(index)} : ${info }</p><br>
		</c:forEach>
		<a href = "/shiftCollection/RegisterConfirmServlet">確認・修正</a><br>
		以上でよろしいですか？
			<a href = "/shiftCollection/registerOKServlet">はい</a><br>
			<a href = "/shiftCollection/termServlet">やり直す</a><br>
	</div>	
</body>
</html>