<%--
  Created by IntelliJ IDEA.
  User: dimon
  Date: 27.10.2023
  Time: 20:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../Styles/EnterFormStyles.css">
    <title>Sing in</title>
</head>

<body>
<div class="form-container">
    <div class="login-form">
        <h2>SIGN IN</h2>
        <form action="../Controller" method="post">
            <label for="Login">Login:</label>
            <input type="text" id="Login" name="Login" required><br>

            <label for="Password">Password:</label>
            <input type="password" id="Password" name="Password" required><br>

            <input type="hidden" name="command" value="SIGN_IN" />
            <label for="sing_in-button">${IncorrectData}</label>
            <input type="submit" id ="sing_in-button" value="Sing in">

        </form>
    </div>
</div>
</body>

</html>
