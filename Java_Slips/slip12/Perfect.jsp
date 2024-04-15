<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    int number = Integer.parseInt(request.getParameter("number"));
    int sum = 0;
    
    for (int i = 1; i < number; i++) {
        if (number % i == 0) {
            sum += i;
        }
    }
    
    if (sum == number) {
%>
        <h1><%= number %> is a Perfect Number!</h1>
<%
    } else {
%>
        <h1><%= number %> is not a Perfect Number!</h1>
<%
    }
%>

