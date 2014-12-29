package pl.edu.agh.model;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Machine implements IName{

	/**
	 * @uml.property  name="cpuUtilization"
	 */
	private float cpuUtilization;

	/**
	 * @uml.property  name="memoryLoad"
	 */
	private float memoryLoad;

	/**
	 * @uml.property  name="name"
	 */
	private String name;

	/** 
	 * @uml.property name="nodes"
	 * @uml.associationEnd multiplicity="(0 -1)" ordering="true" inverse="parentNode:pl.edu.agh.model.Machine"
	 */
	private List<Machine> nodes = new java.util.ArrayList();

	/** 
	 * @uml.property name="runningTasks"
	 * @uml.associationEnd multiplicity="(0 -1)" ordering="true" inverse="machine:pl.edu.agh.model.Task"
	 */
	private List<Task> runningTasks = new java.util.ArrayList();

	/**
	 * @uml.property  name="swap"
	 */
	private float swap;

	/**
	 * Inserts the specified element at the specified position in this list (optional operation)
	 * @param index  index at which the specified element is to be inserted.
	 * @param element  element to be inserted.
	 * @see java.util.List#add(int,Object)
	 * @uml.property  name="nodes"
	 */
	public void addNodes(int index, Machine machine) {
		nodes.add(index, machine);
	}

	/**
	 * Appends the specified element to the end of this list (optional operation).
	 * @param element  element to be appended to this list.
	 * @return  <tt>true</tt> (as per the general contract of the <tt>Collection.add</tt> method).
	 * @see java.util.List#add(Object)
	 * @uml.property  name="nodes"
	 */
	public boolean addNodes(Machine machine) {
		return nodes.add(machine);
	}

	/**
	 * Inserts the specified element at the specified position in this list (optional operation)
	 * @param index  index at which the specified element is to be inserted.
	 * @param element  element to be inserted.
	 * @see java.util.List#add(int,Object)
	 * @uml.property  name="runningTasks"
	 */
	public void addRunningTasks(int index, Task task) {
		runningTasks.add(index, task);
	}

	/**
	 * Appends the specified element to the end of this list (optional operation).
	 * @param element  element to be appended to this list.
	 * @return  <tt>true</tt> (as per the general contract of the <tt>Collection.add</tt> method).
	 * @see java.util.List#add(Object)
	 * @uml.property  name="runningTasks"
	 */
	public boolean addRunningTasks(Task task) {
		return runningTasks.add(task);
	}

	/**
	 * Removes all of the elements from this list (optional operation).
	 * @see java.util.List#clear()
	 * @uml.property  name="nodes"
	 */
	public void clearNodes() {
		nodes.clear();
	}

	/**
	 * Removes all of the elements from this list (optional operation).
	 * @see java.util.List#clear()
	 * @uml.property  name="runningTasks"
	 */
	public void clearRunningTasks() {
		runningTasks.clear();
	}

	/**
	 * Returns <tt>true</tt> if this list contains all of the elements of the specified collection.
	 * @param elements  collection to be checked for containment in this list.
	 * @return  <tt>true</tt> if this list contains all of the elements of the specified collection.
	 * @see java.util.List#containsAll(Collection)
	 * @uml.property  name="nodes"
	 */
	public boolean containsAllNodes(Collection<? extends Machine> nodes) {
		return this.nodes.containsAll(nodes);
	}

	/**
	 * Returns <tt>true</tt> if this list contains all of the elements of the specified collection.
	 * @param elements  collection to be checked for containment in this list.
	 * @return  <tt>true</tt> if this list contains all of the elements of the specified collection.
	 * @see java.util.List#containsAll(Collection)
	 * @uml.property  name="runningTasks"
	 */
	public boolean containsAllRunningTasks(
			Collection<? extends Task> runningTasks) {
				return this.runningTasks.containsAll(runningTasks);
			}

	/**
	 * Returns <tt>true</tt> if this list contains the specified element.
	 * @param element  element whose presence in this list is to be tested.
	 * @return  <tt>true</tt> if this list contains the specified element.
	 * @see java.util.List#contains(Object)
	 * @uml.property  name="nodes"
	 */
	public boolean containsNodes(Machine machine) {
		return nodes.contains(machine);
	}

	/**
	 * Returns <tt>true</tt> if this list contains the specified element.
	 * @param element  element whose presence in this list is to be tested.
	 * @return  <tt>true</tt> if this list contains the specified element.
	 * @see java.util.List#contains(Object)
	 * @uml.property  name="runningTasks"
	 */
	public boolean containsRunningTasks(Task task) {
		return runningTasks.contains(task);
	}

	/**
	 * Getter of the property <tt>cpuUtilization</tt>
	 * @return  Returns the cpuUtilization.
	 * @uml.property  name="cpuUtilization"
	 */
	public float getCpuUtilization() {
		return cpuUtilization;
	}

	/**
	 * Getter of the property <tt>memoryLoad</tt>
	 * @return  Returns the memoryLoad.
	 * @uml.property  name="memoryLoad"
	 */
	public float getMemoryLoad() {
		return memoryLoad;
	}

	/**
	 * Getter of the property <tt>name</tt>
	 * @return  Returns the name.
	 * @uml.property  name="name"
	 */
	public String getName() {
		return name;
	}

	/** 
	 * Returns the element at the specified position in this list.
	 * @param index  index of element to return.
	 * @return  the element at the specified position in this list.
	 * @see java.util.List#get(int)
	 * @uml.property  name="nodes"
	 */
	public List<Machine> getNodes() {
		return nodes;
	}

	/** 
	 * Returns the element at the specified position in this list.
	 * @param index  index of element to return.
	 * @return  the element at the specified position in this list.
	 * @see java.util.List#get(int)
	 * @uml.property  name="nodes"
	 */
	public Machine getNodes(int i) {
		return (Machine) nodes.get(i);
	}

	/** 
	 * Getter of the property <tt>runningTasks</tt>
	 * @return  Returns the runningTasks.
	 * @uml.property  name="runningTasks"
	 */
	public List<Task> getRunningTasks() {
		return runningTasks;
	}

	/** 
	 * Getter of the property <tt>runningTasks</tt>
	 * @return  Returns the runningTasks.
	 * @uml.property  name="runningTasks"
	 */
	public Task getRunningTasks(int i) {
		return (Task) runningTasks.get(i);
	}

	/**
	 * Getter of the property <tt>swap</tt>
	 * @return  Returns the swap.
	 * @uml.property  name="swap"
	 */
	public float getSwap() {
		return swap;
	}

	/**
	 * Returns <tt>true</tt> if this list contains no elements.
	 * @return  <tt>true</tt> if this list contains no elements.
	 * @see java.util.List#isEmpty()
	 * @uml.property  name="nodes"
	 */
	public boolean isNodesEmpty() {
		return nodes.isEmpty();
	}

	/**
	 * Returns <tt>true</tt> if this list contains no elements.
	 * @return  <tt>true</tt> if this list contains no elements.
	 * @see java.util.List#isEmpty()
	 * @uml.property  name="runningTasks"
	 */
	public boolean isRunningTasksEmpty() {
		return runningTasks.isEmpty();
	}

	/**
	 * Returns an iterator over the elements in this list in proper sequence.
	 * @return  an iterator over the elements in this list in proper sequence.
	 * @see java.util.List#iterator()
	 * @uml.property  name="nodes"
	 */
	public Iterator<Machine> nodesIterator() {
		return nodes.iterator();
	}

	/**
	 * Returns the number of elements in this list.
	 * @return  the number of elements in this list.
	 * @see java.util.List#size()
	 * @uml.property  name="nodes"
	 */
	public int nodesSize() {
		return nodes.size();
	}

	/**
	 * Returns an array containing all of the elements in this list in proper sequence.
	 * @return  an array containing all of the elements in this list in proper sequence.
	 * @see java.util.List#toArray()
	 * @uml.property  name="nodes"
	 */
	public Machine[] nodesToArray() {
		return nodes.toArray(new Machine[nodes.size()]);
	}

	/**
	 * Returns an array containing all of the elements in this list in proper sequence; the runtime type of the returned array is that of the specified array.
	 * @param a  the array into which the elements of this list are to be stored.
	 * @return  an array containing all of the elements in this list in proper sequence.
	 * @see java.util.List#toArray(Object[])
	 * @uml.property  name="nodes"
	 */
	public <T extends Machine> T[] nodesToArray(T[] nodes) {
		return (T[]) this.nodes.toArray(nodes);
	}

	/**
	 * Removes the element at the specified position in this list (optional operation).
	 * @param index  the index of the element to removed.
	 * @return  the element previously at the specified position.
	 * @see java.util.List#remove(int)
	 * @uml.property  name="nodes"
	 */
	public Object removeNodes(int index) {
		return nodes.remove(index);
	}

	/**
	 * Removes the first occurrence in this list of the specified element  (optional operation).
	 * @param element  element to be removed from this list, if present.
	 * @return  <tt>true</tt> if this list contained the specified element.
	 * @see java.util.List#remove(Object)
	 * @uml.property  name="nodes"
	 */
	public boolean removeNodes(Machine machine) {
		return nodes.remove(machine);
	}

	/**
	 * Removes the element at the specified position in this list (optional operation).
	 * @param index  the index of the element to removed.
	 * @return  the element previously at the specified position.
	 * @see java.util.List#remove(int)
	 * @uml.property  name="runningTasks"
	 */
	public Object removeRunningTasks(int index) {
		return runningTasks.remove(index);
	}

	/**
	 * Removes the first occurrence in this list of the specified element  (optional operation).
	 * @param element  element to be removed from this list, if present.
	 * @return  <tt>true</tt> if this list contained the specified element.
	 * @see java.util.List#remove(Object)
	 * @uml.property  name="runningTasks"
	 */
	public boolean removeRunningTasks(Task task) {
		return runningTasks.remove(task);
	}

	/**
	 * Returns an iterator over the elements in this list in proper sequence.
	 * @return  an iterator over the elements in this list in proper sequence.
	 * @see java.util.List#iterator()
	 * @uml.property  name="runningTasks"
	 */
	public Iterator<Task> runningTasksIterator() {
		return runningTasks.iterator();
	}

	/**
	 * Returns the number of elements in this list.
	 * @return  the number of elements in this list.
	 * @see java.util.List#size()
	 * @uml.property  name="runningTasks"
	 */
	public int runningTasksSize() {
		return runningTasks.size();
	}

	/**
	 * Returns an array containing all of the elements in this list in proper sequence.
	 * @return  an array containing all of the elements in this list in proper sequence.
	 * @see java.util.List#toArray()
	 * @uml.property  name="runningTasks"
	 */
	public Task[] runningTasksToArray() {
		return runningTasks.toArray(new Task[runningTasks.size()]);
	}

	/**
	 * Returns an array containing all of the elements in this list in proper sequence; the runtime type of the returned array is that of the specified array.
	 * @param a  the array into which the elements of this list are to be stored.
	 * @return  an array containing all of the elements in this list in proper sequence.
	 * @see java.util.List#toArray(Object[])
	 * @uml.property  name="runningTasks"
	 */
	public <T extends Task> T[] runningTasksToArray(T[] runningTasks) {
		return (T[]) this.runningTasks.toArray(runningTasks);
	}

	/**
	 * Setter of the property <tt>cpuUtilization</tt>
	 * @param cpuUtilization  The cpuUtilization to set.
	 * @uml.property  name="cpuUtilization"
	 */
	public void setCpuUtilization(float cpuUtilization) {
		this.cpuUtilization = cpuUtilization;
	}

	/**
	 * Setter of the property <tt>memoryLoad</tt>
	 * @param memoryLoad  The memoryLoad to set.
	 * @uml.property  name="memoryLoad"
	 */
	public void setMemoryLoad(float memoryLoad) {
		this.memoryLoad = memoryLoad;
	}

	/**
	 * Setter of the property <tt>name</tt>
	 * @param name  The name to set.
	 * @uml.property  name="name"
	 */
	public void setName(String name) {
		this.name = name;
	}

	/** 
	 * Setter of the property <tt>nodes</tt>
	 * @param nodes  the nodes to set.
	 * @uml.property  name="nodes"
	 */
	public void setNodes(List<Machine> nodes) {
		this.nodes = nodes;
	}

	/** 
	 * Setter of the property <tt>runningTasks</tt>
	 * @param runningTasks  the runningTasks to set.
	 * @uml.property  name="runningTasks"
	 */
	public void setRunningTasks(List<Task> runningTasks) {
		this.runningTasks = runningTasks;
	}

	/**
	 * Setter of the property <tt>swap</tt>
	 * @param swap  The swap to set.
	 * @uml.property  name="swap"
	 */
	public void setSwap(float swap) {
		this.swap = swap;
	}

	/**
	 * @uml.property  name="dataCenter"
	 * @uml.associationEnd  inverse="machine:pl.edu.agh.model.DataCenter"
	 */
	private DataCenter dataCenter;

	/**
	 * Getter of the property <tt>dataCenter</tt>
	 * @return  Returns the dataCenter.
	 * @uml.property  name="dataCenter"
	 */
	public DataCenter getDataCenter() {
		return dataCenter;
	}

	/**
	 * Setter of the property <tt>dataCenter</tt>
	 * @param dataCenter  The dataCenter to set.
	 * @uml.property  name="dataCenter"
	 */
	public void setDataCenter(DataCenter dataCenter) {
		this.dataCenter = dataCenter;
	}

	/**
	 * @uml.property  name="parentNode"
	 * @uml.associationEnd  inverse="nodes:pl.edu.agh.model.Machine"
	 */
	private Machine parentNode;

	/**
	 * Getter of the property <tt>parentNode</tt>
	 * @return  Returns the parentNode.
	 * @uml.property  name="parentNode"
	 */
	public Machine getParentNode() {
		return parentNode;
	}

	/**
	 * Setter of the property <tt>parentNode</tt>
	 * @param parentNode  The parentNode to set.
	 * @uml.property  name="parentNode"
	 */
	public void setParentNode(Machine parentNode) {
		this.parentNode = parentNode;
	}
	
	public Machine getTopParent(Machine m) {
		if (m.getParentNode() == null) {
//			System.out.println("<<<" + m.getName());
			return m;
		}
		else {
//			System.out.println(">>>" + m.getName());
			return m.getTopParent(m.getParentNode());
		}
	}

}
