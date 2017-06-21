<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Seller Catalog</title>
<style>
td {
    padding: 15px;
    text-align: left;
    margin: 4px 5px;
}
Table{
     width: 100px; ;
}

#button{
 background-color: lightblue;
}
table{

	margin-left: auto;
    margin-right: auto
}
</style>
</head>
<body>

<jsp:include page="BuyerView.jsp" />


<h3 style="text-align:center text-size:160%">Browse all your product</h3><br/>

<hr size="5" color="red">
<br/><br/>

<br/>
<c:if test="${!empty sessionScope.products}">
<Table  border="1" style="background-color:lightgrey ">
     <c:forEach var ="product" items="${sessionScope.products}">
     
            <tr>
            	<td width="800">Product name:<c:out value="${product.name}"></c:out><br/>
             	<img  src="<c:url value ="${product.photopath}" />" alt="fail to load picture" style="width: 439px; height: 350px"><br/>
            	Category:<c:out value="${product.category}"/><br/>
            	Price: <c:out value="${product.price}"></c:out><br/>
            	Quantity:<c:out value="${product.quantity}"></c:out><br/>
            	Description:<c:out value="${product.description}"></c:out><br/>
            	
            	<form action="addToCart.htm" method="POST" >
            	<input type="hidden" name ="productid"  value="${product.productid}" />
            	<input type="text" name="quantity"  min="1" max="${product.quantity}" required/>
            	<input id ="button" type="submit" value="Add To Card" />
            	</form>
            	
            	</td>
            </tr>
            <br/><br/>
        </c:forEach>
</Table>
</c:if>



</body>
</html>