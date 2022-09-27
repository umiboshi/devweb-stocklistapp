<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
	<meta charset="UTF-8">
	<title>StockList-TOP-</title>
	<link rel="stylesheet" href="css/home.css">
</head>
<body>

	<div class="main">
		<h1 class="sign" align="center">在庫管理Webアプリ</h1>
		
		<form action="list-servlet" method="get" >
			<input type="submit" id="submit" value="在庫一覧を表示" class="submit" />
		</form>
		
		<h2 class="memo">メモ</h2>
	
		<div class="memo_area">
			<p>・日用品などの在庫を管理するためのWebアプリです。</p>
			<p>・品名、個数、メモ、確認日を記入できます。</p>
			<p>・メモ欄にはよく購入する店名や、その値段などちょっとしたメモが記載可能です。</p>
		</div>
		
	</div>

</body>
</html>