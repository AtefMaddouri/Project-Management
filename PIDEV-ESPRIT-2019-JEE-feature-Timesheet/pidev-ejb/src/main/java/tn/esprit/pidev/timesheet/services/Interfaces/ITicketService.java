package tn.esprit.pidev.timesheet.services.Interfaces;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.pidev.timesheet.entities.*;

@Remote
public interface ITicketService {
	
	public void addTicket(Ticket ticket);
	public void updateTicket(Ticket ticket);
	public void deleteTicket(Long idTicket);
	public List<Ticket> getTickets();
	public List<Ticket> getTicketsByProjectID(Long id);
	public List<Ticket> getTeam_TicketsByEmployeeID(Long employee_id, Status status);
	public List<Ticket> getTicketsTODO(Long employee_id);
	public List<Ticket> getTicketsInProgress(Long employee_id);
	public List<Ticket> getTicketsDONE(Long employee_id);
	
}
