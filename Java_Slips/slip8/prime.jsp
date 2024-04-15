<html>
<head>
<title>
	Check Prime
</title>
</head>
<body>
<%
	int n=Integer.parseInt(request.getParameter("t1"));
	int i;
	for(i=2;i<n;i++)
	{
		if(n%i==0)
			break;
	}
	if(i==n)
		out.println("<h1 style='color:red'>Number is Prime</h1>");
	else
		out.println("<h1 style='color:green'>Number is Not Prime</h1>");
%>
<hr>
<br>
<a href="index.html">Home</a>
</body>
</html>
