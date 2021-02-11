package model;

public class UserAccount {
	
	private String username;
	private String gender;
	private String career;
	private String birthday;
	private String browser;

	public UserAccount(String na, String gen, String car, String birth, String brow) {
		username = na;
		gender = gen;
		career = car;
		birthday = birth;
		browser = brow;
	}
	
	public String getUserName() {
		return username;
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
