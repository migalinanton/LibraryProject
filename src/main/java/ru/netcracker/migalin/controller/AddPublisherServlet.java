package ru.netcracker.migalin.controller;
import ru.netcracker.migalin.DAO.PublisherDAO;
import ru.netcracker.migalin.DAO.PublisherDAOImpl;
import ru.netcracker.migalin.entity.PublishersEntity;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet(urlPatterns = {"/addPublisher"})
public class AddPublisherServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        PublisherDAO publisherDAO = new PublisherDAOImpl();
        req.setAttribute("addPublisher", new PublishersEntity());
        req.getRequestDispatcher("/list").forward(req, resp);
    }
}

