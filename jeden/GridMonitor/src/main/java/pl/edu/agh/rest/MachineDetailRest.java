package pl.edu.agh.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import pl.edu.agh.model.DataCenter;
import pl.edu.agh.model.File;
import pl.edu.agh.model.IODevice;
import pl.edu.agh.model.Machine;
import pl.edu.agh.model.Task;
import pl.edu.agh.model.VirtualOrganization;

@Path("/{vo}/{dc}/{machine:(.+)(/(.+))*}/detail")
public class MachineDetailRest {

	@GET
	@Produces(MediaType.TEXT_HTML)
	public String getHtml(@PathParam("vo") String vo,
			@PathParam("dc") String dc, @PathParam("machine") String machine) {

		VirtualOrganization virtualOrganization = new VirtualOrganization();
		virtualOrganization.setName(vo);

		DataCenter dataCenter = new DataCenter();
		dataCenter.setName(dc);
		dataCenter.setVirtualOrganization(virtualOrganization);

		System.out.println(getClass() + " " + machine);
		
		String[] mmm = machine.split("/");
		Machine m = new Machine();
		m.setDataCenter(dataCenter);

		for (int i = 0; i < mmm.length; i++) {
			m.setName(mmm[i]);

			for (Machine node : Service.getInstance().getNodes(m)) {
				if (node.getName().equals(mmm[i + 1])) {
					m = new Machine();
					m.setName(node.getName());
					if (i == 0)
						m.setDataCenter(dataCenter);
					else
						node.setParentNode(m);
					m = node;
					break;					
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(HTMLListBuilder.getHTMLHeader());
		
		sb.append("<h1>");
		sb.append("Machine name - " + m.getName());
		sb.append("</h1>");

		sb.append("<span>");
		sb.append("CPU Utilization - " + m.getCpuUtilization());
		sb.append("</span>");
		
		sb.append("<br />");
		
		sb.append("<span>");
		sb.append("Memory lad - " + m.getMemoryLoad());
		sb.append("</span>");
		
		sb.append("<br />");
		
		sb.append("<span>");
		sb.append("SWAP - " + m.getSwap());
		sb.append("</span>");
		
		sb.append("<br />");
		
		sb.append("<span>");
		sb.append("Running tasks:");
		sb.append("</span>");
		
		sb.append("<br />");
			
		sb.append("<ol>");
		
		for (Task t : Service.getInstance().getTasks(m)) {
			System.out.println(t.getTaskName());
			sb.append("<li>");
			sb.append("<a href=\""+t.getTaskName() +"\">" + t.getTaskName() + "</a>");
			sb.append("</li>");	
		}
		
		sb.append("</ol>");
		
		sb.append(HTMLListBuilder.getHTMLFooter());
		
		return sb.toString();
	}

/*	@GET
	@Path("/{task}")
	@Produces(MediaType.TEXT_HTML)
	public String getHtml(@PathParam("vo") String vo,
			@PathParam("dc") String dc, @PathParam("machine") String machine,
			@PathParam("task") String task) {

		VirtualOrganization virtualOrganization = new VirtualOrganization();
		virtualOrganization.setName(vo);

		DataCenter dataCenter = new DataCenter();
		dataCenter.setName(dc);
		dataCenter.setVirtualOrganization(virtualOrganization);

		System.out.println(getClass() + " " + machine);

		String[] mmm = machine.split("/");
		Machine m = new Machine();
		m.setDataCenter(dataCenter);

		for (int i = 0; i < mmm.length; i++) {
			m.setName(mmm[i]);

			for (Machine node : Service.getInstance().getNodes(m)) {
				if (node.getName().equals(mmm[i + 1])) {
					m = new Machine();
					m.setName(node.getName());
					if (i == 0)
						m.setDataCenter(dataCenter);
					else
						node.setParentNode(m);
					m = node;
					break;
				}
			}
		}

		List<Task> tasks = Service.getInstance().getTasks(m);
		Task currentTask = null;
		for (Task t : tasks) {
			if (t.getName().equals(task)) {
				currentTask = t;
				break;
			}
		}

		StringBuilder sb = new StringBuilder();
		sb.append(HTMLListBuilder.getHTMLHeader());

		sb.append("<h1>");
		sb.append("Task name - " + currentTask.getTaskName());
		sb.append("</h1>");

		sb.append("<span>");
		sb.append("CPU time - " + currentTask.getCpuTime());
		sb.append("</span>");

		sb.append("<br />");

		sb.append("<span>");
		sb.append("Memory used - " + currentTask.getMemoryUsed());
		sb.append("</span>");

		sb.append("<br />");

		sb.append("<span>");
		sb.append("Files:");
		sb.append("</span>");

		sb.append("<br />");

		sb.append("<ol>");

		for (File f : Service.getInstance().getFiles(currentTask)) {
			sb.append("<li>");
			sb.append(f.getName());
			sb.append("</li>");
		}

		sb.append("</ol>");

		sb.append("<br />");

		sb.append("<span>");
		sb.append("Devices:");
		sb.append("</span>");

		sb.append("<br />");

		sb.append("<ol>");

		for (IODevice f : Service.getInstance().getDevices(currentTask)) {
			sb.append("<li>");
			sb.append(f.getName());
			sb.append("</li>");
		}

		sb.append("</ol>");

		sb.append(HTMLListBuilder.getHTMLFooter());

		return sb.toString();
	}*/
}
