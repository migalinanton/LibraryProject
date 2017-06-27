package ru.netcracker.migalin.controller;

import ru.netcracker.migalin.DAO.BookDAO;
import ru.netcracker.migalin.DAO.BookDAOImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/deleteBook"})
public class DeleteBookServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            BookDAO bookDAO = new BookDAOImpl();
            String id = req.getParameter("id");
            bookDAO.deleteBook(Integer.valueOf(id));
            req.setAttribute("message", "Book deleted success");
            req.getRequestDispatcher("/list").forward(req, resp);
        } catch (Exception e) {
            req.setAttribute("message", "Exception: " + e.getMessage());
            req.getRequestDispatcher("/list").forward(req, resp);
        }
    }
}
