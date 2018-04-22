package ticket.user;

public class User {
	
	private Long idUser;
	private String username;
	private String role;
	
	public final static String IS_EXISTING_USER = "Select * From User_role where username = ";

	
	public User(){}
	
	public User(String username, String role) {
		this.username = username;
		this.role = role;
	}

	public Long getIdUser() {
		return idUser;
	}

	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	
	

}
