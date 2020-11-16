package tn.esprit.pidev.entities;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import tn.esprit.pidev.entities.enums.EvaluationStatus;

@Entity
public class Evaluation implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private EvalPK evalPK;
	private float mark;
	private LocalDateTime date;
	private String description;
	@Enumerated(EnumType.STRING)
	private EvaluationStatus status;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "idUser", referencedColumnName = "id", insertable = false, updatable = false)
	private User user;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "idObjective", referencedColumnName = "id", insertable = false, updatable = false)
	private Objective objective;

	
	// Start Constructors
	
	public Evaluation() {
	}

	public Evaluation(float mark, LocalDateTime date, String desription, EvaluationStatus status) {
		this.mark = mark;
		this.date = date;
		this.description = desription;
		this.status = status;
	}

	
	
	
	
	// End Constructors
	
	
	
	// Start Getter & Setters 
	
	
	
	
	
	public EvalPK getEvalPK() {
		return evalPK;
	}



	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setEvalPK(EvalPK evalPK) {
		this.evalPK = evalPK;
	}

	public float getMark() {
		return mark;
	}

	public void setMark(float mark) {
		this.mark = mark;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}



	public Objective getObjective() {
		return objective;
	}

	public void setObjective(Objective objective) {
		this.objective = objective;
	}
	
	public EvaluationStatus getStatus() {
		return status;
	}

	public void setStatus(EvaluationStatus status) {
		this.status = status;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	// End Getter & Setters //
	
	@Override
	public String toString() {
		return "Evaluation [evalPK=" + evalPK + ", mark=" + mark + ", date=" + date + ", description=" + description
				+ ", employe=" + user + ", objective=" + objective + "]";
	}
	
	
	public void copyEvaluation(Evaluation eval) {
		this.date = eval.date;
		this.description = eval.description;
		this.mark = eval.mark;
	}

}
