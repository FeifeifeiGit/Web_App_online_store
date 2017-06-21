<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!--  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> -->
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Seller view </title>
<style>
input{
    width: 30%;
    padding: 5px 5px;
    margin: 4px 1px;
    box-sizing: border-box;
}
#button{
 background-color: lightblue;
}
select{
    width: 30%;
    padding: 5px 5px;
    margin: 4px 1px;
    box-sizing: border-box;
}
#logout{
	float:right;
}


</style>
</head>
<body>
<h1 style="text-align:center text-size:160%">Maintain your store! </h1>
<hr size="10" color="red">
<br/>
<a href="SellerCatalog.htm" ><b><span style="color:blue;" >click here to browse your Catalog!</span></b> </a>
<br/>
<a href="viewOrderHistory.htm">View Order History</a>
<a id = "logout" href="logout.htm" >Log Out</a><br/><br/><br/>

	<form method="POST" action="uploadFile.htm" enctype="multipart/form-data">
		Category:
		<select  name="category">
   			 <option value="shampoo">shampoo</option>
   			 <option value="conditioner">conditioner</option>
    		 <option value="hair spray">hair spray</option>
    		 <option value="hair mask">hair mask</option>
		</select>
		<br/>
		Name: <input type="text" name="name"><br/>
		Quantity(100-500): <input type="text" name="quantity" />
		Brand:
			<select   name="brand">
   			 <option value="Drybar">Drybar</option>
   			 <option value="Phyto">Phyto</option>
    		 <option value="Living Proof">Living Proof</option>
    		 <option value="Bumble and Bumble">Bumble and Bumble</option>
		</select>
		<br/>
		Price:<input type="text" name="price"><br/>
		Description:<br/><textarea name="description" rows="4" cols="50"></textarea><br/>
		 
		File to upload: <input id="filechooser" type="file" name="file"><br/><br/>
		
		<input  id="button"type="submit" value="Upload"> Press here to upload the file!
	</form>
	
</body>
</html>