package ru.netcracker.migalin.controller;
import ru.netcracker.migalin.DAO.PublisherDAO;
import ru.netcracker.migalin.DAO.PublisherDAOImpl;
import ru.netcracker.migalin.entity.PublishersEntity;
import ru.netcracker.migalin.util.Util;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


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
        PublisherDAO publisherDAO = new PublisherDAOImpl();
        String publisherId = request.getParameter("id");
        String fullName = request.getParameter("fullName");
        String url = request.getParameter("url");
        Util.checkInputParameter(fullName,url);
        PublishersEntity publishersEntity = new PublishersEntity(Integer.valueOf(publisherId),fullName,url);
        publisherDAO.editPublisher(publishersEntity);
        response.sendRedirect("/list");
    }

}

