package ru.netcracker.migalin.controller;
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


@WebServlet(urlPatterns = {"/editPublisher"})
public class EditPublisherServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        PublisherDAO publisherDAO = new PublisherDAOImpl();
        String publisherId = req.getParameter("pid");
        PublishersEntity publisherById;
        if (publisherId != null) {
            publisherById = publisherDAO.getPublisherById(Integer.valueOf(publisherId));
        } else {
            publisherById = new PublishersEntity();
        }
        req.setAttribute("editPublisher", publisherById);
        req.getRequestDispatcher("/list").forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String textToSearch = request.getParameter("text");
        System.out.println();
        PublisherDAOImpl publisherDAO = new PublisherDAOImpl();
        List<BooksEntity> booksEntities = publisherDAO.searchBooks(textToSearch);
        request.setAttribute("books", booksEntities);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}

