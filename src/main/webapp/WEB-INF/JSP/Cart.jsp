<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>Customer Cart</title>
    <style>
        body {
            margin: 0;
            padding: 0;
            display: block;
            height: 100vh;
            background-color: #f5f5f5;
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
</head>

<body>
<h1>Shopping Cart</h1>

<c:if test="${empty sessionScope.cart}">
    <p>Your cart is empty.</p>
</c:if>

<div class="container">
<c:forEach var="CartItem" items="${sessionScope.cart}">
    <div class="product-box">
        <h2>${CartItem.product.productName}</h2>
        <img src="${CartItem.product.fileName}" alt="${CartItem.product.productName}" style="max-width: 200px; max-height: 200px;">
        <p>Price: ${CartItem.product.price}</p>
        <p>Category: ${CartItem.product.category}</p>
        <p>Quantity: ${CartItem.amount}</p>

        <form action="TechStore" method="post">
            <input type="hidden" name="command" value="UPDATE_CART">
            <input type="hidden" name="productId" value="${CartItem.product.id}">

            <label for="quantity">Quantity:</label>
            <input type="number" id="quantity" name="quantity" value="${CartItem.amount}" min="1" required>

            <button type="submit">Update Quantity</button>
        </form>

        <form action="TechStore" method="post">
            <input type="hidden" name="command" value="REMOVE_FROM_CART">
            <input type="hidden" name="productId" value="${CartItem.product.id}">
            <button type="submit">Remove from Cart</button>
        </form>
    </div>
</c:forEach>
</div>
<c:if test="${not empty sessionScope.cart}">
<form action="Checkout" method="post">
    <input type="hidden" name="command" value="CHECKOUT">
    <button type="submit">Proceed to Checkout</button>
</form>
</c:if>
</body>

</html>