<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Pokaz dane</title>
</head>
<body>
<h2>Session Data</h2>
<p>Imie: <%= session.getAttribute("imie") %></p>
<p>Nazwisko: <%= session.getAttribute("nazwisko") %></p>
<p>Email: <%= session.getAttribute("email") %></p>
</body>
</html>
