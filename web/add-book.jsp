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

<h1>Create New Record</h1>
<c:url var="saveUrl" value="/addBook" />
<form modelAttribute="personAttribute" method="POST" action="${saveUrl}">
    <table>
        <tr>
            <td><label path="firstName">First Name:</label></td>
            <td><input name="firstName"/></td>
        </tr>

        <tr>
            <td><label path="lastName">Last Name</label></td>
            <td><input name="lastName"/></td>
        </tr>

        <tr>
            <td><label path="money">Money</label></td>
            <td><input name="money"/></td>
        </tr>
    </table>

    <input type="submit" value="Save" />
</form>

</body>
</html>