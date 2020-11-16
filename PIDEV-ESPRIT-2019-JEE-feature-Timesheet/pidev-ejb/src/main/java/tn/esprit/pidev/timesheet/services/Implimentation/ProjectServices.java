package tn.esprit.pidev.timesheet.services.Implimentation;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.esprit.pidev.entities.Team;
import tn.esprit.pidev.timesheet.entities.Project;
import tn.esprit.pidev.timesheet.entities.Status;
import tn.esprit.pidev.timesheet.entities.Ticket;
import tn.esprit.pidev.timesheet.services.Interfaces.IProjectService;

@Stateless
@LocalBean
public class ProjectServices implements IProjectService {

	@PersistenceContext
	EntityManager em ;
	
	@Override
	public void addProject(Project project) {
		// TODO Auto-generated method stub
		project.setStatus(Status.ToDo);
		em.persist(project);
	}

	@Override
	public void updateProject(Project project) {
		// TODO Auto-generated method stub
		em.merge(project);
	}

	@Override
	public void deleteProject(long idProject) {
		// TODO Auto-generated method stub
		em.remove(em.find(Project.class, idProject));
	}

	@Override
	public List<Project> getProjects() {
		// TODO Auto-generated method stub
		List<Project> projects = em.createQuery("from Project", Project.class).getResultList();
		return projects;
	}

	@Override
	public List<Project> getProjectsByTeam(long idTeam) {
		// TODO Auto-generated method stub
		Query query = em.createQuery("select p from Project p where p.team.id =:idTeam", Project.class);
		query.setParameter("idTeam",idTeam);
		List<Project> projects = query.getResultList();
		return projects;
	}
	
	@Override
	public Project getProjectByID(long idProject) {
		// TODO Auto-generated method stub
		return em.find(Project.class, idProject);
	}

	@Override
	public List<Team> getTeams() {
		// TODO Auto-generated method stub
		List<Team> teams = em.createQuery("from Team", Team.class).getResultList();
		return teams;
	}

	@Override
	public List<Ticket> getProjectTicketsByProjectID(long idProject) {
		// TODO Auto-generated method stub
		List<Ticket> tickets = new ArrayList<Ticket>();
		 tickets = em.find(Project.class, idProject).getTickets().stream().collect(Collectors.toList());
		 //if(tickets.size()!=0) {
			 return tickets;
//		 }
//		 else {
//			 return new ArrayList<Ticket>();
//		 }
	}


	
	
	
}
