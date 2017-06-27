<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<form action="/findBook" method="POST">
    <p><input style="width: 200px" type="search" name="text" placeholder="Поиск книг по издательтву">
        <input type="submit" value="Найти"></p>
</form>