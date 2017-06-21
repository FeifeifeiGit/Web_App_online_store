<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>sign up  </title>
</head>
<style>
        a{
            text-decoration: underline;
            cursor: pointer;
            color:blue;
        }
        span{
            color: red;
        }
</style>
 <script>
   //AJAX
		 var xmlHttp;
        xmlHttp = GetXmlHttpObject();
        function checkUser() {
           if (xmlHttp == null)
            {
                alert("Your browser does not support AJAX!");
                return;
            }
            var username = document.getElementById("username").value;
            var query = "action=nameCheck&username="+ username;

            xmlHttp.onreadystatechange = function stateChanged()
            {
                if (xmlHttp.readyState == 4 &&xmlHttp.status==200)
                {
                    //alert(xmlHttp.responseText);
                    //var json = JSON.parse(xmlHttp.responseText);
                    //document.getElementById("error").innerHTML = json;
                    document.getElementById("error").innerHTML = xmlHttp.responseText;
                }
            };
            xmlHttp.open("POST", "testseller.htm", true);
            xmlHttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
            xmlHttp.send(query);
           return false;
        }
        function checkEmail() {
            if (xmlHttp == null)
             {
                 alert("Your browser does not support AJAX!");
                 return;
             }
             var email = document.getElementById("email").value;
             var query = "action=emailCheck&email="+ email;

             xmlHttp.onreadystatechange = function stateChanged()
             {
                 if (xmlHttp.readyState == 4 &&xmlHttp.status==200)
                 {
                     //alert(xmlHttp.responseText);
                     //var json = JSON.parse(xmlHttp.responseText);
                     //document.getElementById("error").innerHTML = json;
                     document.getElementById("errorEmail").innerHTML = xmlHttp.responseText;
                 }
             };
             xmlHttp.open("POST", "testseller.htm", true);
             xmlHttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
             xmlHttp.send(query);
            return false;
         }
        
         function GetXmlHttpObject()
        {
            var xmlHttp = null;
            try
            {
                // Firefox, Opera 8.0+, Safari
                xmlHttp = new XMLHttpRequest();
            } catch (e)
            {
                // Internet Explorer
                try
                {
                    xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
                } catch (e)
                {
                    xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
                }
            }
            return xmlHttp;
        }
         
         function validateForm() {
     	    var x = document.forms["myForm"]["email"].value;
     	    var atpos = x.indexOf("@");
     	    var dotpos = x.lastIndexOf(".");
     	    if (atpos<1 || dotpos<atpos+2 || dotpos+2>=x.length) {
     	        alert("Not a valid e-mail address");
     	        return false;
     	    }
     	}
        
</script>

<body>
<h2><b>Welcome to Haircare online store!!!Your perfect place to start business!</b></h2>

        <div id="sellersignup" style="display:block ;">
            <h3>Create new account </h3>
            <form:form name = "myForm" action="sellersignup.htm" commandName="seller" method="post" id ="sellersignupform" >

                First Name: <form:input path="firstname"  /><font color="red"><form:errors path="firstname"/></font> <br>
                Last Name: <form:input path="lastname"  />  <font color="red"><form:errors path="lastname"/></font><br>
                Username: <form:input path="username"  id="username" onblur="return checkUser()"/>  <font color="red"><form:errors path="username"/></font><br>
                <div id="error" style="color:red"></div></p>
                Password: <form:input  path="password"  /> <font color="red"><form:errors path="password"/></font><br>
                Email: <form:input  path="email" id="email" onblur="return checkEmail(),validateForm() " /> <font color="red"><form:errors path="email"/></font><br><br>
                <div id="errorEmail" style="color:red"></div></p>
                Address: <br>
                	City:<form:input path="city" name="city"  /> <font color="red"><form:errors path="city"/></font> <br>
                	Street:<form:input  path="street" name="street"  /> <font color="red"> <form:errors path="street"/></font><br>
                	Postcode:<form:input  path="postcode" name="postcode"  /> <font color="red"> <form:errors path="postcode"/></font><br><br>
                <input type="submit" name="Sign up"/><br><br>
            </form:form>
        </div>
</body>
</html>