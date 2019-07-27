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

@WebServlet("/author/list")
public class AuthorServlet extends HttpServlet {
    private EntityDao dao = new EntityDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Author> authors = dao.findAll(Author.class);

        req.setAttribute("items", authors);
        req.getRequestDispatcher("/author/list.jsp").forward(req, resp);
    }
}
