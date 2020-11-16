package tn.esprit.pidev.entities;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class FeedbackPK implements Serializable{

	private static final long serialVersionUID = 1L;

	private Long idEval360;
	
	private Long idGivenByEmployee;

	
	
	public FeedbackPK(Long idEval360, Long idEmployee) {
		super();
		this.idEval360 = idEval360;
		this.idGivenByEmployee = idEmployee;
	}

	public Long getIdEval360() {
		return idEval360;
	}

	public void setIdEval360(Long idEval360) {
		this.idEval360 = idEval360;
	}

	public Long getIdEmployee() {
		return idGivenByEmployee;
	}

	public void setIdEmployee(Long idEmployee) {
		this.idGivenByEmployee = idEmployee;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}
