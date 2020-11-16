package tn.esprit.pidev.entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

import tn.esprit.pidev.entities.enums.DepartementEnum;

@Entity
public class Team implements Serializable{

	private static final long serialVersionUID = 21L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String teamName;
	
	@JsonProperty("creationDateTime")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	@JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
	private LocalDateTime creationDateTime;
	@Enumerated(EnumType.STRING)
	private DepartementEnum departementEnum;
	@OneToMany(mappedBy="team" ,cascade=CascadeType.ALL,fetch = FetchType.EAGER)
	@JsonBackReference(value="employees")
	private Set<Employee> employees = new HashSet<Employee>();
	
	@OneToOne
	private Manager manager;
	
	public Team(String teamName, DepartementEnum departement) {
		super();
		this.teamName = teamName;
		this.departementEnum = departement;
		this.creationDateTime = LocalDateTime.now();
		
	}
	
	public Team() {
		super();
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public LocalDateTime getCreationDateTime() {
		return creationDateTime;
	}

	public void setCreationDateTime(LocalDateTime creationDateTime) {
		this.creationDateTime = creationDateTime;
	}

	


	public DepartementEnum getDepartementEnum() {
		return departementEnum;
	}

	public void setDepartementEnum(DepartementEnum departementEnum) {
		this.departementEnum = departementEnum;
	}

	public Set<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}

	public Manager getManager() {
		return manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}
	


	@Override
	public boolean equals(Object obj) {
		Team team = (Team) obj;
		return (team.getId().equals(this.getId()));

	}
	
	
	
}
