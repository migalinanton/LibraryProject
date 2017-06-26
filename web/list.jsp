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
<br>
<a href="/list"><h1>Каталог книг</h1></a>
<c:url var="editImgUrl" value="/resources/img/edit.png" />
<c:url var="deleteImgUrl" value="/resources/img/delete.png" />
<c:url var="addImgUrl" value="/resources/img/add.png" />
<form action = "/findBook" method = "POST">
    <p><input type="search" name="text" placeholder="Поиск книг">
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
    <input type="submit" value="Save" />
</form>
</c:if>

<p><a href="/addPublisher"><img src="${addImgUrl}"> Create new publisher</a></p>
<c:if test="${!empty addPublisher}">
<c:url var="saveUrl" value="addPublisher?id=${personId}" />
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
    <input type="submit" value="Save" />
</form>
</c:if>
</br>
<table style="border: 1px solid; width: 100%; text-align:center">
    <thead style="background:#bdc6cd">
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
    <tbody style="background:#e6e6e6">
    <c:forEach items="${books}" var="books">
        <c:url var="editUrl" value="/editBook?id=${books.idbooks}" />
        <c:url var="deleteUrl" value="?id=${books.idbooks}" />

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
                    <c:url var="editCcUrl" value="/editPublisher?pid=${books.publisher_id.idpublishers}" />
                    <c:url var="deleteCcUrl" value="?id=${books.publisher_id.idpublishers}" />
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