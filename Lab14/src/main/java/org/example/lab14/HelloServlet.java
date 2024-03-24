package org.example.lab14;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        String par1 = request.getParameter("par1");
        String par2 = request.getParameter("par2");

        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("<p>Parametr 1: " + par1 + "</p>");
        out.println("<p>Parametr 2: " + par2 + "</p>");
        out.println("<br/>");
        out.println("<a href=\"new-servlet\">New Servlet</a>");
        out.println("<br/>");
        out.println("<a href=\"newPage.jsp\">New JSP Page</a>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}
