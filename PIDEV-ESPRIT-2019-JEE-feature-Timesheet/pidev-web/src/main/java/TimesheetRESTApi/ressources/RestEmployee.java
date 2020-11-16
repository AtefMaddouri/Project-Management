package TimesheetRESTApi.ressources;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import tn.esprit.pidev.timesheet.entities.Ticket;
import tn.esprit.pidev.timesheet.services.Implimentation.TicketService;

@Path("Ticket")
@javax.enterprise.context.RequestScoped
public class RestEmployee {

	
	@EJB
	TicketService ticketService;

	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{idTeam}")
	public Response getTicketsByProject(@PathParam(value="idTeam") Long idTeam) {
		try {
			List<Ticket> ProjectTickets = ticketService.getTicketsByProjectID(idTeam);
			return Response.status(Status.FOUND).entity(ProjectTickets).build();
		}
		catch(Exception e) {
			return Response.status(Status.NOT_FOUND).entity("la liste des projets est vides").build();
		}
	}
	
}
