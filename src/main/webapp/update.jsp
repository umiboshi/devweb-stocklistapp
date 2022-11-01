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
<script src="js/inputcheck.js"></script>
</head>
<%
StockRecordDTO stocklist = (StockRecordDTO)request.getAttribute("stocklist");
%>
<body>
<div class ="main">
	<p class="sign" align="center">在庫情報編集</p>
	<form action="update-servlet" method="post" >
	
	<div class =info_area>
		<label>品名：</label><input class="input_field" type="text" name="<%=Parameters.NAME %>" value="<%=stocklist.getName()%>" required><br>
	</div>		
	<div class =info_area>
		<label>個数：</label><input class="input_field" type="number" min="0" name="<%=Parameters.NUMBER %>" value="<%=stocklist.getNumber()%>" required><br>
	</div>		
	<div class =info_area>
		<label>メモ：</label><input class="input_field" type="text" name="<%=Parameters.MEMO %>" value="<%=stocklist.getMemo()%>"><br>
	</div>		
	<div class =info_area>	
		<label>確認日</label><input class="input_field" type="date" name="<%=Parameters.UPDATE %>" value="<%=stocklist.getUpdate()%>" required> <br>
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