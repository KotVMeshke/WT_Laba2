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
    <title>Sing up</title>
</head>

<body>
<div class="form-container">
    <div class="registration-form">
        <h2>SING UP</h2>
        <form action="Controller" method="post">
            <label for="reg-login">Login:</label>
            <input type="text" id="reg-login" name="Login" required><br>

            <label for="reg-password">Password:</label>
            <input type="password" id="reg-password" name="Password" required><br>

            <label for="confirm-password">Repeat password:</label>
            <input type="password" id="confirm-password" name="confirm-password" required><br>

            <input type="hidden" name="command" value="REGISTER" />
            <label for="Register-button">${IncorrectData}</label>
            <input type="submit" id ="Register-button" value="Sing up">

        </form>
    </div>
</div>
</body>

</html>
