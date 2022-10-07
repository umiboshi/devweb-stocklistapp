<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="constant.SessionInfo"%>
<%@ page import="constant.Parameters" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Content-Security-Policy" content="default-src 'self'">
<title>追加画面</title>
<link rel="stylesheet" type="text/css" href="css/insert.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script>
	$(function(){
	  $('#stock_num').on('mouseup keyup', function(e){
	    var stockNum = parseInt($(this).val());
	    var stockNumMin = parseInt($(this).attr('min'));
	    if(stockNum < stockNumMin ){ $(this).val(stockNumMin); }
	    if(isNaN(stockNum)){ $(this).val('1'); }
	  });
	});
</script>
</head>
<body>
<div class="main">
	<p class="sign" align="center">リスト追加</p>
	<form action="insert-servlet" method="post">
	<div class =info_area>
		<label>品名: </label><input class="input_field" type="text" name="<%=Parameters.NAME %>"><br>
	</div>
	<div class =info_area>
		<label>個数: </label><input class="input_field" id="stock_num" type="number" min="0" name="<%=Parameters.NUMBER %>"><br>
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