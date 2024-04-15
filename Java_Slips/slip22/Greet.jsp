<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Greeting Page</title>
</head>
<body>
    <h2>Greeting Page</h2>
    <form action="" method="post">
        Enter your name: <input type="text" name="username"><br>
        <input type="submit" value="Submit">
    </form>
    <%
        // Get the username parameter from the request
        String username = request.getParameter("username");
        
        // Get the current hour on the server
        int hour = java.time.LocalTime.now().getHour();
        
        // Determine greeting message based on the current hour
        String greeting;
        if (hour >= 6 && hour < 12) {
            greeting = "Good morning";
        } else if (hour >= 12 && hour < 18) {
            greeting = "Good afternoon";
        } else {
            greeting = "Good evening";
        }
        
        // Display the greeting message if the username is provided
        if(username != null && !username.isEmpty()) {
    %>
            <p><%= greeting %>, <%= username %>!</p>
    <%
        }
    %>
</body>
</html>
