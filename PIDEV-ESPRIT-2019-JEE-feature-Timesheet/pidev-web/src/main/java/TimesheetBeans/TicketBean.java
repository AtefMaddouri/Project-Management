package TimesheetBeans;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.faces.model.SelectItemGroup;
import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.Null;

import tn.esprit.pidev.entities.Team;
import tn.esprit.pidev.timesheet.entities.Project;
import tn.esprit.pidev.timesheet.entities.Status;
import tn.esprit.pidev.timesheet.entities.Ticket;
import tn.esprit.pidev.timesheet.services.Implimentation.ProjectServices;
import tn.esprit.pidev.timesheet.services.Implimentation.TicketService;


@ManagedBean(name="ticketBean")
@SessionScoped
public class TicketBean implements Serializable {

	private static final long serialVersionUID= 1L;

	private Ticket ticket ; 
	private List<Ticket> tickets= new ArrayList<>();
	private List<Ticket> projectTickets  = new ArrayList<>() ;
	
	private List<SelectItem> Teams_ProjectsList;
	private long projectId;
	private List<Ticket> ticketsTODO =new ArrayList<>();
	private List<Ticket> ticketsDONE =new ArrayList<>();
	private List<Ticket> ticketsInProgress =new ArrayList<>();
	private int teamMemberNbrs;
	private int ticketsNbrs;
	private Boolean renderTableBoolean;
	
	@EJB
	TicketService ticketService;

	@EJB
	ProjectServices projectServices;
	
	//LEs accesseurs TicketView
	
	
	
	public Ticket getTicket() {

		if(this.ticket==null) {
			this.ticket = new Ticket();
		}
		return ticket;
	}

	public List<Ticket> getProjectTickets() {
		
		
		if(projectId==0) {
			return new ArrayList<>();
		}
		return projectServices.getProjectTicketsByProjectID(projectId);
	}

	public void setProjectTickets(List<Ticket> projectTickets) {
		this.projectTickets = projectTickets;
	}

	public int getTeamMemberNbrs() {
		
		if( this.projectId == 0 ) {
			 return 0;
		}
		else {
			 return  projectServices.getProjectByID(projectId).getTeam().getEmployees().size();
		}
		
		
	}

	public void setTeamMemberNbrs(int teamMemberNbrs) {
		this.teamMemberNbrs = teamMemberNbrs;
	}

	public int getTicketsNbrs() {
		
		if( this.projectId == 0 ) {
			 return 0;
		}
		else {
			return projectServices.getProjectTicketsByProjectID(projectId).size();
		}
		
	}

	public void setTicketsNbrs(int ticketsNbrs) {
		this.ticketsNbrs = ticketsNbrs;
	}

	

	public long getProjectId() {
		return projectId;
	}

	public void setProjectId(long projectId) {
		this.projectId = projectId;
	}

	public void setTeams_ProjectsList(List<SelectItem> teams_ProjectsList) {
		Teams_ProjectsList = teams_ProjectsList;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

	public List<Ticket> getTickets() {
		tickets = ticketService.getTickets();
		return tickets;
	}

	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}

	public List<SelectItem> getTeams_ProjectsList() {

		Teams_ProjectsList = new ArrayList<SelectItem>();
		List<Team> teams = projectServices.getTeams() ;

		for(Team team : teams) {

			//creation d'un selectItemGroup pour l'affichage 
			SelectItemGroup team_projects  = new SelectItemGroup(team.getTeamName());

			//recuperer la liste des projets de l'instance team
			
			List<Project> projects = projectServices.getProjectsByTeam(team.getId());

			ArrayList<SelectItem> selectItemsArray = new  ArrayList<SelectItem>();
		
			for(Project p : projects) {
				SelectItem selectItem =  new SelectItem( p.getId() , p.getTitle());
		
				selectItemsArray.add(selectItem);
			}

			team_projects.setSelectItems((SelectItem[]) selectItemsArray.toArray(new SelectItem[selectItemsArray.size()]));
			//team_projects.setSelectItems(listItems);
			Teams_ProjectsList.add(team_projects);
		}

		return Teams_ProjectsList;
	}
	
	//Accesseurs Kanban table
	
	public List<Ticket> getTicketsTODO() {
		return ticketService.getTicketsTODO(1L);
	}

	public void setTicketsTODO(List<Ticket> ticketsTODO) {
		this.ticketsTODO = ticketsTODO;
	}

	public List<Ticket> getTicketsDONE() {
		return ticketService.getTicketsDONE(1L);
	}

	public void setTicketsDONE(List<Ticket> ticketsDONE) {
		this.ticketsDONE = ticketsDONE;
	}

	public List<Ticket> getTicketsInProgress() {
		return ticketService.getTicketsInProgress(1L);
	}

	public void setTicketsInProgress(List<Ticket> ticketsInProgress) {
		this.ticketsInProgress = ticketsInProgress;
	}

	// les methodes  Ticket View


	public String getReqParam(String nameParam) {
		HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
		return req.getParameter(nameParam);
	}

	

	public void addTicket(){
		
		this.ticket.setEstimatedHours(Long.parseLong(getReqParam("estimation")));
		System.out.println("Atef Projet "+projectId);
		System.out.println(" Projet title "+projectServices.getProjectByID(projectId).getTitle());
		this.ticket.setProject(projectServices.getProjectByID(projectId));
		this.ticket.setStatus(Status.ToDo);		
		ticketService.addTicket(this.ticket);
		this.ticket= new Ticket();
		
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void updateTicket(Ticket ticket){
		
		ticketService.updateTicket(ticket);
		ticket = new Ticket();
	}

	public void deleteTicket(long idTicket){
		ticketService.deleteTicket(idTicket);
	}

	public TicketService getTicketService() {
		return ticketService;
	}

	public void setTicketService(TicketService ticketService) {
		this.ticketService = ticketService;
	}
	

	public Boolean getRenderTableBoolean() {
		if( this.projectId == 0 ) {
			 return false;
		}
		else {
			this.getProjectTickets();
			 return true;
		}
	}

	public void setRenderTableBoolean(Boolean renderTableBoolean) {
		this.renderTableBoolean = renderTableBoolean;
	}


	
}
