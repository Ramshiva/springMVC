<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page session='true' %>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
<h1>${title}</h1>
<h1>${message}</h1>

	
	
	
	<form:form id="loginform" modelAttribute="login" action="loginProcess" method="post">
		<table align="center">
            <tr>
                <td>
               		 <form:label path="userName">Username</form:label>
                </td>
                <td>
                	<form:input path="userName" name="userName" id="userName"/>
                </td>
            </tr>
            <tr>
                <td>
                	<form:label path="password">Password</form:label>
                </td>
                <td>
                	<form:input path="password" name="password" id="password"/>
                </td>
             </tr>
             <tr>
             	<td></td>
             	<td align="left">
             		<form:button id="login" name="login">Login</form:button>
             	</td>
             </tr>
             <tr></tr>
                 <tr>
                     <td></td>
                     <td><a href="home.jsp">Home</a>
                     </td>
              </tr>
          </table>
		</form:form>
		    <table align="center">
                <tr>
                    <td style="font-style: italic; color: red;">${message}</td>
                </tr>
            </table>
            
            <c:if test="${userName == null}">
           | <a href="<c:url value="/j_spring_security_logout" />" >Logout</a>
	</c:if>
	
</body>
</html>