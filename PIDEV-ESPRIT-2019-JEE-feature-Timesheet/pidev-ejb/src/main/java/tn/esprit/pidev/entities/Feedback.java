package tn.esprit.pidev.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Feedback implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private FeedbackPK feedbackPK;

	private String comment;
	private Date feedbackDate;


	@ManyToOne
	@JoinColumn(name = "idGivenByEmployee", updatable = false, insertable = false, referencedColumnName = "id")
	private Employee employee;

	@ManyToOne
	@JoinColumn(name = "idEval360", updatable = false, insertable = false, referencedColumnName = "id")
	private Eval360 eval360;

	public Feedback(String comment, Employee employee, Eval360 eval360) {

		this.feedbackDate = new Date();
		this.comment = comment;
		this.employee = employee;
		this.eval360 = eval360;

	}


	public String getFeedbackContent() {
		return comment;
	}

	public void setFeedbackContent(String comment) {
		this.comment = comment;
	}

	public Date getFeedbackDate() {
		return feedbackDate;
	}

	public void setFeedbackDate(Date feedbackDate) {
		this.feedbackDate = feedbackDate;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Eval360 getEval360() {
		return eval360;
	}

	public void setEval360(Eval360 eval360) {
		this.eval360 = eval360;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public FeedbackPK getFeedbackPK() {
		return feedbackPK;
	}




}
