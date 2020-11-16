package tn.esprit.pidev.entities;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Employee extends User{

	private static final long serialVersionUID = 1L;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate dateOfBirth;
	private String phoneNumber;
	private String gitLink;
	private String cvDetails;
	private float salary;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	private Team team;
	
	
	
	@OneToMany(mappedBy = "employee")
	@JsonBackReference(value="feedbacks")
	private Set<Feedback> feedbacks = new HashSet<Feedback>();
	
	@OneToOne(mappedBy = "concernedEmployee")
	private Eval360 eval360 ;

	public Employee(String userName, String lastName, String firstName, String email, String password,
			 LocalDate dateOfBirth, String phoneNumber) {
		super(userName, lastName, firstName, email, password);
		this.dateOfBirth = dateOfBirth;
		this.phoneNumber = phoneNumber;
	}
	public Employee(String userName, String lastName, String firstName, String email, String password,
			 LocalDate dateOfBirth, String phoneNumber, String gitLink, String cvDetails) {
		super(userName, lastName, firstName, email, password);
		this.dateOfBirth = dateOfBirth;
		this.phoneNumber = phoneNumber;
		this.gitLink = gitLink;
		this.cvDetails = cvDetails;
	}
	
	

	public Employee(String userName, String lastName, String firstName, String email, String password) {
		super(userName, lastName, firstName, email, password);
	}
	
	
	public Employee() {
		super();
	
	}
	
	
	public Team getTeam() {
		return team;
	}
	public void setTeam(Team team) {
		this.team = team;
	}
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getGitLink() {
		return gitLink;
	}
	public void setGitLink(String gitLink) {
		this.gitLink = gitLink;
	}
	public String getCvDetails() {
		return cvDetails;
	}
	public void setCvDetails(String cvDetails) {
		this.cvDetails = cvDetails;
	}
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Set<Feedback> getFeedbacks() {
		return feedbacks;
	}
	public void setFeedbacks(Set<Feedback> feedbacks) {
		this.feedbacks = feedbacks;
	}
	public Eval360 getEval360() {
		return eval360;
	}
	@Override
	public String toString() {
		return super.toString()+" Employee [dateOfBirth=" + dateOfBirth + ", phoneNumber=" + phoneNumber + "]";
	}
	public void setEval360(Eval360 eval360) {
		this.eval360 = eval360;
	}
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cvDetails == null) ? 0 : cvDetails.hashCode());
		result = prime * result + ((dateOfBirth == null) ? 0 : dateOfBirth.hashCode());
		result = prime * result + ((eval360 == null) ? 0 : eval360.hashCode());
		result = prime * result + ((feedbacks == null) ? 0 : feedbacks.hashCode());
		result = prime * result + ((gitLink == null) ? 0 : gitLink.hashCode());
		result = prime * result + ((phoneNumber == null) ? 0 : phoneNumber.hashCode());
		result = prime * result + Float.floatToIntBits(salary);
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (cvDetails == null) {
			if (other.cvDetails != null)
				return false;
		} else if (!cvDetails.equals(other.cvDetails))
			return false;
		if (dateOfBirth == null) {
			if (other.dateOfBirth != null)
				return false;
		} else if (!dateOfBirth.equals(other.dateOfBirth))
			return false;
		if (eval360 == null) {
			if (other.eval360 != null)
				return false;
		} else if (!eval360.equals(other.eval360))
			return false;
		
		if (feedbacks == null) {
			if (other.feedbacks != null)
				return false;
		} else if (!feedbacks.equals(other.feedbacks))
			return false;
		if (gitLink == null) {
			if (other.gitLink != null)
				return false;
		} else if (!gitLink.equals(other.gitLink))
			return false;
		if (phoneNumber == null) {
			if (other.phoneNumber != null)
				return false;
		} else if (!phoneNumber.equals(other.phoneNumber))
			return false;
		if (Float.floatToIntBits(salary) != Float.floatToIntBits(other.salary))
			return false;
		return true;
	}
	
	


}
