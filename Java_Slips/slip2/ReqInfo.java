import java.io.*;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class  ReqInfo extends HttpServlet
{
 
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException
   {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String[] Sname = getServletContext().getServletRegistrations().keySet().toArray(new String[0]);
        
        out.println("<html>");
        out.println("<head>Servlet Program</head>");
        out.println("<body>");
        out.println("<h1>Client Information</h1>");
        out.println("<p>IP Address :"+request.getRemoteAddr()+"</p>");
        out.println("<p>Browser Type :"+request.getHeader("User-Agent")+"</p>");
        out.println("<h1>Server Information</h1>");
        out.println("<p>Server OS :"+System.getProperty("os.name")+"</p>");
        out.println("<p>Server Information :"+getServletContext().getServerInfo()+"</p>");
        out.println("<h2>Loaded Servlet</h2>");
        out.println("<ul>");
        for (String sname : Sname)
        {
        	out.println("<li>"+sname+"</li>");
        }
        out.println("</ul>");
        out.println("</body>");
        out.println("</html>");
   }
}
