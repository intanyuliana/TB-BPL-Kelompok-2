package tb_bpl;

public class User implements Comparable<User>{
	String username;
	String login;
	String email;
	String pas;
	
	public User(String username, String date, String email, String pas) {
		this.username = username;
		this.login = date;
		this.email = email;
		this.pas = pas;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
//	public String getLogin() {
//		return login;
//	}
//	public void setLogin(String date) {
//		this.login = date;
//	}
//	public String getEmail() {
//		return email;
//	}
//	public void setEmail(String email) {
//		this.email = email;
//	}
//	public String getPas() {
//		return pas;
//	}
//	public void setPas(String pas) {
//		this.pas = pas;
//	}
	
	
	@Override
	public int compareTo(User x) {
		if (this.username == x.getUsername()) {
			return 0;
		}
		else {
			return 1;
		}
			
	}
}

//class Compare implements Comparator<User>{
//
//	@Override
//	public int compare(User o1, User o2) {
//		return o1.getUsername().compareTo(o2.getUsername());
//	}
//	
//}
