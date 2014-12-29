package pl.edu.agh.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import pl.edu.agh.model.DataCenter;
import pl.edu.agh.model.VirtualOrganization;

@Path("/{vo}/")
public class DataCenterListRest {

	@GET
	@Produces(MediaType.TEXT_HTML)
	public String getHtml(@PathParam("vo") String vo) {
		VirtualOrganization virtualOrganization = new VirtualOrganization();
		virtualOrganization.setName(vo);
		return new HTMLListBuilder().build(Service
				.getInstance().getDataCenters(virtualOrganization), ".", "");
	}
}
