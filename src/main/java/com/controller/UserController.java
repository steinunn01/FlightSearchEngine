package main.java.com.controller;

import main.java.com.model.User;
import main.java.com.model.UserView;

import java.util.List;

public class UserController {
    private List<User> users;

    //Þarf að takka þetta út.
    private UserView userView;

    public UserController(List<User> users, UserView userView) {
        this.users = users;
        this.userView = userView;
    }

    public void register(User user) {
        users.add(user);
    }

    public void unregister(User user) {
        users.remove(user);
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public String getUserKennitala(User user) {
        return user.getKennitala();
    }

    public void setUserKennitala(User user, String kennitala) {
        user.setKennitala(kennitala);
    }

    public String getUserNafn(User user) {
        return user.getNafn();
    }

    public void setUserNafn(User user, String nafn) {
        user.setNafn(nafn);
    }

    public String getUserEmail(User user) {
        return user.getEmail();
    }

    public void setUserEmail(User user, String email) {
        user.setEmail(email);
    }

    public String getUserPassword(User user) {
        return user.getPassword();
    }
    public void setUserPassword(User user, String password) {
        user.setPassword(password);
    }

    public void updateUserView(List<User> users) {
        userView.printUsers(users);
    }
}
