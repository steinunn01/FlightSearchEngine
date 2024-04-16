package main.java.com.controller;
import java.io.IOException;
import main.java.com.model.User;
import main.java.com.model.UserView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.util.List;

public class UserController {
    private List<User> users;



@Controller
public class LoginController implements Initializable{

	@FXML
    private Button btnLogin;

    @FXML
    private PasswordField password;

    @FXML
    private TextField username;

    @FXML
    private Label lblLogin;
    
    
  
	@FXML
    private void login(ActionEvent event) throws IOException{
    	if(userService.authenticate(getUsername(), getPassword())){
    		    		
    		stageManager.switchScene(FxmlView.USER);
    		
    	}else{
    		lblLogin.setText("Login Failed.");
    	}
    }
	
	public String getPassword() {
		return password.getText();
	}

	public String getUsername() {
		return username.getText();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}

}
    /*
    //�arf a� takka �etta �t.
   // private UserView userView;

    // public UserController(List<User> users, UserView userView) {
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
    }*/
}