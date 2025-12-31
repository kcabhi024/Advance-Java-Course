package Cookies;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/AddCookie")
public class AddCookie extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String firstName = request.getParameter("firstname");
        String lastName  = request.getParameter("lastname");

        Cookie c1 = new Cookie("FirstName", firstName);
        Cookie c2 = new Cookie("LastName", lastName);

        c1.setMaxAge(60 * 60); // 1 hour
        c2.setMaxAge(60 * 60);

        response.addCookie(c1);
        response.addCookie(c2);

        out.println("<html><body>");
        out.println("<h2>Cookies Added Successfully</h2>");
        out.println("First Name: " + firstName + "<br>");
        out.println("Last Name: " + lastName + "<br><br>");
        out.println("<a href='GetCookie'>View Cookies</a>");
        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}
