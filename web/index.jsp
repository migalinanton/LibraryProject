<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<br>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link type="text/css" rel="stylesheet" href="<c:url value="css/style.css" />"/>
    <title>Библиотека</title>
</head>
<% String message = (String)request.getAttribute("message");%>
<script type="text/javascript">
    var msg = "<%=message%>";
    if (msg!="null") {
        alert(msg);
    }
</script>

<a href="/list"><h1>Каталог книг</h1></a>

<form action="/findBook" method="POST">
    <p><input style="width: 200px" type="search" name="text" placeholder="Поиск книг по издательтву">
        <input type="submit" value="Найти"></p>
</form>

<jsp:include page="jsp/editBook.jsp" />
<jsp:include page="jsp/editPublisher.jsp"/>
<br>
<jsp:include page="jsp/listBook.jsp" />

</body>
</html>