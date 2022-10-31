<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.List, java.util.ArrayList, model.dao.dto.StockRecordDTO"%>
    
<%@ page import="constant.Parameters" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>StockList</title>
<link rel="stylesheet" type="text/css" href="css/list.css">
</head>
<body>
	<%@ include file='header.jsp' %>
	<%
		List<StockRecordDTO> stockList = (List)request.getAttribute("stockList");
	%>
	
	<div class = "main_area">
	
	<table>
	 	<tr>
	   	<th>品名</th>
	   	<th>個数</th>
	   	<th>メモ</th>
	   	<th>確認日</th>
	   	<th></th>
	   	<th></th>
	</tr>
	<% for(StockRecordDTO stocklist: stockList){  %>
	    <tr>
		<td class = "info_area"><%=stocklist.getName()%></td>
		<td class = "info_area"><%=stocklist.getNumber()%></td>
		<td class = "info_area"><%=stocklist.getMemo()%></td>
		<td class = "info_area"><%=stocklist.getUpdate()%></td>
		<td class = "button_area"><a class="button" href="update-servlet?<%=Parameters.STOCKRECORD_ID %>=<%= stocklist.getId() %>">編集</a></td>
		<td class = "button_area"><a class="button" href="delete-servlet?<%=Parameters.STOCKRECORD_ID %>=<%= stocklist.getId() %>">削除</a></td>
		</tr>
	<% } %>
	</table>
	
	<a class="add-button" href="insert.jsp">在庫情報を追加する</a>	
	</div>

</body>
</html>