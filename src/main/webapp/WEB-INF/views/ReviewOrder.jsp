<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Review Order</title>
</head>
<body>
<jsp:include page="BuyerMenu.jsp"/><br/>
  <p style="color:red;">Thank you for your order!</p>

<c:if test="${!empty sessionScope.currentorder}">

<Table  border="1" style="background-color:lightgrey">

     <c:forEach var ="orderitem" items="${currentorder.orderitems}">
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
	

</c:if>
</body>
</html>