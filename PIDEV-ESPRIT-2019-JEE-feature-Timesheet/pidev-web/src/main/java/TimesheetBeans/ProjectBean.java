package TimesheetBeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;
import javax.faces.model.SelectItemGroup;

import tn.esprit.pidev.entities.Team;
import tn.esprit.pidev.timesheet.entities.Project;
import tn.esprit.pidev.timesheet.services.Implimentation.ProjectServices;


@ManagedBean
@SessionScoped
public class ProjectBean implements Serializable {

    private static final long serialVersionUID= 1L;
    private List<SelectItem> Teams_ProjectsList =new ArrayList<SelectItem>() ;
	private List<Project> projects =new ArrayList<>() ;
	private Project project;

	@EJB
	ProjectServices projectServices;
	
	


	public Project getProject() {
		return project;
	}


	public void setProject(Project project) {
		this.project = project;
	}


	public List<Project> getProjects() {
		return projects = projectServices.getProjects();
	}


	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}


	public List<SelectItem> getTeams_ProjectsList() {
		
		List<Team> teams = projectServices.getTeams() ;
		
		
		for(Team team : teams) {
			
			//creation d'un selectItemGroup pour l'affichage 
			SelectItemGroup team_projects  = new SelectItemGroup(team.getTeamName());
			
			//recuperer la liste des projets de l'instance team
			List<Project> projects = projectServices.getProjectsByTeam(team.getId());
			
			SelectItem[] listItems = new SelectItem[projects.size()] ;
			int i =0;
			
			       for(Project p : projects) {
			    	   SelectItem selectItem =  new SelectItem( p.getTitle() , p.getTitle());
			    	   listItems[i]=selectItem;
			    	   i++;
			       }
			
			 team_projects.setSelectItems(listItems);
			 Teams_ProjectsList.add(team_projects);
		}
		

		return Teams_ProjectsList;
	}



	
	
}
