<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="constant.Parameters" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>StockList-AddUser-</title>
<link rel="stylesheet" type="text/css" href="css/insert.css">
<script src="js/inputcheck.js"></script>
</head>
<body>
<!-- ログインフォーム。ユーザーIDとパスワードの入力を行う -->
<div class="main">
	<p class="sign" align="center">ユーザー追加</p>	
	<form class="form1" action="addUser-servlet" method="post">
		<input name="<%=Parameters.LOGIN_ID%>" class="un " type="text" placeholder="ユーザーID(半角英数字)" required>
		<input name="<%=Parameters.LOGIN_PASSWORD%>"  class="pass" type="password"  placeholder="Password" required>
		<input type="submit" value="ユーザーを追加" class="button"/>
	</form>
	<form action="login.jsp">
		<input type="submit" value="ログイン画面に戻る" class="button" />
	</form>
</div>
</body>
</html>