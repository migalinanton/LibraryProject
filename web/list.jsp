<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link type="text/css" rel="stylesheet" href="<c:url value="css/style.css" />" />
    <title>Библиотека</title>
</head>
<body>
<h1>Каталог книг</h1>
<c:url var="editImgUrl" value="/resources/img/edit.png" />
<c:url var="deleteImgUrl" value="/resources/img/delete.png" />
<form>
    <p><input type="search" name="text" placeholder="Поиск книг">
        <input type="submit" value="Найти"></p>
</form>
<p><a href="/add-book.jsp">Create new book</a></p>
<p><a href="/add-publisher.jsp">Create new publisher</a></p>
<table style="border: 1px solid; width: 100%; text-align:center">
    <thead style="background:#d3dce3">
    <tr>
        <th>Id</th>
        <th>Автор</th>
        <th>Название книги</th>
        <th>Год</th>
        <th colspan="2"></th>
        <th>Название издательства</th>
        <th>URL</th>
        <th colspan="3"></th>
    </tr>
    </thead>
    <tbody style="background:#ccc">
    <c:forEach items="${books}" var="books">
        <c:url var="editUrl" value="/edit?id=${books.idbooks}" />
        <c:url var="deleteUrl" value="delete?id=${books.idbooks}" />

        <c:if test="${!empty books.publisher_id}">
                <tr>
                    <td><c:out value="${books.idbooks}" /></td>
                    <td><c:out value="${books.autor}" /></td>
                    <td><c:out value="${books.title}" /></td>
                    <td><c:out value="${books.year}" /></td>
                    <td><a href="${editUrl}"><img src="${editImgUrl}"></img></a></td>
                    <td><a href="${deleteUrl}"><img src="${deleteImgUrl}"></img></a></td>

                    <td><c:out value="${books.publisher_id.fullname}" /></td>
                    <td><c:out value="${books.publisher_id.url}" /></td>
                    <c:url var="addCcUrl" value="/addBook?id=${books.idbooks}" />
                    <c:url var="editCcUrl" value="edit?pid=${books.idbooks}&cid=${books.publisher_id.idpublishers}" />
                    <c:url var="deleteCcUrl" value="delete?id=${books.publisher_id.idpublishers}" />
                    <td><a href="${editCcUrl}"><img src="${editImgUrl}"></img></a></td>
                    <td><a href="${deleteCcUrl}"><img src="${deleteImgUrl}"></img></a></td>
                </tr>
        </c:if>

    </c:forEach>
    </tbody>
</table>

<c:if test="${empty books}">
    No records found.
</c:if>



</body>
</html>