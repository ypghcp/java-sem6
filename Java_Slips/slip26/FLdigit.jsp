<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sum of First and Last Digit</title>
</head>
<body>
<form method="post" action="">
    Enter a number: <input type="text" name="number">
    <input type="submit" value="Calculate">
</form>
<%
    // Get the number from the request parameter
    String numberStr = request.getParameter("number");
    
    // Check if numberStr is not null and not empty
    if (numberStr != null && !numberStr.isEmpty()) {
        // Parse the number string to integer
        int number = Integer.parseInt(numberStr);
        
        // Calculate the sum of first and last digits
        int lastDigit = number % 10;
        int firstDigit = 0;
        while (number != 0) {
            firstDigit = number % 10;
            number = number / 10;
        }
        int sum = firstDigit + lastDigit;
%>
    <div style="color: red; font-size: 18px;">
        Sum of First and Last Digit of <%= numberStr %> is <%= sum %>
    </div>
<%
    }
%>
</body>
</html>
