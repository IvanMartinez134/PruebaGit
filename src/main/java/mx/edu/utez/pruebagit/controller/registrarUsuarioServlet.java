package mx.edu.utez.pruebagit.controller;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import mx.edu.utez.pruebagit.HelloServlet;
import mx.edu.utez.pruebagit.dao.UserDao;
import mx.edu.utez.pruebagit.model.User;

import java.io.IOException;

@WebServlet(name = "registrarUsuarioServlet", value = "/sign_in")
public class registrarUsuarioServlet extends HttpServlet {
    //init, destroy y doPost y/o doGet

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Aqui se va a conectar la base de datos para ubtener un usuario
        //Y en dado caso de que exita mandarlo al sistema (otra vista)

        String user_name = req.getParameter("user_name");
        String pass1 = req.getParameter("pass1");
        String pass2 = req.getParameter("pass2");
        String email = req.getParameter("email");


        User u = new User();
        u.setUser_name(user_name);
        if (pass1.equals(pass2)) {
            u.setPass(pass1);
        }else{//Tus contraseñas no son iguales
            resp.sendRedirect("registrarUsuario.jsp");
        }
        u.setEmail(email);
        UserDao dao = new UserDao();

        if(dao.insert(u)){
            //Si se incerto
        }else{
            //que nel
        }
        resp.sendRedirect("verUsuario.jsp");

        String ruta = "index.jsp";
        if(u.getUser_name() != null){
            //Que el usuario si existe en la base de datos
            ruta = "bienvenido.jsp";

        }else {
            //quiere decir que el usuario no existe
            HttpSession session = req.getSession();
            session.setAttribute("mensaje","El usuario no existe en la base de datos " );
        }
        resp.sendRedirect(ruta);
    }

    public void destroy() {

    }

    public void init() throws ServletException {

    }
}
