package ru.netcracker.migalin.controller;
import ru.netcracker.migalin.DAO.BookDAO;
import ru.netcracker.migalin.DAO.BookDAOImpl;
import ru.netcracker.migalin.DAO.PublisherDAO;
import ru.netcracker.migalin.DAO.PublisherDAOImpl;
import ru.netcracker.migalin.entity.BooksEntity;
import ru.netcracker.migalin.entity.PublishersEntity;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet(urlPatterns = {"/editBook"})
public class EditBookServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        BookDAO bookDAO = new BookDAOImpl();
        PublisherDAO publisherDAO = new PublisherDAOImpl();
        String id = req.getParameter("id");
        if (id != null) {
            BooksEntity bookById = bookDAO.getBookById(Integer.valueOf(id));
            req.setAttribute("editBook", bookById);
        }else {
            req.setAttribute("editBook", new BooksEntity());
        }
        List<PublishersEntity> allPublishers = publisherDAO.getAllPublishers();
        req.setAttribute("listPublishers",allPublishers);
        req.getRequestDispatcher("/list").forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        PublisherDAO publisherDAO = new PublisherDAOImpl();
        BookDAO bookDAO = new BookDAOImpl();
        PublishersEntity publishersEntity = null;
        String bookId = request.getParameter("id");
        String author = request.getParameter("author");
        String title = request.getParameter("title");
        String year = request.getParameter("year");
        String publisherId = request.getParameter("publisher");
        if (!publisherId.equals("null")) publishersEntity = publisherDAO.getPublisherById(Integer.valueOf(publisherId));
        BooksEntity booksEntity = new BooksEntity(Integer.valueOf(bookId),author,title,year,publishersEntity);
        bookDAO.editBook(booksEntity);
        response.sendRedirect("/list");
    }
}
