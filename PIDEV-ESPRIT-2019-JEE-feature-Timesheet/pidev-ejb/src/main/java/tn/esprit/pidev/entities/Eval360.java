package tn.esprit.pidev.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Eval360 implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String evalDetails;
	
	@OneToMany(mappedBy = "eval360")
	private List<Feedback> feedbacks = new ArrayList<Feedback>();
	
	@OneToOne
	private Employee concernedEmployee;

	public Eval360(String evalDetails, List<Feedback> feedbacks, Employee concernedEmployee) {
		super();
		this.evalDetails = evalDetails;
		this.feedbacks = feedbacks;
		this.concernedEmployee = concernedEmployee;
	}
	
	

	public Eval360(String evalDetails) {
		super();
		this.evalDetails = evalDetails;
	}



	public Eval360() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEvalDetails() {
		return evalDetails;
	}

	public void setEvalDetails(String evalDetails) {
		this.evalDetails = evalDetails;
	}

	public List<Feedback> getFeedbacks() {
		return feedbacks;
	}

	public void setFeedbacks(List<Feedback> feedbacks) {
		this.feedbacks = feedbacks;
	}

	public Employee getConcernedEmployee() {
		return concernedEmployee;
	}

	public void setConcernedEmployee(Employee concernedEmployee) {
		this.concernedEmployee = concernedEmployee;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
