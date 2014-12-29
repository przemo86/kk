package pl.edu.agh.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;

import pl.edu.agh.model.DataCenter;
import pl.edu.agh.model.Machine;
import pl.edu.agh.model.VirtualOrganization;
import static ch.lambdaj.Lambda.*;

@Path("/{vo}/{dc}")
public class MachineListRest {

	@GET
	@Produces(MediaType.TEXT_HTML)
	public String getHtml(@PathParam("vo") String vo, @PathParam("dc") String dc) {
		System.out.println("JEDEN");
		VirtualOrganization virtualOrganization = new VirtualOrganization();
		virtualOrganization.setName(vo);

		DataCenter dataCenter = new DataCenter();
		dataCenter.setName(dc);
		dataCenter.setVirtualOrganization(virtualOrganization);

		StringBuilder sb = new StringBuilder();
		sb.append(HTMLListBuilder.getHTMLHeaderWithList());

		for (Machine m : Service.getInstance().getMachines(dataCenter)) {
			if (Service.getInstance().isLeaf(m)) {
				sb.append(HTMLListBuilder.getHTMLListItemHRef(m, ".", "detail"));
			} else {
				sb.append(HTMLListBuilder.getHTMLListItemHRef(m, ".", ""));
			}
		}

		sb.append(HTMLListBuilder.getHTMLFooterWithList());

		return sb.toString();
	}

	@GET
	@Path("/{machine:(.+)(/(.+))*}")
	public String getHtmlMachine(@PathParam("vo") String vo,
			@PathParam("dc") String dc, @PathParam("machine") String machine) {
		VirtualOrganization virtualOrganization = new VirtualOrganization();
		virtualOrganization.setName(vo);

		DataCenter dataCenter = new DataCenter();
		dataCenter.setName(dc);
		dataCenter.setVirtualOrganization(virtualOrganization);

		String[] mmm = machine.split("/");
		Machine m = new Machine();
		m.setDataCenter(dataCenter);

		for (int i = 0; i < mmm.length; i++) {
			m.setName(mmm[i]);

			for (Machine node : Service.getInstance().getNodes(m)) {
				if (node.getName().equals(mmm[i])) {
					m = new Machine();
					m.setName(node.getName());
					if (i == 0)
						m.setDataCenter(dataCenter);
					else
						node.setParentNode(m);
					break;
				}
			}

		}

		StringBuilder sb = new StringBuilder();
		sb.append(HTMLListBuilder.getHTMLHeaderWithList());
		if (Service.getInstance().isLeaf(m)) {
			sb.append(HTMLListBuilder.getHTMLListItemHRef(m, ".", "detail"));
		} else
			for (Machine mach : Service.getInstance().getNodes(m)) {
				if (Service.getInstance().isLeaf(mach)) {
					sb.append(HTMLListBuilder.getHTMLListItemHRef(mach, ".",
							"detail"));
				} else {
					sb.append(HTMLListBuilder
							.getHTMLListItemHRef(mach, ".", ""));
				}
			}
		sb.append(HTMLListBuilder.getHTMLFooterWithList());

		return sb.toString();
	}

}
