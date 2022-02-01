<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
		<form action = "/shiftCollection/LoginServlet" method = "post">
			ユーザー名 : <input type = "text" name = "userName"><br>
			パスワード : <input type = "password" name = "pass"><br>
			<input type = "submit" value = "ログイン">
		</form>
	</div>
</body>
</html>