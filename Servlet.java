<!DOCTYPE html>
<html>
<head>
    <title>Login Form</title>
</head>
<body>
    <h2>Login</h2>
    <form action="LoginServlet" method="post">
        Email: <input type="text" name="email"><br>
        <input type="hidden" name="hiddenField" value="ThisIsHiddenData">
        <input type="submit" value="Login">
    </form>
</body>
</html>


//LoginServlet.java
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class LoginServlet extends HttpServlet {
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        String email = req.getParameter("email");
        String hidden = req.getParameter("hiddenField");

        // Set session attribute
        HttpSession session = req.getSession();
        session.setAttribute("userEmail", email);

        // Set cookie
        Cookie cookie = new Cookie("userEmail", email);
        res.addCookie(cookie);

        out.println("<h3>Welcome, " + email + "</h3>");
        out.println("<form action='WelcomeServlet?source=urlRewrite&hiddenField=" + hidden + "' method='post'>");
        out.println("<input type='submit' value='Go to Welcome Page'>");
        out.println("</form>");
    }
}
//WelcomeServlet.java


import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class WelcomeServlet extends HttpServlet {
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        // From Session
        HttpSession session = req.getSession(false);
        String sessionEmail = (session != null) ? (String) session.getAttribute("userEmail") : "No Session Found";

        // From Cookie
        String cookieEmail = "Not Found";
        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals("userEmail")) {
                    cookieEmail = c.getValue();
                }
            }
        }

        // Hidden Field
        String hiddenField = req.getParameter("hiddenField");

        // URL Rewriting Info
        String urlSource = req.getParameter("source");

        out.println("<h2>Welcome Servlet</h2>");
        out.println("<p><strong>Email from Session:</strong> " + sessionEmail + "</p>");
        out.println("<p><strong>Email from Cookie:</strong> " + cookieEmail + "</p>");
        out.println("<p><strong>Hidden Field Data:</strong> " + hiddenField + "</p>");
        out.println("<p><strong>Accessed via:</strong> " + urlSource + "</p>");
    }
}
