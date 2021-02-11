package model;

	import java.util.List;
	import java.util.ArrayList;

	public class Classroom {

		private List<UserAccount> users;
		
		public Classroom() {
			users = new ArrayList<>();
		}
		
		public void addUsers(String na, String gen, String car, String birth, String brow) {
			users.add(new UserAccount(na, gen, car, birth, brow));
		}
		
		public List<UserAccount> getUsers(){
			return users; 
		}
	}