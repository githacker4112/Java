<!DOCTYPE html>
<html>
<head>
    <title>Login Form</title>
</head>
<body>
    <h2>Login</h2>
    <form action="process.jsp" method="post">
        Email: <input type="text" name="email"><br>
        <input type="hidden" name="hiddenField" value="ThisIsHiddenData">
        <input type="submit" value="Login">
    </form>
</body>
</html>


  //Progress.jsp

  <%@ page import="javax.servlet.http.Cookie" %>
<%@ page session="true" %>
<%
    String email = request.getParameter("email");
    String hidden = request.getParameter("hiddenField");

    // Set session
    session.setAttribute("userEmail", email);

    // Set cookie
    Cookie c = new Cookie("userEmail", email);
    response.addCookie(c);
%>

<h3>Welcome, <%= email %></h3>

<!-- Forwarding via URL Rewriting + Hidden field -->
<form action="welcome.jsp?source=urlRewrite&hiddenField=<%= hidden %>" method="post">
    <input type="submit" value="Go to Welcome Page">
</form>

  //welcome.jsp
  <%@ page import="javax.servlet.http.Cookie" %>
<%@ page session="true" %>
<%
    // From session
    String sessionEmail = (String) session.getAttribute("userEmail");

    // From cookies
    String cookieEmail = "Not Found";
    Cookie[] cookies = request.getCookies();
    if (cookies != null) {
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("userEmail")) {
                cookieEmail = cookie.getValue();
                break;
            }
        }
    }

    // From hidden field and URL rewriting
    String hiddenField = request.getParameter("hiddenField");
    String urlSource = request.getParameter("source");
%>

<h2>Welcome JSP Page</h2>
<p><strong>Email from Session:</strong> <%= sessionEmail %></p>
<p><strong>Email from Cookie:</strong> <%= cookieEmail %></p>
<p><strong>Hidden Field Data:</strong> <%= hiddenField %></p>
<p><strong>Accessed via:</strong> <%= urlSource %></p>




  //
