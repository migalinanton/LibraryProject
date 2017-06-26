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

/**
 * Created by user on 26.06.2017.
 */
@WebServlet(urlPatterns = {"/deleteBook"})
public class DeleteBookServlet extends HttpServlet{
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BookDAO bookDAO = new BookDAOImpl();
        String id = req.getParameter("id");
        bookDAO.deleteBook(Integer.valueOf(id));
        req.getRequestDispatcher("/list").forward(req, resp);
    }
}
