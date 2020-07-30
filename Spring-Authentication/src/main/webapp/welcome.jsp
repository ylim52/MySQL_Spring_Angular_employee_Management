<%--
  Created by IntelliJ IDEA.
  User: Landon
  Date: 6/2/2020
  Time: 2:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome Page</title>
    <link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
          rel="stylesheet">
    <script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
    <script src="webjars/jquery/1.9.1/jquery.min.js"></script>
</head>
<body>
    <div class="container text-center">
        <h1>Welcome!</h1>
    </div>
    <div class="container text-center">
        <form action="login" method="post">
            <h4>Please Enter Your Username or Email</h4>
            <input class="form-control" type="text" name="username" placeholder="Enter User Name or Email here to login" autofocus="true">
            <br>
            <input class="form-control" type="password" name="password" placeholder="Enter password here">
            <br>
            <p class="text-left text-danger"> &nbsp;  ${msg}  </p>
            <br>
            <button type="submit" class="btn btn-success">Login</button>
        </form>
        <a href="register">Register with token</a>
    </div>
</body>
</html>
