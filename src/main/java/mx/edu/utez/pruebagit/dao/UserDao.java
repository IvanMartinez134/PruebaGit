package mx.edu.utez.pruebagit.dao;

import mx.edu.utez.pruebagit.model.User;
import mx.edu.utez.pruebagit.utils.DatabaseConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {

    //Para la lectura de una entidad en una base de datos
    public User getOne(String user_name,String pass) {
        User u = new User();
        //Los simbolos ? son para evitar la inyección de codigo SQL
        String query = "select * from users where user_name = ? and pass = sha2(?,256)";

        try {
            //Conectarme a la base de datos
            Connection con = DatabaseConnectionManager.getConnection();
            //Me prepara la consulta para ser ejecutada
            PreparedStatement ps = con.prepareStatement(query);
            //Voy a definir los parametros del query (los "?")
            ps.setString(1, user_name);
            ps.setString(2, pass);
            //Ejecutar la consulta
            ResultSet rs = ps.executeQuery();
            //Obtener la informacion del result set
            if(rs.next()) {
                //que el usuario si existe en la base de datos
                u.setUser_name(rs.getString("user_name"));
                u.setPass(rs.getString("pass"));
                u.setEmail(rs.getString("email"));
                u.setCody(rs.getString("cody"));
            }
        }catch (SQLException e) {
            e.printStackTrace();

        }

        return u;
    }

    public boolean insert(User user) {
        boolean flag = false;
        String query = "insert into users (user_name,pass,email) values(?,?,?)";

        try {
            Connection con = DatabaseConnectionManager.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, user.getUser_name());
            ps.setString(2, user.getPass());
            ps.setString(3, user.getEmail());
            if(ps.executeUpdate() == 1) {
                flag = true;// si se inserto el dato
            }
        }catch(SQLException e){
            e.printStackTrace();
        }

        return flag;
    }

}
