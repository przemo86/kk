package pl.edu.agh.rest;

import java.util.List;

import pl.edu.agh.model.DataCenter;
import pl.edu.agh.model.File;
import pl.edu.agh.model.IODevice;
import pl.edu.agh.model.Machine;
import pl.edu.agh.model.Task;
import pl.edu.agh.model.VirtualOrganization;

public abstract class Service {
	
	//mo¿e jakiœ DI?
	private static Service instance = null;
	
	public abstract List<VirtualOrganization> getVirtualOrganizations();

	public abstract List<DataCenter> getDataCenters(VirtualOrganization vo);

	public abstract List<Machine> getMachines(DataCenter dc);

	public abstract List<Machine> getNodes(Machine parent);

	public abstract List<Task> getTasks(Machine m);
	
	public abstract boolean isLeaf(Machine m);

	public abstract List<IODevice> getDevices(Task m);

	public abstract List<File> getFiles(Task m);
	
	public static Service getInstance() {
		if (instance == null) {
			instance = new ServiceImplXML();
		}
		return instance;
	}

}
