package test.java.com.mock;

import main.java.com.controller.UserController;
import main.java.model.com.User;
import main.java.com.view.UserView;

import java.util.ArrayList;
import java.util.List;

public class UserMock {
    public static void main(String[] args) {
        List<User> users = getUsersfromDB();
        UserView userView = new UserView();
        UserController userController = new UserController(users, userView);
        userController.updateUserView(users);
    }

    private static List<User> getUsersfromDB() {
        List<User> mock = new ArrayList<>();
        mock.add(new User("123456-7890", "Anna B", "annnb@me.com", "passw0rd1"));
        mock.add(new User("223456-7890", "Benni B", "bennib@me.com", "passw0rd2"));
        mock.add(new User("323456-7890", "Chris Hjálmarsson", "chrish@actor.com", "passw0rd3"));
        mock.add(new User("423456-7890", "Díana Jónsdóttir", "diana@prinsessa.is", "passw0rd4"));
        mock.add(new User("523456-7890", "Elías Búi Ólafsson", "ebo@batur.is", "passw0rd5"));

        return mock;
    }
}
