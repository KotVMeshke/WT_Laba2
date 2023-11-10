<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Checkout Order</title>
    <style>
        body {
            font-family: Arial, sans-serif;
        }
        .container {
            width: 50%;
            margin: 0 auto;
        }
        form {
            margin-top: 20px;
        }
        label {
            display: block;
            margin-top: 10px;
        }
        input[type="text"] {
            width: 100%;
            padding: 8px;
            margin-top: 5px;
        }
        input[type="submit"] {
            background-color: #4CAF50;
            color: white;
            padding: 10px 15px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
    </style>
</head>
<body>
<div class="container">
    <h2>Checkout Order</h2>

    <form action="TechStore" method="post">
        <label for="address">Shipping Address:</label>
        <input type="text" id="address" name="address" required>
        <input type="hidden" id="command" name="command" value="PROCESS_ORDER" >
        <input type="submit" value="Submit Order">
    </form>
</div>
</body>
</html>
