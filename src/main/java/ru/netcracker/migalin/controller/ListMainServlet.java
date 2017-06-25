package ru.netcracker.migalin.controller;

import ru.netcracker.migalin.DAO.BookDAOImpl;
import ru.netcracker.migalin.entity.BooksEntity;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.UUID;


@WebServlet(urlPatterns = {"/list"})
public class ListMainServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		BookDAOImpl bookDAO = new BookDAOImpl();
        List<BooksEntity> allBooks = bookDAO.getAllBooks();
		String myObjectId = UUID.randomUUID().toString();
		req.getSession().setAttribute(myObjectId, allBooks);
		req.setAttribute("books", allBooks);
		req.getRequestDispatcher("list.jsp").forward(req, resp);
	}

}