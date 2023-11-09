<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="Styles/MainPageStyles.css">
    <title>TechShop</title>
</head>

<body>
<div class="containerMain">
    <div class="header">
        <div class="logo">TechShop</div>
        <c:choose>

            <c:when test="${empty sessionScope.UserId }">

                <div class="buttons">
                    <form action="Controller" method="get">
                        <input type="hidden" name="command" value="TO_PAGE"/>
                        <input type="hidden" name="page_name" value="JSP/Login.jsp"/>
                        <input type="submit" class="signin" id="to_sing_in" value="Sing in">
                    </form>
                    <form action="Controller" method="get">
                        <input type="hidden" name="command" value="TO_PAGE"/>
                        <input type="hidden" name="page_name" value="JSP/SingUp.jsp"/>
                        <input type="submit" class="signup" id="to_sing_up" value="Sing up">
                    </form>
                </div>
            </c:when>
            <c:otherwise>
                <div class="buttons">
                    <form action="Controller" method="get">
                        <input type="hidden" name="command" value="EXIT"/>
                        <input type="hidden" name="page_name" value="JSP/Login.jsp"/>
                        <input type="submit" class="signin" value="Log out">
                    </form>
                    <c:if test="${sessionScope.isAdmin == 'Administrator'}">
                        <form action="Controller" method="get">
                            <input type="hidden" name="command" value="TO_PAGE"/>
                            <input type="hidden" name="page_name" value="JSP/Administrator.jsp"/>
                            <input type="submit" class="signup" value="Administrator">
                        </form>
                    </c:if>

                </div>

            </c:otherwise>
        </c:choose>


    </div>
</div>


<form action="Controller" method="get">
    <input type="hidden" name="command" value="DISPLAY_PRODUCTS"/>

    <label for="category">Category:</label>
    <input type="text" id="category" name="category"/>

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