<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>

<h1>Add New Credit Card</h1>
<c:url var="saveUrl" value="addPublisher?id=${personId}" />
<form modelAttribute="creditCardAttribute" method="POST" action="${saveUrl}">
    <table>
        <tr>
            <td>Person Id:</td>
            <td><input type="text" value="${personId}" disabled="true"/>
        </tr>

        <tr>
            <td><label path="type">Type:</label></td>
            <td><input path="type"/></td>
        </tr>

        <tr>
            <td><label path="number">Number:</label></td>
            <td><input path="number"/></td>
        </tr>
    </table>

    <input type="submit" value="Save" />
</form>

</body>
</html>