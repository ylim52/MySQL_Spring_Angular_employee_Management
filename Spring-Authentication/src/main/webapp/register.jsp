<%--
  Created by IntelliJ IDEA.
  User: Landon
  Date: 6/3/2020
  Time: 6:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register Page</title>
    <link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
          rel="stylesheet">
    <script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
    <script src="webjars/jquery/1.9.1/jquery.min.js"></script>
</head>
<body>
    <div class="container text-center">
        <h1>Please Enter Your Registration Token:</h1>
        <form action="register2" method="post">
            <input class="form-control" type="text" name="token" placeholder="Enter token here">
            <br>
            <p class="text-left text-danger"> &nbsp;  ${msg}  </p>
            <br>
            <button type="submit" class="btn btn-success">Register</button>
        </form>
    </div>
</body>
</html>
