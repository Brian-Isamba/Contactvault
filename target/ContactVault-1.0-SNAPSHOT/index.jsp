<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Contact Registry</title>
</head>
<body>
    <h2>Register Contact</h2>
    <form action="ContactServlet" method="post">
        Full Name: <input type="text" name="fullName" required><br>
        Phone Number: <input type="text" name="phoneNumber" required><br>
        <input type="submit" value="Submit">
    </form>
</body>
</html>
