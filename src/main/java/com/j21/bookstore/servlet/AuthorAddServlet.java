package com.j21.bookstore.servlet;

import com.j21.bookstore.model.Author;
import com.j21.bookstore.model.EntityDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashSet;

@WebServlet("/author/add")
public class AuthorAddServlet extends HttpServlet {
    private EntityDao dao = new EntityDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/author/form.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String yob = req.getParameter("yob"); //year of birth
        String pob = req.getParameter("pob"); // place of birth

        Author newAuthor = new Author(null, name, surname, Integer.parseInt(yob), pob, new HashSet<>());

        dao.saveOrUpdate(newAuthor);

        // przekieruj z powrotem na formularz
        resp.sendRedirect("/author/add");
    }
}
