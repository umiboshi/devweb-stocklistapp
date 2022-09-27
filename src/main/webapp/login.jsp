<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="constant.Parameters" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>StockList-login-</title>
<link rel="stylesheet" type="text/css" href="css/login.css">

</head>
<body>
<!-- ログインフォーム。ユーザーIDとパスワードの入力を行う -->
<div class="main">
	<p class="sign" align="center">Login</p>
	<form class="form1" action="LoginServlet" method="post">
		<input name="<%=Parameters.LOGIN_ID%>" class="un " type="text" placeholder="ユーザーID(半角英数字)">
		<input name="<%=Parameters.LOGIN_PASSWORD%>"  class="pass" type="password" placeholder="Password">
		<input type="submit" id="login" value="ログイン" class="button" />
	</form>
	
	<form action="adduser.jsp">
		<input type="submit" value="新規ユーザー追加" class="button" />
	</form>
	<form action="index.html">
		<input type="submit" value="ホームへ戻る" class="button" />
	</form>
</div>
</body>
</html>