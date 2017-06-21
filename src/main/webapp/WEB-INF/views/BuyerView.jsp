<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Buyer view </title>
<style>
#search {
    width: 50%;
    padding: 5px;
    text-align: left;
    margin: 10px 5px;
    box-sizing: border-box;
}
.brand{
    color: red;
    font-family: courier;
    font-size: 90%;
    margin: 10px 5px;
}
.button{
   background-color:lightgrey;
   text-decoration: none;
   font-size: 14px;
   padding: 6px 8px;
   }
 .order{
   display: inline;

   }
   #searchButton{
   background-color:lightgrey;
   text-decoration: none;
   font-size: 14px;
   padding: 4px 6px;
   }
   
   

</style>
</head>

<body>

<h1 style="text-align:center text-size:160%">Welcome ${sessionScope.buyer.username}</h1>
<jsp:include page="BuyerMenu.jsp"/><br/>


<form style="display:inline" action="viewByName.htm" method="POST">
Search By Name: <input id="search" type="text" name ="nameSearch"> 
<input id="searchButton" type="submit" value = "Search"/>
</form>

<form class ="order" action="orderByPrice.htm" method="POST">
<input type="hidden" name ="priceOrder" value="ASC"/> 
<input class ="button" type="submit" value = "ASC"/>
</form> 

<form class ="order" action="orderByPrice.htm" method="POST">
<input type="hidden" name ="priceOrder" value="DESC"/> 
<input class ="button" type="submit" value = "DESC"/>
</form> 

<div id="byBrand" >Search by Brand :</div>
<a class="brand" href="viewByBrand.htm?brand=Drybar" >DRYBAR</a>
<a class="brand" href="viewByBrand.htm?brand=BumbleAndBumble" >Bumble And Bumble</a>
<a class="brand" href="viewByBrand.htm?brand=Phyto" >Phyto</a>
<a class="brand" href="viewByBrand.htm?brand=LivingProof" >Living Proof</a>



<br/><a class="viewall" href="viewByBrand.htm?brand=Drybar" >View All Product</a>

</body>
</html>