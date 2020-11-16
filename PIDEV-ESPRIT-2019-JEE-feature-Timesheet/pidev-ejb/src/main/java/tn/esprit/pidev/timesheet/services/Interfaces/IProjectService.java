package tn.esprit.pidev.timesheet.services.Interfaces;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.pidev.entities.Employee;
import tn.esprit.pidev.entities.Team;
import tn.esprit.pidev.timesheet.entities.Project;
import tn.esprit.pidev.timesheet.entities.Ticket;

@Remote
public interface IProjectService {

	public void addProject(Project ticket);
	public void updateProject(Project ticket);
	public void deleteProject(long idTicket);
	public List<Project> getProjects();
	public List<Project> getProjectsByTeam(long idTeam);
	public Project getProjectByID(long idProject);
	public List<Team> getTeams();
	public List<Ticket> getProjectTicketsByProjectID(long idProject);
	
}
