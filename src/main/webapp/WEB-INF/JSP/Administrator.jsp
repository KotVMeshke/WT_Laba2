<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:set var="language" value="${not empty param.language ? param.language : not empty language ? language : 'en'}" scope="session" />
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="text" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html  lang="${language}">
<head>
    <meta charset="UTF-8">
    <title>Administrator Page</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
        }

        h1 {
            color: #333;
        }

        form {
            margin-bottom: 20px;
            border: 1px solid #ccc;
            padding: 10px;
            border-radius: 5px;
        }

        label {
            display: block;
            margin-bottom: 5px;
        }

        input {
            margin-bottom: 10px;
        }

        input[type="submit"] {
            background-color: #4caf50;
            color: white;
            padding: 10px 15px;
            border: none;
            border-radius: 3px;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
<form>
    <select id="language" name="language" onchange="submit()">
        <option value="en" ${language == 'en' ? 'selected' : ''}><fmt:message key="language.text.english" /></option>
        <option value="ru" ${language == 'ru' ? 'selected' : ''}><fmt:message key="language.text.russian" /></option>
    </select>
</form>
<h1>Product Add Form</h1>
<form action="TechStore" method="post" enctype="multipart/form-data">
    <label for="productName">Product name:</label>
    <input type="text" name="productName" id="productName" required><br>

    <label for="productPrice">Product price:</label>
    <input type="number" name="productPrice" id="productPrice" required><br>
    <input type="hidden" name="command" value="ADD_PRODUCT" />

    <label for="productCategory">Product category:</label>
    <input type="text" name="productCategory" id="productCategory" required><br>

    <label for="productImage">Product image:</label>
    <input type="file" name="productImage" id ="productImage" accept="image/*" required>

    <input type="submit" value="Add Product">
</form>

<h1>Ban Form</h1>
<form action="TechStore" method="post">
    <label for="userId">User Id:</label>
    <input type="text" name="userId" id="userId" required><br>
    <input type="hidden" name="command" value="SET_BAN" />

    <input type="submit" value="Give Ban">
</form>

<h1>Unban User Form</h1>
<form action="TechStore" method="post">
    <label for="userIdUn">User Id: </label>
    <input type="text" name="userId" id="userIdUn" required><br>
    <input type="hidden" name="command" value="REMOVE_BAN" />

    <input type="submit" value="Unban User">
</form>

<h1>Discount Form</h1>
<form action="TechStore" method="post">
    <label for="discountProductId">Product Id:</label>
    <input type="text" name="discountProductId" id="discountProductId" required><br>
    <input type="hidden" name="command" value="SET_DISCOUNT" />

    <label for="discountAmount">Discount:</label>
    <input type="number" name="discountAmount" id="discountAmount" required><br>

    <input type="submit" value="Set Discount">
</form>

</body>
</html>
