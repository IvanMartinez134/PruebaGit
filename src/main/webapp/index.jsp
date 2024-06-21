<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
    <form method="post" action="login">
        <lable>Ingrese su nombre de usuario: </lable>
        <input type="text" name="user_name" >
        <br>
        <lable>Ingrese su contraseña: </lable>
        <input type="password" name="pass" >
        <br>
        <%
        HttpSession sesion = request.getSession();
        String mensaje = (String) sesion.getAttribute("mensaje");

        if(mensaje != null){


        %>
        <p style="color: darkred"><%=mensaje%>/p>
        <% } %>
            <br>
        <input type="submit" value="Iniciar sesión">

    </form>
    <a href="registroUsuario.jsp">Registrar usuario</a>
    <a href="gestionUsuario.jsp">Gestion de usuario</a>
</body>
</html>