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
    <c:if test="${sessionScope.isAdmin == 'Administrator'}">
        <a href="admin.jsp">Administrator</a>
    </c:if>
</div>
<form action="Controller" method="get">
    <input type="hidden" name="command" value="DISPLAY_PRODUCTS" />

    <label for="category">Category:</label>
    <input type="text" id="category" name="category" />

    <button type="submit">Show List</button>
</form>
<div class="container">
    <h1>Product List</h1>
    <c:forEach var="product" items="${sessionScope.products}">
        <div class="product-box">
            <h2>${product.productName}</h2>
            <img src="${product.fileName}" alt="${product.productName}" style="max-width: 200px; max-height: 200px;">
            <p>Price: ${product.price}</p>
            <p>Category: ${product.category}</p>

            <form action="Controller" method="post">
                <input type="hidden" name="command" value="ADD_TO_CART">
                <input type="hidden" name="productId" value="${product.id}">
                <button type="submit">Add to cart</button>
            </form>
        </div>
    </c:forEach>
</div>
</body>
</html>


