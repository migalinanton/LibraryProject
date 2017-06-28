<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<c:url var="addImgUrl" value="/resources/img/add.png"/>
<p><a href="/editBook"><img src="${addImgUrl}"> Create new book</a></p>
<c:url var="saveUrl" value="/editBook"/>
<c:if test="${!empty editBook}">
    <form modelAttribute="personAttribute" method="POST" action="${saveUrl}">
        <input type="hidden" name="id" value="${editBook.idbooks}" />
        <table>
            <tr>
                <td><label path="author">Автор:</label></td>
                <td><input name="author" value="${editBook.autor}"/></td>
            </tr>
            <tr>
                <td><label path="title">Название:</label></td>
                <td><input name="title" value="${editBook.title}"/></td>
            </tr>
            <tr>
                <td><label path="year">Год:</label></td>
                <td><input name="year" value="${editBook.year}"/></td>
            </tr>
            <tr>
                <td><label path="publisher">Издательство:</label></td>
                <td>
                    <select name="publisher">
                        <c:forEach items="${listPublishers}" var="publisher">
                            <option value="${publisher.idpublishers}"
                                    <c:if test="${publisher.idpublishers==editBook.publisher_id.idpublishers&&(!empty addBook.publisher_id)}">selected</c:if>>
                                    ${publisher.fullname}</option>
                        </c:forEach>
                        <option value="null" <c:if test="${empty publisher.idpublishers}">selected</c:if>>Без издательства</option>
                    </select>
                </td>
            </tr>
        </table>
        <input type="submit" value="Save"/>
    </form>
</c:if>
