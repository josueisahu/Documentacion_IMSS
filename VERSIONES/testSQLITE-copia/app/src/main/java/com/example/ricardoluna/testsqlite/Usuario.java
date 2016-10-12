package com.example.ricardoluna.testsqlite;

/**
 * Created by RicardoLuna on 19/09/2016.
 */
public class Usuario {
    String Login, Password, Nombre;

    public Usuario() {
    }
    public Usuario(String login, String password, String nombre) {
        Login = login;
        Password = password;
        Nombre = nombre;
    }

    public String getLogin() {
        return Login;
    }

    public void setLogin(String login) {
        Login = login;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getPassword() {
        return Password;
    }
    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getNombre() {
        return Nombre;
    }
}
