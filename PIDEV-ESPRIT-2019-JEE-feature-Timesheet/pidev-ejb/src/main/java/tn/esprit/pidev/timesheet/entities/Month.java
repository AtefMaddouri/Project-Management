package tn.esprit.pidev.timesheet.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;
import javax.persistence.Id;

@Entity
public class Month implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id ;
	
	@Enumerated(EnumType.STRING)
	private MonthName name;
	private long workHoursPerDay;
	
	@OneToMany(cascade=CascadeType.ALL , mappedBy="month")
	private List<DayOFF> dayOFFs;

	public Month() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Month(MonthName name, long workHoursPerDay) {
		super();
		this.name = name;
		this.workHoursPerDay = workHoursPerDay;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public MonthName getName() {
		return name;
	}

	public void setName(MonthName name) {
		this.name = name;
	}

	public long getWorkHoursPerDay() {
		return workHoursPerDay;
	}

	public void setWorkHoursPerDay(long workHoursPerDay) {
		this.workHoursPerDay = workHoursPerDay;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public List<DayOFF> getDayOFFs() {
		return dayOFFs;
	}

	public void setDayOFFs(List<DayOFF> dayOFFs) {
		this.dayOFFs = dayOFFs;
	}
	
	
	
	
}
