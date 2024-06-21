<%@ page import="mx.edu.utez.pruebagit.model.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

</head>
<body>
<%
    HttpSession sesion = request.getSession();
    User u = (User) sesion.getAttribute("usuario");
%>
<form method="post" action="sign_in">
    <lable>Ingrese su nombre de usuario: </lable>
    <input type="text" name="user_name" value="<%=u.getUser_name()%>" >
    <br>
    <lable>Ingrese su contraseña: </lable>
    <input type="password" name="pass1" value="<%=u.getPass()%>">
    <br>
    <lable>Ingrese su contraseña nuevamente: </lable>
    <input type="password" name="pass2" value="<%=u.getPass()%>">
    <br>
    <lable>Ingres su correo: </lable>
    <input type="email" name="email" value="<%=u.getEmail()%>>
    <br>
    <input type="submit" name="boton">
    <br>
</form>
</body>
</html>
