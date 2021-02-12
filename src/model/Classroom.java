package model;

	import java.util.List;
	import java.util.ArrayList;

	public class Classroom {

		private List<UserAccount> users;
		
		public Classroom() {
			users = new ArrayList<UserAccount>();
			
		}
		
		public void addUsers(String na, String pass, String pic, String gen, String car, String birth, String brow) {
			users.add(new UserAccount(na, pass, pic, gen, car, birth, brow));
		}
		
		public List<UserAccount> getUsers(){
			return users; 
		}
	}
	
	//dentro de createAccount metodo del boton, llamo classroom.addUsers(na, pass, pic, gen, car, birth, brow));
	
