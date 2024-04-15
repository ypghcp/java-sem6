import java.io.*;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.sql.*;

public class cust extends HttpServlet {
    
    // JDBC URL, username, and password of MySQL server
    private static final String JDBC_URL = "jdbc:postgresql://192.168.1.254:5432/";
    private static final String JDBC_USER = "";
    private static final String JDBC_PASSWORD = "";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve customer number from the request
        String customerNumber = request.getParameter("customerNumber");

        // Database connection
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;setCookie

        try {
            // Register JDBC driver
            //Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Open a connection
            conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
            
            // Prepare SQL statement to retrieve customer details based on customer number
            String sql = "SELECT * FROM customer WHERE cno = ?";
            pstmt = conn.prepareStatement(sql);
            int c=Integer.parseInt(customerNumber);
            pstmt.setInt(1, c);
            setCookie
            // Execute the query
            rs = pstmt.executeQuery();

            if (rs.next()) {
                // If customer details found, retrieve them
                int customerNo = rs.getInt("cno");
                String customerName = rs.getString("cname");
                String customerCity = rs.getString("city");
                response.setContentType("text/html");
                PrintWriter out = response.getWriter();
                out.println("<h2>Customer Details</h2>");
                out.println("<p>" + customerNo + "</p>");
                out.println("<p>" + customerName + "</p>");
                out.println("<p>" + customerCity + "</p>");
                
            } else {
                // If customer details not found, return an error message
                response.setContentType("text/html");
                PrintWriter out = response.getWriter();
                out.println("<h2>Error</h2>");
                out.println("<p>Customer not found.</p>");
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle errors appropriately
        } finally {
            // Close resources
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace(); // Handle errors appropriately
            }
        }
    }
}

//save this file in classes folder
//in web.xml add
/*
<web-app>

<servlet>
<servlet-name>cust</servlet-name>
<servlet-class>cust</servlet-class>
</servlet>
<servlet-mapping>
 <servlet-name>cust</servlet-name>
 <url-pattern>/cust/*</url-pattern>
</servlet-mapping>

</web-app>
 */