package model;

import java.util.List;

import javafx.scene.image.Image;

import java.time.LocalDate;
import java.util.ArrayList;

	public class Classroom {

		private List<UserAccount> users;
		
		public Classroom() {
			users = new ArrayList<UserAccount>();
			
		}
		
		public void addUsers(String username, String password, Image picture, String gender, String career, LocalDate birthday, String browser) {
			users.add(new UserAccount(username, password, picture, gender, career, birthday, browser));
		}
		
		public List<UserAccount> getUsers(){
			return users; 
		}
	}
	
	
	
