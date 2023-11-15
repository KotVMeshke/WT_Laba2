<%--
  Created by IntelliJ IDEA.
  User: dimon
  Date: 27.10.2023
  Time: 20:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:set var="language" value="${not empty param.language ? param.language : not empty language ? language : 'en'}" scope="session" />
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="text" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html  lang="${language}">
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
<form>
    <select id="language" name="language" onchange="submit()">
        <option value="en" ${language == 'en' ? 'selected' : ''}><fmt:message key="language.text.english" /></option>
        <option value="ru" ${language == 'ru' ? 'selected' : ''}><fmt:message key="language.text.russian" /></option>
    </select>
</form>
<div class="form-container">
    <div class="login-form">
        <h2><fmt:message key="signin.header" /></h2>
        <form action="TechStore" method="post">
            <label for="Login"><fmt:message key="signin.label.login" />:</label>
            <input type="text" id="Login" name="Login" required><br>

            <label for="Password"><fmt:message key="signin.label.password" />:</label>
            <input type="password" id="Password" name="Password" required><br>

            <input type="hidden" name="command" value="SIGN_IN" />
            <input type="submit" id ="sing_in-button" value="<fmt:message key="signin.button.signip" />">
            <input type="hidden" name="page" value="main">

        </form>
    </div>
</div>
</body>

</html>
