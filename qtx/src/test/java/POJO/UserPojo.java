package POJO;

public class UserPojo {
	public String first_name;
	public String last_name;
	public String id;
	public String avatar;
	public String email;
	
	public UserPojo(String first_name, String last_name, String id, String avatar, String email) {
		this.first_name = first_name;
		this.last_name = last_name;
		this.id = id;
		this.avatar = avatar;
		this.email = email;
	}
	public void PrintUser() {
		System.out.println("First Name: " + first_name);
		System.out.println("Last Name: " + last_name);
		System.out.println("ID: " + id);
		System.out.println("Avatar: " + avatar);
		System.out.println("Email: " + email);
	}
	
}
