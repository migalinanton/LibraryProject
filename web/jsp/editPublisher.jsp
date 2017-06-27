<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<c:url var="addImgUrl" value="/resources/img/add.png"/>
<p><a href="/addPublisher"><img src="${addImgUrl}"> Create new publisher</a></p>
<c:if test="${!empty addPublisher}">
    <c:url var="saveUrl" value="editPublisher?id=${personId}"/>
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