package tn.esprit.pidev.timesheet.entities;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.*;

@Entity
public class DayOFF implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id ;
	
	private LocalDate dayDate;
	
	@Enumerated(EnumType.STRING)
	private TypeDayOFF typeDayOFF;

	@ManyToOne
	private Month month;
}
