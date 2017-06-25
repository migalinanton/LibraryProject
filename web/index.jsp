<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Библиотека</title>
</head>
<body>
<h1>Записи</h1>
<c:url var="editImgUrl" value="/resources/img/edit.png" />
<c:url var="deleteImgUrl" value="/resources/img/delete.png" />
<c:url var="addUrl" value="/resources/img/add.png" />
<table style="border: 1px solid; width: 100%; text-align:center">
    <thead style="background:#d3dce3">
    <tr>
        <th>Id</th>
        <th>Автор</th>
        <th>Название</th>
        <th>Год издания</th>
        <th colspan="2"></th>
        <th>Назавание</th>
        <th>URL</th>
        <th colspan="3"></th>
    </tr>
    </thead>
    <tbody style="background:#ccc">
    <c:forEach items="${persons}" var="person">
        <c:url var="editUrl" value="edit?id=${person.id}" />
        <c:url var="deleteUrl" value="delete?id=${person.id}" />

        <c:if test="${!empty person.creditCards}">
            <c:forEach items="${person.creditCards}" var="creditCard">
                <tr>
                    <td><c:out value="${person.id}" /></td>
                    <td><c:out value="${person.firstName}" /></td>
                    <td><c:out value="${person.lastName}" /></td>
                    <td><c:out value="${person.money}" /></td>
                    <td><a href="${editUrl}"><img src="${editImgUrl}"></img></a></td>
                    <td><a href="${deleteUrl}"><img src="${deleteImgUrl}"></img></a></td>

                    <td><c:out value="${creditCard.type}" /></td>
                    <td><c:out value="${creditCard.number}" /></td>
                    <c:url var="addCcUrl" value="add?id=${person.id}" />
                    <c:url var="editCcUrl" value="edit?pid=${person.id}&cid=${creditCard.id}" />
                    <c:url var="deleteCcUrl" value="delete?id=${creditCard.id}" />
                    <td><a href="${addCcUrl}">+</a></td>
                    <td><a href="${editCcUrl}"><img src="${editImgUrl}"></img></a></td>
                    <td><a href="${deleteCcUrl}"><img src="${deleteImgUrl}"></img></a></td>
                </tr>
            </c:forEach>
        </c:if>

        <c:if test="${empty person.creditCards}">
            <tr>
                <td><c:out value="${person.id}" /></td>
                <td><c:out value="${person.firstName}" /></td>
                <td><c:out value="${person.lastName}" /></td>
                <td><c:out value="${person.money}" /></td>
                <td><a href="${editUrl}"><img src="${editImgUrl}"></img></a></td>
                <td><a href="${deleteUrl}"><img src="${deleteImgUrl}"></img></a></td>

                <td>N/A</td>
                <td>N/A</td>
                <c:url var="addCcUrl" value="add?id=${person.id}" />
                <td><a href="${addCcUrl}">+</a></td>
                <td></td>
                <td></td>
            </tr>
        </c:if>

    </c:forEach>
    </tbody>
</table>

<c:if test="${empty persons}">
    No records found.
</c:if>

<p><a href="${addUrl}">Create new record</a></p>

</body>
</html>