package rest;

import java.io.File;

import javax.servlet.ServletContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import dto.SportsFacilityDTO;
import dto.SportsFacilityViewDTO;
import model.SportsFacility;
import repository.SportsFacilityRepository;

@Path("sportsFacilityView")
public class SportsFacilityViewController {

	SportsFacilityRepository repo = new SportsFacilityRepository();

	@Context
	ServletContext ctx;

	@SuppressWarnings("unused")
	public void init() {
		if (ctx.getAttribute("sportsFacility") == null) {
			String contextPath = ctx.getRealPath("");
			ctx.setAttribute("sportsFacility", new String());
		}
	}

	private String getDataDirPath() {
		return (ctx.getRealPath("") + "WEB-INF" + File.separator + "classes" + File.separator + "data"
				+ File.separator);
	}

	@GET
	@Path("getCurrentSportsFacility")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public SportsFacilityViewDTO getCurrentSportsFacility() {
		repo.setBasePath(getDataDirPath());

		SportsFacility current = repo.read((String) ctx.getAttribute("sportsFacility"));
		return new SportsFacilityViewDTO(current);
	}

	@POST
	@Path("setCurrentSportsFacility")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public void getFilteredSearch(SportsFacilityDTO dto) {
		ctx.setAttribute("sportsFacility", dto.name);
	}

}
