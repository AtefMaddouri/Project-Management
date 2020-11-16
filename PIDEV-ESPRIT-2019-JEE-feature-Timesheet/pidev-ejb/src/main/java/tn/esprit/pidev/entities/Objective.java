package tn.esprit.pidev.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import tn.esprit.pidev.entities.enums.ObjectiveCategory;


@Entity
public class Objective implements Serializable {

	private static final long serialVersionUID = 12L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String description;
	private LocalDate dateBegin;
	private LocalDate dateEnd;
	@Enumerated(EnumType.STRING)
	private ObjectiveCategory category;
	
	

	@OneToMany(mappedBy = "objective", cascade = CascadeType.MERGE)
	private List<Evaluation> evaluations;
	
	
	

	public Objective() {
	}

	public Objective(String name, String description, LocalDate dateBegin, LocalDate dateEnd, ObjectiveCategory category) {
		this.name = name;
		this.description = description;
		this.dateBegin = dateBegin;
		this.dateEnd = dateEnd;
		this.category = category;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	

	public ObjectiveCategory getCategory() {
		return category;
	}

	public void setCategory(ObjectiveCategory category) {
		this.category = category;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getDateBegin() {
		return dateBegin;
	}

	public void setDateBegin(LocalDate dateBegin) {
		this.dateBegin = dateBegin;
	}

	public LocalDate getDateEnd() {
		return dateEnd;
	}

	public void setDateEnd(LocalDate dateEnd) {
		this.dateEnd = dateEnd;
	}



	public List<Evaluation> getEvaluations() {
		return evaluations;
	}

	public void setEvaluations(List<Evaluation> evaluations) {
		this.evaluations = evaluations;
	}

	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	


	@Override
	public String toString() {
		return "Objective [id=" + id + ", name=" + name + ", description=" + description + ", dateBegin=" + dateBegin
				+ ", dateEnd=" + dateEnd + ", category=" + category.toString() +  "]";
	}
	

	

}
