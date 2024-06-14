package mx.edu.utez.pruebagit.model;

import java.io.Serializable;

//Bean es una estructura de datos que modela
//un objeto de la vida real, es util en diversos escenarios

public class User implements Serializable {
        private String user_name;
        private String email;
        private String pass;
        private String cody;

        //Siempre deben de tener los metodos de
        // constructores por lo menos el vacio
        //Y los getters y setters

        public User() {

        }
        public User(String user_name, String email, String pass, String cody) {
            this.user_name = user_name;
            this.email = email;
            this.pass = pass;
            this.cody = cody;
        }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getCody() {
        return cody;
    }

    public void setCody(String cody) {
        this.cody = cody;
    }
}
