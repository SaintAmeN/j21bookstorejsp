package com.j21.bookstore.servlet;

import com.j21.bookstore.model.*;

import javax.persistence.EntityNotFoundException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.management.BufferPoolMXBean;
import java.util.HashSet;

@WebServlet("/book/add")
public class BookAddServlet extends HttpServlet {
    private EntityDao dao = new EntityDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("authors", dao.findAll(Author.class));
        req.setAttribute("publishers", dao.findAll(Publisher.class));

        req.getRequestDispatcher("/book/form.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String title = req.getParameter("title");
        String yearPublished = req.getParameter("yearPublished");
        String pages = req.getParameter("pages"); //year of birth
        String bookType = req.getParameter("bookType"); // place of birth
        String authorId = req.getParameter("authorId"); // place of birth
        String publisherId = req.getParameter("publisherId"); // place of birth

        Book newBook = new Book(null,
                title,
                Integer.parseInt(yearPublished),
                BookType.valueOf(bookType.toUpperCase()),
                Integer.parseInt(pages),
                dao.findById(Publisher.class, Long.parseLong(publisherId)).orElseThrow(EntityNotFoundException::new),
                dao.findById(Author.class, Long.parseLong(authorId)).orElseThrow(EntityNotFoundException::new));

        dao.saveOrUpdate(newBook);

        // przekieruj z powrotem na formularz
        resp.sendRedirect("/book/list");
    }
}
