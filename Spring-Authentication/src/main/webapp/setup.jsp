<%--
  Created by IntelliJ IDEA.
  User: Landon
  Date: 6/3/2020
  Time: 9:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Setup username and password</title>
    <link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
          rel="stylesheet">
    <script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
    <script src="webjars/jquery/1.9.1/jquery.min.js"></script>
</head>
<body>
    <div class="container text-center">
        <h1>Please Setup Your Username and password:</h1>
        <form action="setup" method="post">
            <label>Enter User name: </label>
            <input class="form-control" type="text" name="username" placeholder="Enter username" autofocus="true">
            <br>
            <label>Enter Password: </label>
            <input class="form-control" type="text" name="password1" placeholder="Enter password">
            <br>
            <label>Enter Password Again: </label>
            <input class="form-control" type="text" name="password2" placeholder="Enter password Again">
            <br>
            <p class="text-left text-danger"> &nbsp;  ${msg}  </p>
            <br>
            <button type="submit" class="btn btn-success">Next</button>
            <br>
            <p class="text-left text-danger"> &nbsp;  ${user}  </p>
        </form>
    </div>
</body>
</html>
