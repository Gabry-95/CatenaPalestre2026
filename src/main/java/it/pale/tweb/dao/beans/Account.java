package it.pale.tweb.dao.beans;

public class Account {

	private String username;
	private String password;
	private int matricola;
	
	
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Account(String username, String password, int matricola) {
		super();
		this.username = username;
		this.password = password;
		this.matricola= matricola;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	public int getMatricola() {
		return matricola;
	}

	public void setMatricola(int matricola) {
		this.matricola = matricola;
	}
	
}
