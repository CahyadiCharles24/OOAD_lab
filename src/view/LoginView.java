package view;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import view_controller.ViewController;

public class LoginView extends VBox{
	private VBox container;
	private Label lbl;
	private TextField usernameTf;
	private PasswordField passwordPf;
	private Button btn;
	private ViewController vc =  ViewController.getInstance();
	
	private void init() {
		container = new VBox();
		lbl = new Label("Login");
		usernameTf = new TextField();
		passwordPf = new PasswordField();
		btn = new Button("Login");
		
		this.usernameTf.setPromptText("Username");
		this.passwordPf.setPromptText("Password");
	}
	
	private void setLayout() {
		this.container.getChildren().addAll(lbl, usernameTf, passwordPf, btn);
		this.getChildren().add(this.container);
	}
	
	public LoginView() {
		init();
		setLayout();
	}
}
