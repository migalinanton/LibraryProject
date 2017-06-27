package ru.netcracker.migalin.controller;
import ru.netcracker.migalin.DAO.PublisherDAOImpl;
import ru.netcracker.migalin.entity.BooksEntity;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet(urlPatterns = {"/findBook"})
public class FindBookServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String textToSearch = request.getParameter("text");
        PublisherDAOImpl publisherDAO = new PublisherDAOImpl();
        List<BooksEntity> booksEntities = publisherDAO.searchBooks(textToSearch);
        request.setAttribute("books", booksEntities);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}