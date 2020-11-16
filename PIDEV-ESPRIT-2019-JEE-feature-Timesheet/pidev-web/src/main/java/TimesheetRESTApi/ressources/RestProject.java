package TimesheetRESTApi.ressources;
import java.util.List;
import java.util.Set;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import tn.esprit.pidev.entities.Employee;
import tn.esprit.pidev.entities.Team;
import tn.esprit.pidev.timesheet.entities.Project;
import tn.esprit.pidev.timesheet.services.Implimentation.ProjectServices;

@Path("Project")
@javax.enterprise.context.RequestScoped
public class RestProject {

	@EJB
	ProjectServices projectServices;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{idProject}")
	public Response getProjectById(@PathParam(value="idProject") Long idProject) {

		try {
			Project project = projectServices.getProjectByID(idProject);
			return Response.status(Status.FOUND).entity(project).build();
		}
		catch(Exception e) {
			return Response.status(Status.NOT_FOUND).entity("la liste des projets est vides").build();
		}

	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getProjects() {

		try {
			List<Project> projects = projectServices.getProjects();
			return Response.status(Status.FOUND).entity(projects).build();
		}
		catch(Exception e) {
			return Response.status(Status.NOT_FOUND).entity("la liste des projets est vides").build();
		}

	}
	
	
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{Team/idProject}")
	public Response getTeamEmployees(@PathParam(value="idProject") Long idProject) {

		try {
			Set<Employee> projects = projectServices.getProjectByID(idProject).getTeam().getEmployees();
			return Response.status(Status.FOUND).entity(projects).build();
		}
		catch(Exception e) {
			return Response.status(Status.NOT_FOUND).entity("la liste des projets est vides").build();
		}

	}


	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response add(Project e) {

		try {
			projectServices.addProject(e);
			return Response.status(Status.CREATED).entity("votre projet a été ajouté avec succés").build();
		}
		catch(Exception ex) {
			return Response.status(Status.NOT_ACCEPTABLE).entity("votre projet n'est pas accepté").build();
		}

	} 

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Response update(Project e) {
		try {
			projectServices.updateProject(e);
			return Response.status(Status.ACCEPTED).entity("votre projet a été modifié avec succés").build();
		}
		catch(Exception ex) {
			return Response.status(Status.NOT_ACCEPTABLE).entity("le projet à modifier n'existe pas dans la base").build();
		}

	} 

	@DELETE
	@Path("{idProject}")
	public Response delete(@PathParam(value="idProject") Long idProject) {

		projectServices.deleteProject(idProject);
		return Response.status(Status.GONE).entity("votre projet a été supprimé avec succés").build();
	}




}
