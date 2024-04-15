<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Reverse String</title>
</head>
<body>
    <h2>Reverse String</h2>
    <form action="" method="post">
        Enter a string: <input type="text" name="inputString"><br>
        <input type="submit" value="Reverse">
    </form>
    <% 
        // Get the inputString parameter from the request
        String inputString = request.getParameter("inputString");
        
        // Check if the inputString is not null and not empty
        if(inputString != null && !inputString.isEmpty()) {
            // Reverse the inputString using StringBuilder
            String reversedString = new StringBuilder(inputString).reverse().toString();
    %>
            <p>Original String: <%= inputString %></p>
            <p>Reversed String: <%= reversedString %></p>
    <% } %>
</body>
</html>
