<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>sign in page</title>
</head>
 <script>
   //AJAX
		 var xmlHttp;
        xmlHttp = GetXmlHttpObject();
        function checkSignin() {
            if (xmlHttp == null)
             {
                 alert("Your browser does not support AJAX!");
                 return;
             }
             var requestRole = document.getElementByName("role").value;
             var query = "requestRole="+ requestRole;

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
             xmlHttp.open("POST", "signincheck.htm", true);
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
     
     
        
</script>
<body>
        <c:if test="${!empty param.error}">
            <p style="color:red;">Please enter valid credentials and login</p>
        </c:if>
        <c:choose>
            <c:when test="${!empty sessionScope.username} ">   
                <c:redirect url="signin.htm"/>                
            </c:when>
            <c:otherwise>
                <form action='signin.htm' method='post'>
                UserName : <input type ='text' name ='username' value='${cookie.userName.value}'><br/><br/>
                Password : <input type ='text' name ='password' value='${cookie.password.value}'><br/><br/>
                Choose your Role:
                <input type ='radio' name ='role' value='seller' onblur='return checkSignin()'>Seller
                <input type ='radio' name ='role' value='buyer' onblur='return checkSignin()' >Buyer<br/><br/>
                <div id="error" ></div>
              
                <input type='checkbox' name='rememberMe' value="" value="rememberMe" checked> Remember Me <br/><br />
                <input type='submit' value='Submit'> 
        		</form>
            </c:otherwise>
        </c:choose>
        
</body>
</html>