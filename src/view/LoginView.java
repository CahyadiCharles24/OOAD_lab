package view;

import controller.UserController;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import model.User;
import view_controller.ViewController;

public class LoginView extends VBox{
	private VBox container;
	private Label lbl;
	private TextField emailTf;
	private PasswordField passwordPf;
	private Button btn;
	private ViewController vc =  ViewController.getInstance();
	private UserController uc;
	
	private void init() {
		uc = new UserController();
		container = new VBox();
		lbl = new Label("Login");
		emailTf = new TextField();
		passwordPf = new PasswordField();
		btn = new Button("Login");
		
		this.emailTf.setPromptText("Email");
		this.passwordPf.setPromptText("Password");
	}
	
	private void setLayout() {
		this.container.getChildren().addAll(lbl, emailTf, passwordPf, btn);
		this.getChildren().add(container);
	}
	
	private void setEvent() {
		this.btn.setOnAction(e -> {
			handleLogin();
		});
	}
	
	private void handleLogin() {
		String email = emailTf.getText().toString();
		String password = passwordPf.getText().toString();
		
		User user = uc.login(email, password);
		if(user != null) {
			vc.navigateToHome();
		}
	}
	
	public LoginView() {
		init();
		setLayout();
		setEvent();
	}
}
