<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<style>
td {
    padding: 15px;
    text-align: left;
    margin: 4px 5px;
}

#button{
 background-color: lightblue;
}
</style>
<body>
<h1 style="text-align:center text-size:160%">Browse all your product</h1><br/>
<jsp:include page="BuyerMenu.jsp"/><br/>
<hr size="5" color="red"><br/>

<br/>

<p style="color:red;">Below is your cart</p>
<c:choose>
<c:when test="${!empty sessionScope.buyer.cart}">
  
<Table  border="1" style="background-color:lightgrey">

     <c:forEach var ="orderitem" items="${sessionScope.buyer.cart.cartlist}">
            <tr>
            	<td width="800">Product name:<c:out value="${orderitem.product.name}"></c:out><br/>
             	<img  src="<c:url value ="${orderitem.product.photopath}" />" alt="fail to load picture" style="width: 439px; height: 350px"><br/>
            	Price: <c:out value="${orderitem.product.price}"></c:out><br/>
            	Description:<c:out value="${orderitem.product.description}"></c:out><br/>
            	Quantity: <c:out value="${orderitem.quantity}"></c:out><br/>
            	</td>
            </tr>
            <br/><br/>
        </c:forEach>
            
</Table>
<hr size="3" color="black">
<form action=" checkout.htm" method="POST">
<b>Checkout: <input id= "button" type="submit"  Value="Checkout"  /></b>
</form>
</c:when>
<c:otherwise>
 <h3> Your Cart it Empty!</h3>
</c:otherwise>
</c:choose>
</body>
</html>