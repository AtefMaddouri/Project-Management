package tn.esprit.pidev.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class Admin extends User{


	private static final long serialVersionUID = 1L;
	private LocalDate birthday;
	private String phoneNumber;
	
	
	
	
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Admin(String userName, String lastName, String firstName, String email, String password) {
		super(userName, lastName, firstName, email, password);
		// TODO Auto-generated constructor stub
	}

	public Admin(String userName, String lastName, String firstName, String email, String password, LocalDate birthday,
			String phoneNumber) {
		super(userName, lastName, firstName, email, password);
		this.birthday = birthday;
		this.phoneNumber = phoneNumber;
	}

	public LocalDate getBirthday() {
		return birthday;
	}

	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	
}
