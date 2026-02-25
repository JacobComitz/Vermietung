package de.arvato.vermietung.model;

public class User {

    private boolean admin;
    private boolean user;

    public void checkAdminLogin(String email, String password) {
        admin = email.equals("admin") && password.equals("admin");
    }

    public boolean isAdmin() {
        return admin;
    }

    public void checkUserLogin(String email, String password) {
        user = email.equals("user") && password.equals("user");
    }
    public boolean isUser(){
        return user;
    }
}
