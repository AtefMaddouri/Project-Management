package tn.esprit.pidev.timesheet.entities;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import tn.esprit.pidev.entities.Employee;

@Entity
public class Ticket implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id ;
	
	
	private String title;
	private String description;
	private Long estimatedHours;
	private Long duration;
	private LocalDate DateBegin;
	private LocalDate dateEnd;
	private int sprint;
	
	@Enumerated(EnumType.STRING)
	private Status status;
	
	@ManyToOne(cascade = CascadeType.MERGE )
	private Project project;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Employee employee;
	
	
	public Ticket() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Ticket(String title, String description, Long estimatedHours, Long duration) {
		super();
		this.title = title;
		this.description = description;
		this.estimatedHours = estimatedHours;
		this.duration = duration;
	}
	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getEstimatedHours() {
		return estimatedHours;
	}

	public void setEstimatedHours(Long estimatedHours) {
		this.estimatedHours = estimatedHours;
	}

	public Long getDuration() {
		return duration;
	}

	public void setDuration(Long duration) {
		this.duration = duration;
	}


	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public LocalDate getDateBegin() {
		return DateBegin;
	}

	public void setDateBegin(LocalDate dateBegin) {
		DateBegin = dateBegin;
	}

	public LocalDate getDateEnd() {
		return dateEnd;
	}

	public void setDateEnd(LocalDate dateEnd) {
		this.dateEnd = dateEnd;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}


	public int getSprint() {
		return sprint;
	}



	public void setSprint(int sprint) {
		this.sprint = sprint;
	}

	@Override
	public String toString() {
		return "Ticket [id=" + id + ", title=" + title + ", description=" + description + ", estimatedHours="
				+ estimatedHours + ", duration=" + duration + ", DateBegin=" + DateBegin + ", dateEnd=" + dateEnd
				+ ", status=" + status + ", project=" + project + ", sprint=" + sprint + "]";
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	

	
}
