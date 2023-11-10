<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
<%--    <link rel="stylesheet" href="Styles/MainPageStyles.css">--%>
    <title>TechShop</title>
</head>
<style>
    body {
        margin: 0;
        padding: 0;
        display: block;
        height: 100vh;
        background-color: #f5f5f5;
    }

    .containerMain {
        text-align: center;
        width: 100%;
    }
    .view-cart-button, .add-to-cart-button {
        background-color: #4caf50;
        color: white;
        border: none;
        padding: 10px 20px;
        cursor: pointer;
        font-size: 16px;
        margin-bottom: 10px;
    }

    .view-cart-button:hover, .add-to-cart-button:hover {
        background-color: #45a049;
    }

    .buttons{
        display: flex;
        justify-content: space-between;
        padding-right: 5%;
        width: 10%;
        /*border: red 2px solid;*/
        height: 100%;
    }
    .header {
        display: flex;
        justify-content: space-between;
        align-items: center;
        padding: 20px;
        background-color: #333;
        color: white;
        width: 100%;
    }

    .logo {
        font-style: italic;
        font-size: 24px;
    }

    /*.signin {*/
    /*    background-color: #2f2e2e;*/
    /*    width:130%;*/
    /*    height: 140%;*/
    /*    color: white;*/
    /*}*/

    /*.signup {*/
    /*    width:130%;*/
    /*    height: 140%;*/
    /*    background-color: #2f2e2e;*/
    /*    color: white;*/
    /*}*/

    .signin, .signup {
        width:90%;
        height: 90%;
        font-size: 18px; /* Set the font size according to your preference */
        margin: 10px; /* Set the margin according to your preference */
        background-color: #2f2e2e;
        color: white;
        border: none;
        border-radius: 25px; /* Add rounded corners */
        cursor: pointer;
        transition: background-color 0.3s ease; /* Add smooth transition for hover effect */
    }

    .signin:hover, .signup:hover {
        background-color: #555; /* Change background color on hover */
    }
    body {
        font-family: Arial, sans-serif;
        background-color: #f4f4f4;
        margin: 0;
        padding: 0;
    }

    header {
        background-color: #333;
        color: white;
        padding: 10px 0;
        text-align: center;
    }

    .container {
        margin: 20px auto;
        padding: 20px;
        background-color: white;
        border-radius: 5px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        width: 80%;
    }

    .product-box {
        border: 1px solid #ccc;
        padding: 20px;
        margin: 10px;
        width: 250px;
        text-align: center;
        background-color: #ffffff;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
    }

    .product-box h2 {
        font-size: 18px;
        margin-bottom: 10px;
    }

    .product-box img {
        margin-bottom: 10px;
        max-width: 100%;
        height: auto;
    }

    .product-box p {
        margin-bottom: 10px;
    }

    .product-box button {
        background-color: #4caf50;
        color: white;
        border: none;
        padding: 10px 20px;
        cursor: pointer;
        font-size: 16px;
    }

    .product-box button:hover {
        background-color: #45a049;
    }

    form {
        margin-bottom: 20px;
    }

    form input[type="text"] {
        padding: 10px;
        font-size: 16px;
        border: 1px solid #ccc;
        border-radius: 5px;
        margin-right: 10px;
    }

    form button {
        background-color: #333;
        color: white;
        border: none;
        padding: 10px 20px;
        cursor: pointer;
        font-size: 16px;
    }

    form button:hover {
        background-color: #555;
    }

    div.align-right {
        text-align: right;
        padding: 10px;
        background-color: #333;
    }

    div.align-right a {
        color: white;
        text-decoration: none;
    }


</style>

<body>

<div class="containerMain">
    <div class="header">
        <div class="logo">TechShop</div>
        <c:choose>

            <c:when test="${empty sessionScope.UserId }">

                <div class="buttons">
                    <form action="SignIn" method="get">
                        <input type="hidden" name="command" value="TO_PAGE"/>
                        <input type="hidden" name="page_name" value="JSP/Login.jsp"/>
                        <input type="submit" class="signin" id="to_sing_in" value="Sing in">
                    </form>
                    <form action="SignUp" method="get">
                        <input type="hidden" name="command" value="TO_PAGE"/>
                        <input type="hidden" name="page_name" value="JSP/SingUp.jsp"/>
                        <input type="submit" class="signup" id="to_sing_up" value="Sing up">
                    </form>
                </div>
            </c:when>
            <c:otherwise>
                <div class="buttons">
                    <form action="TechStore" method="post">
                        <input type="hidden" name="command" value="EXIT"/>
                        <input type="submit" class="signin" value="Log out">
                    </form>
                    <c:if test="${sessionScope.isAdmin == 'Administrator'}">
                        <form action="TechStore" method="get">
                            <input type="hidden" name="command" value="TO_PAGE"/>
                            <input type="hidden" name="page_name" value="JSP/Administrator.jsp"/>
                            <input type="submit" class="signup" value="Admin">
                        </form>
                    </c:if>

                </div>

            </c:otherwise>
        </c:choose>


    </div>
</div>


<form action="TechStore" method="post">
    <input type="hidden" name="command" value="DISPLAY_PRODUCTS"/>

    <label for="category">Category:</label>
    <input type="text" id="category" name="category"/>

    <button type="submit">Show List</button>
</form>

<c:if test="${not empty sessionScope.UserId}">
<form action="ShoppingCart" method="get">
    <button type="submit" class="view-cart-button">View Cart</button>
</form>
</c:if>
<div class="container">
    <h1>Product List</h1>
    <c:forEach var="product" items="${products}">
        <div class="product-box">
            <h2>${product.productName}</h2>
            <img src="${product.fileName}" alt="${product.productName}" style="max-width: 200px; max-height: 200px;">
            <p>Price: ${product.price}</p>
            <p>Category: ${product.category}</p>

            <c:if test="${not empty sessionScope.UserId}">
            <form action="TechStore" method="post">
                <input type="hidden" name="command" value="ADD_TO_CART">
                <input type="hidden" name="productId" value="${product.id}">
                <button type="submit">Add to cart</button>
            </form>
            </c:if>
        </div>
    </c:forEach>
</div>
</body>

</html>