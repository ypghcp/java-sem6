import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class LoginServlet extends HttpServlet {
    // JDBC URL, username, and password of MySQL server
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USERNAME = "your_username";
    private static final String PASSWORD = "your_password";

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve username and password from the request
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Initialize variables to store search results
        boolean userFound = false;
        String message = "";

        // Perform database search
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
            // Prepare SQL query
            String sql = "SELECT * FROM users WHERE username=? AND password=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, username);
            statement.setString(2, password);

            // Execute query
            ResultSet resultSet = statement.executeQuery();

            // Check if user is found
            if (resultSet.next()) {
                userFound = true;
                message = "Login successful!";
            } else {
                message = "Invalid username or password!";
            }
        } catch (SQLException e) {
            e.printStackTrace();
            message = "Database error!";
        }

        // Prepare HTML response
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><head><title>Login Result</title></head><body>");
        out.println("<h2>" + message + "</h2>");
        if (userFound) {
            out.println("<p>Welcome, " + username + "!</p>");
        } else {
            out.println("<p>Please try again.</p>");
        }
        out.println("</body></html>");
    }
}

