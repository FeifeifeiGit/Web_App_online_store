<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>sign up complete</title>
</head>

<body>
<h3>Welcome ${buyer.firstname } ${buyer.firstname }!</h3>  <br>
<a href="signin.htm?role=buyer">Please sign in to start shopping!</a>
<jsp:include page="BuyerMenu.jsp"/><br/>
</body>
</html>