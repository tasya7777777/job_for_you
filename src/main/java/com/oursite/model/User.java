package main.java.com.oursite.model;

public class User {
private String email;
private String password;
private int id;
private int role;

@Override
public String toString() {
	return "User [email=" + email + ", password=" + password + ", id=" + id
			+ ", role=" + role + "]";
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public int getRole() {
	return role;
}

public void setRole(int role) {
	this.role = role;
}


}
