<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Display Patient Details</title>
</head>
<body>
    <h1>Patient Details</h1>
    <table border="1">
        <tr>
            <th>Patient Number</th>
            <th>Patient Name</th>
            <th>Patient Address</th>
            <th>Patient Age</th>
            <th>Patient Disease</th>
        </tr>
        <%@ page import="java.sql.*" %>
        <% 
            Connection conn = null;
            PreparedStatement stmt = null;
            ResultSet rs = null;
            try {
                
                // Database connection details
                String url = "jdbc:postgresql://192.168.1.254:5432/";
                String username = "";
                String password = """;
                
                // Establish the database connection
                conn = DriverManager.getConnection(url, username, password);
                
                // SQL query to fetch patient details
                String sql = "SELECT * FROM patient";
                stmt = conn.prepareStatement(sql);
                rs = stmt.executeQuery();
                
                // Iterate over the result set and display patient details
                while (rs.next()) {
        %>
                    <tr>
                        <td><%= rs.getString("pno") %></td>
                        <td><%= rs.getString("pname") %></td>
                        <td><%= rs.getString("addr") %></td>
                        <td><%= rs.getString("age") %></td>
                        <td><%= rs.getString("disease") %></td>
                    </tr>
        <% 
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                // Close JDBC objects in finally block
                try {
                    if (rs != null) rs.close();
                    if (stmt != null) stmt.close();
                    if (conn != null) conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        %>
    </table>
</body>
</html>

