package pl.edu.agh.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Task implements IName{

	/**
	 * @uml.property  name="cpuTime"
	 */
	private float cpuTime;

	/**
	 * Getter of the property <tt>cpuTime</tt>
	 * @return  Returns the cpuTime.
	 * @uml.property  name="cpuTime"
	 */
	public float getCpuTime() {
		return cpuTime;
	}

	/**
	 * Setter of the property <tt>cpuTime</tt>
	 * @param cpuTime  The cpuTime to set.
	 * @uml.property  name="cpuTime"
	 */
	public void setCpuTime(float cpuTime) {
		this.cpuTime = cpuTime;
	}

	/**
	 * @uml.property  name="memoryUsed"
	 */
	private float memoryUsed;

	/**
	 * Getter of the property <tt>memoryUsed</tt>
	 * @return  Returns the memoryUsed.
	 * @uml.property  name="memoryUsed"
	 */
	public float getMemoryUsed() {
		return memoryUsed;
	}

	/**
	 * Setter of the property <tt>memoryUsed</tt>
	 * @param memoryUsed  The memoryUsed to set.
	 * @uml.property  name="memoryUsed"
	 */
	public void setMemoryUsed(float memoryUsed) {
		this.memoryUsed = memoryUsed;
	}

	/** 
	 * @uml.property name="devices"
	 * @uml.associationEnd multiplicity="(0 -1)" ordering="true" inverse="task:pl.edu.agh.model.IODevice"
	 */
	private List<IODevice> devices = new java.util.ArrayList();

	/** 
	 * Getter of the property <tt>devices</tt>
	 * @return  Returns the devices.
	 * @uml.property  name="devices"
	 */
	public List<IODevice> getDevices() {
		return devices;
	}

	/** 
	 * Getter of the property <tt>devices</tt>
	 * @return  Returns the devices.
	 * @uml.property  name="devices"
	 */
	public IODevice getDevices(int i) {
		return (IODevice) devices.get(i);
	}

	/**
	 * Returns an iterator over the elements in this list in proper sequence.
	 * @return  an iterator over the elements in this list in proper sequence.
	 * @see java.util.List#iterator()
	 * @uml.property  name="devices"
	 */
	public Iterator<IODevice> devicesIterator() {
		return devices.iterator();
	}

	/**
	 * Returns <tt>true</tt> if this list contains no elements.
	 * @return  <tt>true</tt> if this list contains no elements.
	 * @see java.util.List#isEmpty()
	 * @uml.property  name="devices"
	 */
	public boolean isDevicesEmpty() {
		return devices.isEmpty();
	}

	/**
	 * Returns <tt>true</tt> if this list contains the specified element.
	 * @param element  element whose presence in this list is to be tested.
	 * @return  <tt>true</tt> if this list contains the specified element.
	 * @see java.util.List#contains(Object)
	 * @uml.property  name="devices"
	 */
	public boolean containsDevices(IODevice ioDevice) {
		return devices.contains(ioDevice);
	}

	/**
	 * Returns <tt>true</tt> if this list contains all of the elements of the specified collection.
	 * @param elements  collection to be checked for containment in this list.
	 * @return  <tt>true</tt> if this list contains all of the elements of the specified collection.
	 * @see java.util.List#containsAll(Collection)
	 * @uml.property  name="devices"
	 */
	public boolean containsAllDevices(Collection<? extends IODevice> devices) {
		return this.devices.containsAll(devices);
	}

	/**
	 * Returns the number of elements in this list.
	 * @return  the number of elements in this list.
	 * @see java.util.List#size()
	 * @uml.property  name="devices"
	 */
	public int devicesSize() {
		return devices.size();
	}

	/**
	 * Returns an array containing all of the elements in this list in proper sequence.
	 * @return  an array containing all of the elements in this list in proper sequence.
	 * @see java.util.List#toArray()
	 * @uml.property  name="devices"
	 */
	public IODevice[] devicesToArray() {
		return devices.toArray(new IODevice[devices.size()]);
	}

	/**
	 * Returns an array containing all of the elements in this list in proper sequence; the runtime type of the returned array is that of the specified array.
	 * @param a  the array into which the elements of this list are to be stored.
	 * @return  an array containing all of the elements in this list in proper sequence.
	 * @see java.util.List#toArray(Object[])
	 * @uml.property  name="devices"
	 */
	public <T extends IODevice> T[] devicesToArray(T[] devices) {
		return (T[]) this.devices.toArray(devices);
	}

	/**
	 * Inserts the specified element at the specified position in this list (optional operation)
	 * @param index  index at which the specified element is to be inserted.
	 * @param element  element to be inserted.
	 * @see java.util.List#add(int,Object)
	 * @uml.property  name="devices"
	 */
	public void addDevices(int index, IODevice ioDevice) {
		devices.add(index, ioDevice);
	}

	/**
	 * Appends the specified element to the end of this list (optional operation).
	 * @param element  element to be appended to this list.
	 * @return  <tt>true</tt> (as per the general contract of the <tt>Collection.add</tt> method).
	 * @see java.util.List#add(Object)
	 * @uml.property  name="devices"
	 */
	public boolean addDevices(IODevice ioDevice) {
		return devices.add(ioDevice);
	}

	/**
	 * Removes the element at the specified position in this list (optional operation).
	 * @param index  the index of the element to removed.
	 * @return  the element previously at the specified position.
	 * @see java.util.List#remove(int)
	 * @uml.property  name="devices"
	 */
	public Object removeDevices(int index) {
		return devices.remove(index);
	}

	/**
	 * Removes the first occurrence in this list of the specified element  (optional operation).
	 * @param element  element to be removed from this list, if present.
	 * @return  <tt>true</tt> if this list contained the specified element.
	 * @see java.util.List#remove(Object)
	 * @uml.property  name="devices"
	 */
	public boolean removeDevices(IODevice ioDevice) {
		return devices.remove(ioDevice);
	}

	/**
	 * Removes all of the elements from this list (optional operation).
	 * @see java.util.List#clear()
	 * @uml.property  name="devices"
	 */
	public void clearDevices() {
		devices.clear();
	}

	/** 
	 * Setter of the property <tt>devices</tt>
	 * @param devices  the devices to set.
	 * @uml.property  name="devices"
	 */
	public void setDevices(List<IODevice> devices) {
		this.devices = devices;
	}

	/** 
	 * @uml.property name="files"
	 * @uml.associationEnd multiplicity="(0 -1)" ordering="true" inverse="task:pl.edu.agh.model.File"
	 */
	private List<File> files = new ArrayList<File>();

	/** 
	 * Returns the element at the specified position in this list.
	 * @param index  index of element to return.
	 * @return  the element at the specified position in this list.
	 * @see java.util.List#get(int)
	 * @uml.property  name="files"
	 */
	public List<File> getFiles() {
		return files;
	}

	/** 
	 * Returns the element at the specified position in this list.
	 * @param index  index of element to return.
	 * @return  the element at the specified position in this list.
	 * @see java.util.List#get(int)
	 * @uml.property  name="files"
	 */
	public File getFiles(int i) {
		return (File) files.get(i);
	}

	/**
	 * Returns an iterator over the elements in this list in proper sequence.
	 * @return  an iterator over the elements in this list in proper sequence.
	 * @see java.util.List#iterator()
	 * @uml.property  name="files"
	 */
	public Iterator<File> filesIterator() {
		return files.iterator();
	}

	/**
	 * Returns <tt>true</tt> if this list contains no elements.
	 * @return  <tt>true</tt> if this list contains no elements.
	 * @see java.util.List#isEmpty()
	 * @uml.property  name="files"
	 */
	public boolean isFilesEmpty() {
		return files.isEmpty();
	}

	/**
	 * Returns <tt>true</tt> if this list contains the specified element.
	 * @param element  element whose presence in this list is to be tested.
	 * @return  <tt>true</tt> if this list contains the specified element.
	 * @see java.util.List#contains(Object)
	 * @uml.property  name="files"
	 */
	public boolean containsFiles(File file) {
		return files.contains(file);
	}

	/**
	 * Returns <tt>true</tt> if this list contains all of the elements of the specified collection.
	 * @param elements  collection to be checked for containment in this list.
	 * @return  <tt>true</tt> if this list contains all of the elements of the specified collection.
	 * @see java.util.List#containsAll(Collection)
	 * @uml.property  name="files"
	 */
	public boolean containsAllFiles(Collection<? extends File> files) {
		return this.files.containsAll(files);
	}

	/**
	 * Returns the number of elements in this list.
	 * @return  the number of elements in this list.
	 * @see java.util.List#size()
	 * @uml.property  name="files"
	 */
	public int filesSize() {
		return files.size();
	}

	/**
	 * Returns an array containing all of the elements in this list in proper sequence.
	 * @return  an array containing all of the elements in this list in proper sequence.
	 * @see java.util.List#toArray()
	 * @uml.property  name="files"
	 */
	public File[] filesToArray() {
		return files.toArray(new File[files.size()]);
	}

	/**
	 * Returns an array containing all of the elements in this list in proper sequence; the runtime type of the returned array is that of the specified array.
	 * @param a  the array into which the elements of this list are to be stored.
	 * @return  an array containing all of the elements in this list in proper sequence.
	 * @see java.util.List#toArray(Object[])
	 * @uml.property  name="files"
	 */
	public <T extends File> T[] filesToArray(T[] files) {
		return (T[]) this.files.toArray(files);
	}

	/**
	 * Inserts the specified element at the specified position in this list (optional operation)
	 * @param index  index at which the specified element is to be inserted.
	 * @param element  element to be inserted.
	 * @see java.util.List#add(int,Object)
	 * @uml.property  name="files"
	 */
	public void addFiles(int index, File file) {
		files.add(index, file);
	}

	/**
	 * Appends the specified element to the end of this list (optional operation).
	 * @param element  element to be appended to this list.
	 * @return  <tt>true</tt> (as per the general contract of the <tt>Collection.add</tt> method).
	 * @see java.util.List#add(Object)
	 * @uml.property  name="files"
	 */
	public boolean addFiles(File file) {
		return files.add(file);
	}

	/**
	 * Removes the element at the specified position in this list (optional operation).
	 * @param index  the index of the element to removed.
	 * @return  the element previously at the specified position.
	 * @see java.util.List#remove(int)
	 * @uml.property  name="files"
	 */
	public Object removeFiles(int index) {
		return files.remove(index);
	}

	/**
	 * Removes the first occurrence in this list of the specified element  (optional operation).
	 * @param element  element to be removed from this list, if present.
	 * @return  <tt>true</tt> if this list contained the specified element.
	 * @see java.util.List#remove(Object)
	 * @uml.property  name="files"
	 */
	public boolean removeFiles(File file) {
		return files.remove(file);
	}

	/**
	 * Removes all of the elements from this list (optional operation).
	 * @see java.util.List#clear()
	 * @uml.property  name="files"
	 */
	public void clearFiles() {
		files.clear();
	}

	/** 
	 * Setter of the property <tt>files</tt>
	 * @param files  the files to set.
	 * @uml.property  name="files"
	 */
	public void setFiles(List<File> files) {
		this.files = files;
	}

	/**
	 * @uml.property  name="taskName"
	 */
	private String taskName;

	/**
	 * Getter of the property <tt>taskName</tt>
	 * @return  Returns the taskName.
	 * @uml.property  name="taskName"
	 */
	public String getTaskName() {
		return taskName;
	}

	/**
	 * Setter of the property <tt>taskName</tt>
	 * @param taskName  The taskName to set.
	 * @uml.property  name="taskName"
	 */
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	/**
	 * @uml.property  name="machine"
	 * @uml.associationEnd  inverse="runningTasks:pl.edu.agh.model.Machine"
	 */
	private Machine machine;

	/**
	 * Getter of the property <tt>machine</tt>
	 * @return  Returns the machine.
	 * @uml.property  name="machine"
	 */
	public Machine getMachine() {
		return machine;
	}

	/**
	 * Setter of the property <tt>machine</tt>
	 * @param machine  The machine to set.
	 * @uml.property  name="machine"
	 */
	public void setMachine(Machine machine) {
		this.machine = machine;
	}

	public String getName() {
		return taskName;
	}

}
