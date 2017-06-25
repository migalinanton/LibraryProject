package ru.netcracker.migalin.controller;

import ru.netcracker.migalin.DAO.BookDAOImpl;
import ru.netcracker.migalin.entity.BooksEntity;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;


@WebServlet(name = "RegisterServlet", urlPatterns = {"/list"})
public class UserControllerServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		BookDAOImpl bookDAO = new BookDAOImpl();
        List<BooksEntity> allBooks = bookDAO.getAllBooks();
        req.setAttribute("books",allBooks);
        req.getRequestDispatcher("index.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest request,
						  HttpServletResponse response) throws ServletException, IOException {
        String queryString = request.getParameter("data");

    }
}
