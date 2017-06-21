<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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

#button{
 background-color: lightblue;
}
#logout{
float: right;
}
</style>
</head>
<body>

<h1 style="text-align:center text-size:160%">Browse all your product</h1><br/>
<hr size="5" color="red"><br/>
<a href="uploadFile.htm" ><span style="color:blue;"><b>Go Back to Add More Product!</b></span></a>
<br/>
<a href="viewOrderHistory.htm" >View Order History</a>
<a id = "logout" href="logout.htm" >Log Out</a>

<br/>
<c:if test="${!empty seller.productcatalog}">
<Table width="800"  border="1" style="background-color:lightgrey">
     <c:forEach var ="product" items="${seller.productcatalog}">
     
            <tr>
            	<td width="800">Product name:<c:out value="${product.name}"></c:out><br/>
             	<img  src="<c:url value ="${product.photopath}" />" alt="fail to load picture" style="width: 439px; height: 350px"><br/>
            	Category:<c:out value="${product.category}"/><br/>
            	Price: <c:out value="${product.price}"></c:out><br/>
            	Description:<c:out value="${product.description}"></c:out><br/>
            	
            	<form action="deleteProduct.htm" method="POST" >
            	<input type="hidden" name ="productid"  value="${product.productid}" />
            	<input id ="button" type="submit" value="Delete this Product" />
            	</form>
            	
            	</td>
            </tr>
            <br/><br/>
        </c:forEach>
</Table>
</c:if>



</body>
</html>