package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import database.Database;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import model.User;

public class UserController {

	public UserController() {
		
	}
	
	public User login(String email, String password) {
		
		if (email.isEmpty() || password.isEmpty()) {
			Alert a = new Alert(AlertType.ERROR);
			a.setHeaderText("Fill all the required Credentials");
			a.show();
			return null;
		}
		
		try {
//			String query = String.format("SELECT * FROM user"
//					+ "WHERE Email = '%s' AND Password = '%s'", email, password);
			String query = "SELECT * FROM user WHERE email = ? AND password = ?";
			PreparedStatement ps = Database.getInstance().preparedStatment(query);
			ps.setString(1, email);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				String username = rs.getString("Username");
				int id = rs.getInt("UserId");
				int roleId = rs.getInt("RoleId");
				
				return new User(id, username, email, password, roleId);
			}else {
				Alert a = new Alert(AlertType.ERROR);
				a.setHeaderText("Wrong Credentials");
				a.show();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return null;
	}
}
