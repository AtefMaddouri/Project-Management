package tn.esprit.pidev.timesheet.services.Implimentation;

import java.util.List;
import java.util.stream.Collectors;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.pidev.entities.Employee;
import tn.esprit.pidev.entities.Team;
import tn.esprit.pidev.timesheet.entities.Status;
import tn.esprit.pidev.timesheet.entities.Ticket;
import tn.esprit.pidev.timesheet.services.Interfaces.ITicketService;

@Stateless
@LocalBean
public class TicketService implements ITicketService {

	@PersistenceContext
	EntityManager em ;
	
	@Override
	public void addTicket(Ticket ticket) {
		// TODO Auto-generated method stub
		em.persist(ticket);
	}

	@Override
	public void updateTicket(Ticket ticket) {
		// TODO Auto-generated method stub
		em.merge(ticket);
	}

	@Override
	public void deleteTicket(Long idTicket) {
		// TODO Auto-generated method stub
		em.remove(em.find(Ticket.class, idTicket));
	}

	@Override
	public List<Ticket> getTickets() {
		// TODO Auto-generated method stub
		List<Ticket> tickets = em.createQuery("from Ticket", Ticket.class).getResultList();
		return tickets;
	}
	
	@Override
	public List<Ticket> getTicketsByProjectID(Long id) {
		// TODO Auto-generated method stub
		Query query = em.createQuery("select t from Ticket t where t.project.id =:id", Ticket.class);
		query.setParameter("id", id);
		List<Ticket> tickets = query.getResultList();
		return tickets;
	}

	@Override
	public List<Ticket> getTeam_TicketsByEmployeeID(Long employee_id, Status status) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Ticket> getTicketsTODO(Long employeeID) {
		// TODO Auto-generated method stub
		Query query = em.createQuery("select t "
				                   + "from Ticket t "
			                       + "where t.status=:statusTicket "
			                       + "and t.project.status=:status ");
			                       //+ "and t.project.team.id =:emp.team.id "
			                       //+ "and emp.id =:employeeID");
		query.setParameter("statusTicket",Status.ToDo);
		query.setParameter("status",Status.In_Progress);
		//query.setParameter("employeeID",employeeID);
		
		List<Ticket> tickets = query.getResultList();
		
		Team team = em.find(Employee.class, employeeID).getTeam();
		
		tickets = tickets.stream().filter(t ->{
			return t.getProject().getTeam().getId().equals(team.getId());
		}).collect(Collectors.toList());
		return tickets;
	}

	@Override
	public List<Ticket> getTicketsInProgress(Long employeeID) {
		// TODO Auto-generated method stub
		Query query = em.createQuery("select t "
				+ "from Ticket t "
				+ "where t.status=:statusTicket "
				+ "and t.project.status=:status "
				+ "and t.employee.id =:employeeID");
		query.setParameter("statusTicket",Status.In_Progress);
		query.setParameter("status",Status.In_Progress);
		query.setParameter("employeeID",employeeID);

		List<Ticket> tickets = query.getResultList();
		return tickets;
	}

	@Override
	public List<Ticket> getTicketsDONE(Long employeeID) {
		// TODO Auto-generated method stub
		Query query = em.createQuery("select t "
				+ "from Ticket t "
				+ "where t.status=:statusTicket "
				+ "and t.project.status=:status "
				+ "and t.employee.id =:employeeID");
		query.setParameter("statusTicket",Status.Done);
		query.setParameter("status",Status.In_Progress);
		query.setParameter("employeeID",employeeID);

		List<Ticket> tickets = query.getResultList();
		return tickets;
	}
	
	

}
