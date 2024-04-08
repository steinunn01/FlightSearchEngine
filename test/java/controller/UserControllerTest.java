package test.java.controller;

import main.java.controller.UserController;
import main.java.model.User;
import main.java.view.UserView;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class UserControllerTest {

    private UserController userController;
    private User mockUser = new User("098765-4321", "Jóna Jónsdóttir", "jonajons@job.is", "Lykilorð");

    @Before
    public void setUp() {
        userController = new UserController(MockUsers(), new UserView());
    }

    @After
    public void tearDown() {
        userController = null;
    }

    @Test
    public void TestRegister() {
        userController.register(mockUser);
        assertEquals(6, userController.getUsers().size());
        assertEquals("098765-4321", userController.getUsers().get(5).getKennitala());
        assertEquals("Jóna Jónsdóttir", userController.getUsers().get(5).getNafn());
        assertEquals("jonajons@job.is", userController.getUsers().get(5).getEmail());
        assertEquals("Lykilorð", userController.getUsers().get(5).getPassword());
    }

    @Test
    public void TestUnregister() {
        userController.register(mockUser);
        userController.unregister(mockUser);
        assertEquals(5, userController.getUsers().size());
    }

    @Test
    public void setgetUsers() {
        userController.setUsers(MockUsers());
        List<User> TrueUsers = userController.getUsers();

        // Compare the contents of the lists
        assertEquals(MockUsers().size(), TrueUsers.size());
        for (int i = 0; i < MockUsers().size(); i++) {
            User mockUser1 = MockUsers().get(i);
            User mockUser2 = TrueUsers.get(i);
            assertEquals(mockUser2.getKennitala(), mockUser1.getKennitala());
            assertEquals(mockUser2.getNafn(), mockUser1.getNafn());
            assertEquals(mockUser2.getEmail(), mockUser1.getEmail());
            assertEquals(mockUser2.getPassword(), mockUser1.getPassword());
        }
    }

    @Test
    public void setgetUserKennitala() {
        for (User user : userController.getUsers()) {
            userController.setUserKennitala(user, "098765-4321");
            assertEquals("098765-4321", userController.getUserKennitala(user));
        }
    }

    @Test
    public void setgetUserNafn() {
        for (User user : userController.getUsers()) {
            userController.setUserNafn(user, "Jóna Jónsdóttir");
            assertEquals("Jóna Jónsdóttir", userController.getUserNafn(user));
        }
    }

    @Test
    public void setgetUserEmail() {
        for (User user : userController.getUsers()) {
            userController.setUserEmail(user, "jonajons@job.is");
            assertEquals("jonajons@job.is", userController.getUserEmail(user));
        }
    }

    @Test
    public void setgetUserPassword() {
        for (User user : userController.getUsers()) {
            userController.setUserPassword(user, "Lykilorð");
            assertEquals("Lykilorð", userController.getUserPassword(user));
        }
    }

    public List<User> MockUsers() {
        List<User> mock = new ArrayList<>();
        mock.add(new User("123456-7890", "Anna B", "annnb@me.com", "passw0rd1"));
        mock.add(new User("223456-7890", "Benni B", "bennib@me.com", "passw0rd2"));
        mock.add(new User("323456-7890", "Chris Hjálmarsson", "chrish@actor.com", "passw0rd3"));
        mock.add(new User("423456-7890", "Díana Jónsdóttir", "diana@prinsessa.is", "passw0rd4"));
        mock.add(new User("523456-7890", "Elías Búi Ólafsson", "ebo@batur.is", "passw0rd5"));
        return mock;
    }
}
