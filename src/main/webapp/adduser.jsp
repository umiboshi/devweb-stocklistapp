<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="constant.Parameters" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>StockList-AddUser-</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/login.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script>
	$(function(){
	    //入力欄の操作時
	    $('form input:required').change(function () {
   	        //必須項目をひとつずつチェック
	        $('form input:required').each(function(e) {
		});
</script>
</head>
<body>
<!-- ログインフォーム。ユーザーIDとパスワードの入力を行う -->
<div class="main">
	<p class="sign" align="center">ユーザー追加</p>	
	<form class="form1" action="addUser-servlet" method="post">
		<input name="<%=Parameters.LOGIN_ID%>" class="un " required type="text" placeholder="ユーザーID(半角英数字)">
		<input name="<%=Parameters.LOGIN_PASSWORD%>"  class="pass" required type="password"  placeholder="Password">
		<input type="submit" value="ユーザーを追加" class="button"/>
	</form>
	<form action="login.jsp">
		<input type="submit" value="ログイン画面に戻る" class="button" />
	</form>
</div>
</body>
</html>