package model;

import java.time.LocalDate;

import javafx.scene.image.Image;

public class UserAccount {
	
	private String username;
	private String password;
	private Image picture;
	private String gender;
	private String career;
	private LocalDate birthday;
	private String browser;

	public UserAccount(String username, String password, Image picture, String gender, String career, LocalDate birthday, String browser) {
		this.username = username;
		this.password = password;
		this.picture = picture;
		this.gender = gender;
		this.career = career;
		this.birthday = birthday;
		this.browser = browser;
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public Image getPicture() {
		return picture;
	}
	public String getGender() {
		return gender;
	}
	
	public String getCareer() {
		return career;
	}
	
	public LocalDate getBirthday() {
		return birthday;
	}
	
	public String getBrowser() {
		return browser;
	}
}
