<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.dao.dto.StockRecordDTO" %>
<%@ page import="constant.Parameters" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>編集画面</title>
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
	    
	    //入力欄の操作時
	    $('form input:required').change(function () {
   	        //必須項目をひとつずつチェック
	        $('form input:required').each(function(e) {
		});
</script>
</head>
<%
StockRecordDTO stocklist = (StockRecordDTO)request.getAttribute("stocklist");
%>
<body>
<div class ="main">
	<p class="sign" align="center">在庫情報編集</p>
	<form action="update-servlet" method="post" >
	
	<div class =info_area>
		<label>品名：</label><input class="input_field" required type="text" name="<%=Parameters.NAME %>" value="<%=stocklist.getName()%>"><br>
	</div>		
	<div class =info_area>
		<label>個数：</label><input class="input_field" required type="number" min="0" name="<%=Parameters.NUMBER %>" value="<%=stocklist.getNumber()%>"><br>
	</div>		
	<div class =info_area>
		<label>メモ：</label><input class="input_field" type="text" name="<%=Parameters.MEMO %>" value="<%=stocklist.getMemo()%>"><br>
	</div>		
	<div class =info_area>	
		<label>確認日</label><input class="input_field" required type="date" name="<%=Parameters.UPDATE %>" value="<%=stocklist.getUpdate()%>"> <br>
	</div>
		<input type="hidden" name="<%=Parameters.STOCKRECORD_ID %>" value="<%=stocklist.getId() %>">
	<input class="insert_button" type="submit" value="在庫情報を更新する">
	</form>
	<form action="list-servlet">
		<input type="submit" value="一覧画面へ戻る" class="back_button" />
	</form>
</div>

</body>
</html>