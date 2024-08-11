<%-- 
    Document   : changePassword
    Created on : 05-07-2023, 10:28:30
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<link rel="stylesheet" href="css/changePass.css"/>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="login">
            <h1>Reset Password</h1>
            <form  action="changePassResetServlet" method="post" >
                <input type="text" name="user" value="${sessionScope.emailReset}" readonly/>

                <input type="password" name="pass" placeholder="Password" required="required" />
                <input type="password" name="rePass" placeholder="Re-Password" required="required" />
                <input type="hidden" name="linkCreationTime" value="<%= System.currentTimeMillis() %>" />
                <button type="submit" class="btn btn-primary btn-block btn-large"> Save </button>


                <p class="text-danger" style="color: red ; width: auto ; margin: auto ;padding: auto ; text-align: center ; border-radius: 50px;">${mess}
                </p>
            </form>
            <br>	<div class="d-flex justify-content-center">
                <a href="index.jsp">Quay về trang chủ </a>
            </div>
        </div>
    </body>
</html>
