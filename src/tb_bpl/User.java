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


