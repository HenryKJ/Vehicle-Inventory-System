import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import com.sun.net.httpserver.HttpServer;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class LoginServlet extends HttpServlet {
@Override
protected void doGet( HttpServletRequest request, HttpServletResponse response )
throws ServletException,IOException
{
response.setContentType("text/html");
response.setStatus(HttpServletResponse.SC_OK);
PrintWriter out = response.getWriter();
out.println("<html><body>");
out.println("<h1>Log in </h1>");
out.println("<form action=\"Login\" method=\"post\" >");
out.println("Enter username: <input type=\"text\" name=\"username\"> <br>");
out.println(" Enter password: <input type=\"password\" name=\"password\"><br>");
out.println("<input type=\"submit\" value=\"Login\">");
out.println("</form>");
out.println("</body></html>");
}
protected void doPost(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {
String uname = request.getParameter("username");
String password = request.getParameter("password");
PrintWriter out = response.getWriter();
if (uname.equals("admin")&& password.equals("kings123"))
{
//Dashboard
out.println("<html><body>");
out.println("<h1>Dashboard </h1>");
out.println("<h1>This is page is the dashboard page </h1>");
out.println("<form action=\"LogoutServlet\" >");
out.println("<input type=\"submit\" value=\"Logout\"/>");
out.println("</form>");
out.println("</body></html>");
}
else {
doGet(request, response);
}
}
}
