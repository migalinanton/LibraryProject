<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isErrorPage="true" %>
<html>
<head>
    <title>Ошибка</title>
</head>
<body>
<%=exception.getMessage()%>
<% exception.printStackTrace(response.getWriter()); %>
</body>
</html>