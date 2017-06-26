<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link type="text/css" rel="stylesheet" href="<c:url value="css/style.css" />"/>
    <title>Библиотека</title>
</head>
<br>
<a href="/list"><h1>Каталог книг</h1></a>

<form action="/findBook" method="POST">
    <p><input style="width: 200px" type="search" name="text" placeholder="Поиск книг по издательтву">
        <input type="submit" value="Найти"></p>
</form>
<p><a href="/addBook"><img src="${addImgUrl}"> Create new book</a></p>
<c:url var="saveUrl" value="/addBook"/>
<c:if test="${!empty addBook}">
    <form modelAttribute="personAttribute" method="POST" action="${saveUrl}">
        <table>
            <tr>
                <td><label path="id">Id:</label></td>
                <td><input path="id" disabled="true" value="${addBook.idbooks}"/></td>
            </tr>
            <tr>
                <td><label path="author">Автор:</label></td>
                <td><input name="author" value="${addBook.autor}"/></td>
            </tr>
            <tr>
                <td><label path="title">Название:</label></td>
                <td><input name="title" value="${addBook.title}"/></td>
            </tr>
            <tr>
                <td><label path="year">Год:</label></td>
                <td><input name="year" value="${addBook.year}"/></td>
            </tr>
            <tr>
                <td><label path="publisher">Издательство:</label></td>
                <td>
                    <select name="publishers">
                        <c:forEach items="${listPublishers}" var="publisher">
                            <option value="${publisher.idpublishers}"
                                    <c:if test="${publisher.idpublishers==addBook.publisher_id.idpublishers}">selected</c:if>>
                                    ${publisher.fullname}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
        </table>
        <input type="submit" value="Save"/>
    </form>
</c:if>

<p><a href="/addPublisher"><img src="${addImgUrl}"> Create new publisher</a></p>
<c:if test="${!empty addPublisher}">
    <c:url var="saveUrl" value="addPublisher?id=${personId}"/>
    <form modelAttribute="creditCardAttribute" method="POST" action="${saveUrl}">
        <table>
            <tr>
                <td>Id:</td>
                <td><input type="text" value="${addPublisher.idpublishers}" disabled="true"/>
            </tr>
            <tr>
                <td><label path="type">Название:</label></td>
                <td><input path="type" value="${addPublisher.fullname}"/></td>
            </tr>
            <tr>
                <td><label path="number">URL:</label></td>
                <td><input path="number" value="${addPublisher.url}"/></td>
            </tr>
        </table>
        <input type="submit" value="Save"/>
    </form>
</c:if>
</br>
<jsp:include page="new.jsp" />
</body>
</html>