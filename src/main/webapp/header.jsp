<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="constant.SessionInfo" %>
<head>
<meta charset="UTF-8">
</head>
<body>
<nav class="navbar">
  <div class="container-fluid">
    <a class="navbar-brand" href="list-servlet">在庫管理アプリ</a>
    <span class="navbar-text">
    	<%=session.getAttribute(SessionInfo.LOGIN_USER_ID) %>
	    <a class="logout-button" href="LogoutServlet">ログアウト</a>
    </span>
  </div>
</nav>
</body>
</html>

