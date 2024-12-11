package view_controller;

import javafx.stage.Stage;
import view.AppView;
import view.HomeView;
import view.LoginView;

public class ViewController {
	private Stage stage;
	private AppView appView;
	private static ViewController instance;
	
	private ViewController() {
		
	}
	
	public static ViewController getInstance() {
		if(instance == null) {
			return instance = new ViewController();
		}
		return instance;
	}
	
	public void initialize(Stage stage, AppView appView) {
        this.stage = stage;
        this.appView = appView;
    }
	
	public void navigateToLogin() {
		LoginView lv= new LoginView();
		this.appView.setContent(lv);
		this.stage.setTitle("Login Page");
		this.stage.show();
	}
	
	public void navigateToHome() {
		HomeView hv= new HomeView();
		this.appView.setContent(hv);
		this.stage.setTitle("Home Page");
		this.stage.show();
	}
}
