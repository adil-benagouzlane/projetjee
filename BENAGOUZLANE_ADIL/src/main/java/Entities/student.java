package Entities;

public class student {
	int id,Age;
	String Nom, Prenom,pass,login;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return Nom;
	}
	public void setNom(String nom) {
		Nom = nom;
	}
	public String getPrenom() {
		return Prenom;
	}
	public void setPrenom(String prenom) {
		Prenom = prenom;
	}
	public int getAge() {
		return Age;
	}
	@Override
	public String toString() {
		return "student [id=" + id + ", Nom=" + Nom + ", Prenom=" + Prenom + ", Age=" + Age + ", pass=" + pass
				+ ", login=" + login + "]";
	}
	public void setAge(int age) {
		Age = age;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}

}
