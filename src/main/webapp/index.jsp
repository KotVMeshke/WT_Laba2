<%@ page language="java" contentType="text/html; charset=utf-8"
pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="Styles/MainPageStyles.css">
    <title>TechShop</title>
</head>

<body>
<div class="container">
    <div class="header">
        <div class="logo">TechShop</div>
        <form  action="Controller" method="get">
            <input type="hidden"  name="command" value="TO_PAGE" />
            <input type="hidden" name="page_name" value="JSP/Login.jsp" />
            <input type="submit" class="signin" id ="to_sing_in" value="Sing in">
        </form>
        <form   action="Controller" method="get">
            <input type="hidden"  name="command" value="TO_PAGE" />
            <input type="hidden" name="page_name" value="JSP/SingUp.jsp" />
            <input type="submit" class="signup" id ="to_sing_up" value="Sing up">
        </form>
    </div>
</div>
</body>

</html>