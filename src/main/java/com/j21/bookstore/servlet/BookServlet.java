package com.j21.bookstore.servlet;

import com.j21.bookstore.model.Author;
import com.j21.bookstore.model.Book;
import com.j21.bookstore.model.EntityDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/book/list")
public class BookServlet extends HttpServlet {
    private EntityDao dao = new EntityDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Book> books = dao.findAll(Book.class);

        req.setAttribute("items", books);
        req.getRequestDispatcher("/book/list.jsp").forward(req, resp);
    }
}
