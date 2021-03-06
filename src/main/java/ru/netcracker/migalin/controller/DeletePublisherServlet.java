package ru.netcracker.migalin.controller;

import ru.netcracker.migalin.DAO.PublisherDAO;
import ru.netcracker.migalin.DAO.PublisherDAOImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/deletePublisher"})
public class DeletePublisherServlet extends HttpServlet{
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PublisherDAO publisherDAO = new PublisherDAOImpl();
        String publisherId = req.getParameter("pid");
        publisherDAO.deletePublisher(Integer.valueOf(publisherId));
        req.getRequestDispatcher("/list").forward(req, resp);
    }
}