package pl.edu.agh.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import pl.edu.agh.model.VirtualOrganization;

@Path("/")
public class VirtualOrganizationListRest {

	@GET
	@Produces(MediaType.TEXT_HTML)
	public String getHtml() {
		return new HTMLListBuilder().build(Service
				.getInstance().getVirtualOrganizations(), ".", "");
	}

}
