package org.example.lab14;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "FormsServlet", value = "/forms")
public class FormsServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String imie = req.getParameter("imie");
        String nazwisko = req.getParameter("nazwisko");
        String email = req.getParameter("mail");

        HttpSession session = req.getSession();
        session.setAttribute("imie", imie);
        session.setAttribute("nazwisko", nazwisko);
        session.setAttribute("email", email);

        resp.sendRedirect("show-session.jsp");
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        doPost(req, resp);
    }
}
