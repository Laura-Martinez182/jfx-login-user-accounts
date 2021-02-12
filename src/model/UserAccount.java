package model;

public class UserAccount {
	
	private String username;
	private String password;
	private String pathPicture;
	private String gender;
	private String career;
	private String birthday;
	private String browser;

	public UserAccount(String na, String pass, String pic, String gen, String car, String birth, String brow) {
		username = na;
		password = pass;
		pathPicture = pic;
		gender = gen;
		career = car;
		birthday = birth;
		browser = brow;
	}
	
	public String getUserName() {
		return username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public String getPathPicture() {
		return pathPicture;
	}
	public String getGender() {
		return gender;
	}
	
	public String getCareer() {
		return career;
	}
	
	public String getBirthday() {
		return birthday;
	}
	
	public String getBrowser() {
		return browser;
	}
}
