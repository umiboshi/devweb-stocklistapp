<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="constant.SessionInfo"%>
    
<%@ page import="constant.Parameters" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>追加画面</title>
<link rel="stylesheet" type="text/css" href="css/insert.css">
</head>
<body>

<div class="main">
	<p class="sign" align="center">リスト追加</p>
	<form action="insert-servlet" method="post">
	<div class =info_area>
		<label>品名: </label><input class="input_field" type="text" name="<%=Parameters.NAME %>"><br>
	</div>
	<div class =info_area>
		<label>個数: </label><input class="input_field" type="number" name="<%=Parameters.NUMBER %>"><br>
	</div>
	<div class =info_area>
	<label>メモ: </label><input class="input_field" type="text" name="<%=Parameters.MEMO %>"><br>
	</div>
	<div class =info_area>
		<label>確認日: </label><input class="input_field" type="date" name="<%=Parameters.UPDATE %>"> <br>
	</div>
	<input class="insert_button" type="submit" value="在庫情報を登録する">
	</form>
	<form action="list-servlet">
		<input type="submit" value="一覧画面へ戻る" class="back_button" />
	</form>
</div>

</body>
</html>