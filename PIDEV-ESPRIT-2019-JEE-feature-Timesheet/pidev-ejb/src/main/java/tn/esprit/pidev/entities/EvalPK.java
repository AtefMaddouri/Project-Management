package tn.esprit.pidev.entities;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class EvalPK implements Serializable{


	private static final long serialVersionUID = 1L;
	private Long idUser ;
	private Long idObjective ;
	
	public EvalPK() {}
	
	public EvalPK(Long idUser, Long idObjective) {
		super();
		this.idUser = idUser;
		this.idObjective = idObjective;
	}


	public Long getIdUser() {
		return idUser;
	}




	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}




	public Long getIdObjective() {
		return idObjective;
	}
	public void setIdObjective(Long idObjective) {
		this.idObjective = idObjective;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	@Override
	public boolean equals(Object obj) {
		EvalPK evalId ;
		if(obj!=null)
		{
			evalId = (EvalPK) obj;
		return (evalId.getIdObjective().equals(this.getIdObjective())
				&& (evalId.getIdUser().equals(this.getIdUser())));
		}
		
		return false;
	}
	
	
	
}
