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
<style>
    body {
        font-family: Arial, sans-serif;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
        margin: 0;
    }

    .form-container {
        display: flex;
        flex-direction: column;
    }

    .registration-form, .login-form {
        margin-bottom: 20px;
        padding: 20px;
        border: 1px solid #ccc;
        border-radius: 5px;
    }

    label {
        margin-bottom: 5px;
    }

    input[type="text"],
    input[type="password"] {
        width: 94%;
        padding: 8px;
        margin-bottom: 10px;

        padding-right: -20px;
        border: 1px solid #ccc;
        border-radius: 3px;
    }

    input[type="submit"] {
        background-color: #4caf50;
        color: white;
        padding: 10px 20px;
        border: none;
        border-radius: 3px;
        cursor: pointer;
        transition: background-color 0.3s;
    }

    input[type="submit"]:hover {
        background-color: #45a049;
    }

</style>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
<%--    <link rel="stylesheet" href="../Styles/EnterFormStyles.css">--%>
    <title>Sing in</title>
</head>

<body>
<div class="form-container">
    <div class="login-form">
        <h2>SIGN IN</h2>
        <form action="Controller" method="post">
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
