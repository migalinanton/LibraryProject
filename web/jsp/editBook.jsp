<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<c:url var="addImgUrl" value="/resources/img/add.png"/>
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
                                    <c:if test="${publisher.idpublishers==addBook.publisher_id.idpublishers&&(!empty addBook.publisher_id)}">selected</c:if>>
                                    ${publisher.fullname}</option>
                        </c:forEach>
                        <option value="null">Без издательства</option>
                    </select>
                </td>
            </tr>
        </table>
        <input type="submit" value="Save"/>
    </form>
</c:if>
