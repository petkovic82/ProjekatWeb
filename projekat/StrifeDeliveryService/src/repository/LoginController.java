package rest;

import java.io.File;
import java.util.List;

import javax.servlet.ServletContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import dto.RestaurantViewDTO;
import dto.UserDTO;
import dto.UserViewDTO;
import model.Admin;
import model.Customer;
import model.Trener;
import model.Manager;
import model.User;
import repository.AdminRepository;
import repository.CustomerRepository;
import repository.TrenerRepository;
import repository.ManagerRepository;
import repository.SportsFacilityRepository;

@Path("login")
public class LoginController {

	CustomerRepository repoCustomer = new CustomerRepository();
	ManagerRepository repoManager = new ManagerRepository();
	AdminRepository repoAdmin = new AdminRepository();
	TrenerRepository repoDel = new TrenerRepository();
	SportsFacilityRepository repoRest = new SportsFacilityRepository();
	User user;
	List<String> usernames;

	@Context
	ServletContext ctx;

	@SuppressWarnings("unused")
	public void init() {
		if (ctx.getAttribute("username") == null) {
			String contextPath = ctx.getRealPath("");
			ctx.setAttribute("username", "");
		}
	}

	private String getDataDirPath() {
		return (ctx.getRealPath("") + "WEB-INF" + File.separator + "classes" + File.separator + "data"
				+ File.separator);
	}

	private void setLoggedInUser(String username) {
		ctx.setAttribute("username", username);
	}

	@POST
	@Path("logOut")
	@Produces(MediaType.TEXT_PLAIN)
	public String userLogOut() {
		ctx.setAttribute("username", "");
		return "Log Out Successful";
	}

	@POST
	@Path("userLogin")
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	public String userLogIn(UserDTO par) {

		String log = customerLogIn(par);
		if (log != "Username was not found")
			return log;

		log = trenerLogIn(par);
		if (log != "Username was not found")
			return log;

		log = managerLogIn(par);
		if (log != "Username was not found")
			return log;

		log = adminLogIn(par);
		if (log != "Username was not found")
			return log;

		return "Username was not found";
	}

	public String customerLogIn(UserDTO par) {
		repoCustomer.setBasePath(getDataDirPath());
		for (Customer u : repoCustomer.getAll()) {
			if (u.getId().equals(par.id)) {
				if (u.getPassword().equals(par.password)) {
					if(u.isBlocked()) {
						return "You are banned until 2/2/2222";
					}
					else {
						setLoggedInUser(par.id);
						return "Loggin successful";
					}
					
				} else {
					return "Incorrect password";
				}
			}
		}
		return "Username was not found";
	}

	public String adminLogIn(UserDTO par) {
		repoAdmin.setBasePath(getDataDirPath());
		for (Admin u : repoAdmin.getAll()) {
			if (u.getId().equals(par.id)) {
				if (u.getPassword().equals(par.password)) {
					setLoggedInUser(par.id);
					return "Loggin successful";
				} else {
					return "Incorrect password";
				}
			}
		}
		return "Username was not found";
	}

	public String managerLogIn(UserDTO par) {
		repoManager.setBasePath(getDataDirPath());
		for (Manager u : repoManager.getAll()) {
			if (u.getId().equals(par.id)) {
				if (u.getPassword().equals(par.password)) {
					if(u.isBlocked()) {
						return "You are banned until 2/2/2222";
					}
					else {
						setLoggedInUser(par.id);
						return "Loggin successful";
					}
				} else {
					return "Incorrect password";
				}
			}
		}
		return "Username was not found";
	}

	public String delivererLogIn(UserDTO par) {
		repoDel.setBasePath(getDataDirPath());
		for (Deliverer u : repoDel.getAll()) {
			if (u.getId().equals(par.id)) {
				if (u.getPassword().equals(par.password)) {
					if(u.isBlocked()) {
						return "You are banned until 2/2/2222";
					}
					else {
						setLoggedInUser(par.id);
						return "Loggin successful";
					}
				} else {
					return "Incorrect password";
				}
			}
		}
		return "Username was not found";
	}

	@GET
	@Path("activeUser")
	@Produces(MediaType.APPLICATION_JSON)
	public UserDTO getActiveAccount() {
		repoCustomer.setBasePath(getDataDirPath());
		repoManager.setBasePath(getDataDirPath());
		repoAdmin.setBasePath(getDataDirPath());
		repoDel.setBasePath(getDataDirPath());

		UserDTO retVal = new UserDTO();

		String username = (String) ctx.getAttribute("username");
		retVal.id = username;

		if (repoCustomer.read(username) != null)
			retVal.name = "CUSTOMER";
		else if (repoManager.read(username) != null)
			retVal.name = "MANAGER";
		else if (repoDel.read(username) != null)
			retVal.name = "TRENER";
		else
			retVal.name = "ADMIN";

		return retVal;
	}

	@GET
	@Path("activeUserObject")
	@Produces(MediaType.APPLICATION_JSON)
	public UserViewDTO getActiveUserObject() {
		repoCustomer.setBasePath(getDataDirPath());
		repoManager.setBasePath(getDataDirPath());
		repoAdmin.setBasePath(getDataDirPath());
		repoDel.setBasePath(getDataDirPath());

		String username = (String) ctx.getAttribute("username");

		if (repoCustomer.read(username) != null)
			return new UserViewDTO(repoCustomer.read(username));

		else if (repoManager.read(username) != null)
			return new UserViewDTO(repoManager.read(username));

		else if (repoDel.read(username) != null)
			return new UserViewDTO(repoDel.read(username));

		else if (repoAdmin.read(username) != null)
			return new UserViewDTO(repoAdmin.read(username));
		
		else
			return new UserViewDTO("INTRUDER");
	}

	@GET
	@Path("activeManagerSportsFacility")
	@Produces(MediaType.APPLICATION_JSON)
	public SportsFacilityViewDTO activeManagerSportsFacility() {
		repoManager.setBasePath(getDataDirPath());
		repoRest.setBasePath(getDataDirPath());

		String username = (String) ctx.getAttribute("username");
		String SportsFacilityID = repoManager.read(username).getSportsFacilityId();
		System.out.println(restaurantID);
		if (!SportsFacilityID.isEmpty()) {
			return new SportsFacilityViewDTO(repoRest.read(SportsFacilityID));
		} else {
			return new SportsFacilityViewDTO();
		}
	}
}
