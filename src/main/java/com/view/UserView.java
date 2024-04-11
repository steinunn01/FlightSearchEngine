package main.java.com.view;

import java.util.List;

public class UserView {
    private UserController controller;
    
    public void printUsers(List<User> users) {
        for (User user : users) {
            System.out.println("Name: " + user.getNafn());
            System.out.println("Email: " + user.getEmail());
            System.out.println("Kennitala: " + user.getKennitala());
            System.out.println("Password: " + user.getPassword());
        }
    }
}
