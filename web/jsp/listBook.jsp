<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<c:url var="editImgUrl" value="/resources/img/edit.png"/>
<c:url var="deleteImgUrl" value="/resources/img/delete.png"/>
<c:url var="addImgUrl" value="/resources/img/add.png"/>
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
        <c:url var="editUrl" value="/editBook?id=${books.idbooks}"/>
        <c:url var="deleteUrl" value="/deleteBook?id=${books.idbooks}"/>

        <c:if test="${!empty books}">
            <tr>
                <td><c:out value="${books.idbooks}"/></td>
                <td><c:out value="${books.autor}"/></td>
                <td><c:out value="${books.title}"/></td>
                <td><c:out value="${books.year}"/></td>
                <td><a href="${editUrl}"><img src="${editImgUrl}"></img></a></td>
                <td><a href="${deleteUrl}"><img src="${deleteImgUrl}"></img></a></td>
                <td><c:out value="${books.publisher_id.fullname}"/></td>
                <td><c:out value="${books.publisher_id.url}"/></td>
                <c:url var="addCcUrl" value="/addBook?id=${books.idbooks}"/>
                <c:url var="editCcUrl" value="/editPublisher?pid=${books.publisher_id.idpublishers}"/>
                <c:url var="deleteCcUrl" value="/deletePublisher?pid=${books.publisher_id.idpublishers}"/>
                <td><c:if test="${!empty books.publisher_id}"><a href="${editCcUrl}"><img src="${editImgUrl}"></a></c:if></td>
                <td><c:if test="${!empty books.publisher_id}"><a href="${deleteCcUrl}"><img src="${deleteImgUrl}"></a></c:if></td>
            </tr>
        </c:if>
    </c:forEach>
    </tbody>
</table>
<c:if test="${empty books}">
    No records found.
</c:if>