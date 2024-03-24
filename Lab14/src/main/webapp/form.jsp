<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Form Page</title>
</head>
<body>
<h2>Podaj swoje dane</h2>
<form action="forms" method="post">
    Imie: <input type="text" name="imie" required><br>
    Nazwisko: <input type="text" name="nazwisko" required><br>
    Email: <input type="email" name="mail" required><br>
    <input type="submit" value="Submit">
</form>
</body>
</html>
