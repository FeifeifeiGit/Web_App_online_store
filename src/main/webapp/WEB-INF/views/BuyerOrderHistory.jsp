<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title> Order History</title>
</head>
</head>
<body>
<jsp:include page="BuyerMenu.jsp"/><br/>

<c:if test="${!empty sessionScope.orderHistory}">



     <c:forEach var ="order" items="${orderHistory}">
     <Table  border="1" style="background-color:lightgrey">
	     <tr>
		     <th>Order ID </th>
		     <th>Order Date </th>
		     <th>Seller</th>
		     <th>Buyer </th>
		  </tr>
           <tr>
            	<td><c:out value="${order.orderid}"></c:out></td>
            	<td><c:out value="${order.date}"></c:out></td>
            	<td><c:out value="${order.sellername}"></c:out></td>
            	<td><c:out value="${order.buyername}"></c:out></td>
           </tr>
       </Table>
            	Oder items below:
			            <c:forEach var ="orderitem" items="${order.orderitems}">
				           <ul>
				           <li>name:<c:out value="${orderitem.product.name }">;</c:out>
				           	   quantity:<c:out value="${orderitem.quantity }"> </c:out>
				           </li>
				           </ul> 	
			           </c:forEach>
            <br/><br/>
        </c:forEach>

	

</c:if>

</body>
</html>