package tn.esprit.pidev.timesheet.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

import tn.esprit.pidev.entities.Team;

@Entity
public class Project implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id ;
	
	private String title;
	private String description;
	@Enumerated(EnumType.STRING)
	private Status status;
	
	@OneToMany(mappedBy="project", cascade = CascadeType.MERGE , fetch=FetchType.EAGER )
	@JsonBackReference(value="tickets")
	private Set<Ticket> tickets = new HashSet<Ticket>();

	@ManyToOne(cascade = CascadeType.ALL)
	private Team team;
	
	public Project() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Status getStatus() {
		return status;
	}


	public void setStatus(Status status) {
		this.status = status;
	}

	public Team getTeam() {
		return team;
	}


	public void setTeam(Team team) {
		this.team = team;
	}


	public Project(String title, String description) {
		super();
		this.title = title;
		this.description = description;
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

	public Set<Ticket> getTickets() {
		return tickets;
	}

	public void setTickets(Set<Ticket> tickets) {
		this.tickets = tickets;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	
}
