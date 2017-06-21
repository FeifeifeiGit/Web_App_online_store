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
        
        #logout{
        
        float: right;
	 }
</style>
<script>
       
/*
        function BuyerSignupForm() {
            if (document.getElementById("buyersignup").style.display == "none") {
                document.getElementById("buyersignup").style.display = "block";
                document.getElementById("buyersignupform").reset();
                document.getElementById("signupresults").innerHTML = "";
                //document.getElementById("registrationForm").style.display = "none";
            } else {
                document.getElementById("buyersignup").style.display = "none";
            }
        }
 */
        //AJAX
  /*      var xmlHttp;
        xmlHttp = GetXmlHttpObject();
        
        function getSignupResults() {
            if (xmlHttp == null)
            {
                alert("Your browser does not support AJAX!");
                return;
            }
 
            xmlHttp.onreadystatechange = function stateChanged()
            {
                if (xmlHttp.readyState == 4)
                {
                	
                }
            }
            xmlHttp.open("POST", "signup.htm", true);
            xmlHttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
            xmlHttp.send();
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
          */
</script>
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
            xmlHttp.open("POST", "testbuyer.htm", true);
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
             xmlHttp.open("POST", "testbuyer.htm", true);
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
<h2>Welcome to Haircare online store!!!</h2>

<a id = "logout" href="logout.htm" >Log Out</a>
<!--  
<button  onclick="BuyerSignupForm()">new User?  Click to Sign up</button>
<button  onclick="SellerSignupForm()">Want to be a seller?  Click to Sign up</button><br/><br/>
-->

        <div id="buyersignup" style="display:block ;">
            <h3>Create new account </h3>
            <form:form name = "myForm" action="buyersignup.htm" commandName="buyer" method="post" id ="buyersignupform" >

                First Name: <form:input path="firstname"  /><font color="red"><form:errors path="firstname"/></font><br>
                Last Name: <form:input path="lastname"  />  <font color="red"><form:errors path="lastname"/></font><br>
                Username: <form:input path="username"  id="username" onblur="return checkUser()"/>  <font color="red"><form:errors path="username"/></font><br>
                <div id="error" style="color:red"></div>
                Password: <form:input  path="password"  /> <font color="red"><form:errors path="password"/></font><br>
                Email: <form:input  path="email" id="email" onblur="return checkEmail(), validateForm()  " /> <font color="red"><form:errors path="email"/></font><br><br>
                <div id="errorEmail" style="color:red"></div>
                Address: <br>
                	City:<form:input path="city" name="city"  /> <font color="red"><form:errors path="city"/></font> <br>
                	Street:<form:input  path="street" name="street"  /> <font color="red"> <form:errors path="street"/></font><br>
                	Postcode:<form:input  path="postcode" name="postcode"  /> <font color="red"> <form:errors path="postcode"/></font><br><br>
                <input type="submit" name="Sign up"/><br><br>
            </form:form>
        </div>
        
</body>
</html>