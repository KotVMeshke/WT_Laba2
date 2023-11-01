<%--
  Created by IntelliJ IDEA.
  User: dimon
  Date: 01.11.2023
  Time: 17:01
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>TechShop</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="../Styles/MainPage.css">
</head>
<body>
<div align="right">
    <a href="logout.jsp">Log out</a>
</div>
<form action="../Controller" method="get">
    <input type="hidden" name="command" value="DISPLAY_PRODUCTS" />
    <button type="submit">Show List</button>
</form>
<div class="container">
    <h1>Product List</h1>
    <c:forEach var="product" items="${products}">
        <div class="product-box">
            <h2>${product.productName}</h2>
            <img src="${product.fileName}" alt="${product.productName}" style="max-width: 200px; max-height: 200px;">
            <p>Price: ${product.price}</p>
            <p>Category: ${product.category}</p>
        </div>
    </c:forEach>
</div>
</body>
</html>


