<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 19.06.2017
  Time: 17:59
  To change this template use File | Settings | File Templates.
--%>
<%@page import="java.util.List"%>
<%@page import="java.util.Date"%>
<%@page import="ru.netcracker.migalin.DAO.BookDAOImpl"%>
<%@ page import="ru.netcracker.migalin.entity.BooksEntity" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <link rel="stylesheet" type="text/css" href="css/style.css"/>
  <title>Библиотека</title>
</head>
<body>
  <div id="container">
      <form id="data" action="query" method="post">
          <p><input placeholder="Текст для поиска" name="search">
              <button type="submit" form="data" value="search">Искать</button></p>
          <button type="submit" form="data" value="add">Добавить</button>
          <button type="submit" form="data" value="delete">Удалить</button>
          <button type="submit" form="data" value="update">Изменить</button>
      </form>
      <h2>Список книг</h2>
    <table>
      <thead>
      <tr>
        <th>Автор</th>
        <th>Название</th>
        <th>Год</th>
        <th>Издательство</th>
        <th>URL Издательства</th>
      </tr>
      </thead>
      <tbody>
        <%
            BookDAOImpl bookDAO = new BookDAOImpl();
            List<BooksEntity> list = bookDAO.getAllBooks();
            for (BooksEntity booksEntity : list) {
                 %>
      <tr>
        <td><%=booksEntity.getAutor()%></td>
        <td><%=booksEntity.getTitle()%></td>
        <td><%=booksEntity.getYear()%></td>
        <td><%=booksEntity.getPublisher_id().getFullname()%></td>
          <td><%=booksEntity.getPublisher_id().getUrl()%></td>
      </tr>
        <%}%>
      <tbody>
    </table>
    <br/>
  </div>
</body>
</html>