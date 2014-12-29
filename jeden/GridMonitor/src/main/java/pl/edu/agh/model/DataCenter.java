package pl.edu.agh.model;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class DataCenter implements IName {

	/** 
	 * @uml.property name="machine"
	 * @uml.associationEnd multiplicity="(0 -1)" ordering="true" inverse="dataCenter:pl.edu.agh.model.Machine"
	 */
	private List<Machine> machine = new java.util.ArrayList();

	/** 
	 * Getter of the property <tt>machine</tt>
	 * @return  Returns the machine.
	 * @uml.property  name="machine"
	 */
	@XmlAnyElement
	@XmlElementRef
	public List<Machine> getMachine() {
		return machine;
	}

	/** 
	 * Getter of the property <tt>machine</tt>
	 * @return  Returns the machine.
	 * @uml.property  name="machine"
	 */
	public Machine getMachine(int i) {
		return (Machine) machine.get(i);
	}

	/**
	 * Returns an iterator over the elements in this list in proper sequence.
	 * @return  an iterator over the elements in this list in proper sequence.
	 * @see java.util.List#iterator()
	 * @uml.property  name="machine"
	 */
	public Iterator<Machine> machineIterator() {
		return machine.iterator();
	}

	/**
	 * Returns <tt>true</tt> if this list contains no elements.
	 * @return  <tt>true</tt> if this list contains no elements.
	 * @see java.util.List#isEmpty()
	 * @uml.property  name="machine"
	 */
	public boolean isMachineEmpty() {
		return machine.isEmpty();
	}

	/**
	 * Returns <tt>true</tt> if this list contains the specified element.
	 * @param element  element whose presence in this list is to be tested.
	 * @return  <tt>true</tt> if this list contains the specified element.
	 * @see java.util.List#contains(Object)
	 * @uml.property  name="machine"
	 */
	public boolean containsMachine(Machine machine) {
		return this.machine.contains(machine);
	}

	/**
	 * Returns <tt>true</tt> if this list contains all of the elements of the specified collection.
	 * @param elements  collection to be checked for containment in this list.
	 * @return  <tt>true</tt> if this list contains all of the elements of the specified collection.
	 * @see java.util.List#containsAll(Collection)
	 * @uml.property  name="machine"
	 */
	public boolean containsAllMachine(Collection<? extends Machine> machine) {
		return this.machine.containsAll(machine);
	}

	/**
	 * Returns the number of elements in this list.
	 * @return  the number of elements in this list.
	 * @see java.util.List#size()
	 * @uml.property  name="machine"
	 */
	public int machineSize() {
		return machine.size();
	}

	/**
	 * Returns an array containing all of the elements in this list in proper sequence.
	 * @return  an array containing all of the elements in this list in proper sequence.
	 * @see java.util.List#toArray()
	 * @uml.property  name="machine"
	 */
	public Machine[] machineToArray() {
		return machine.toArray(new Machine[machine.size()]);
	}

	/**
	 * Returns an array containing all of the elements in this list in proper sequence; the runtime type of the returned array is that of the specified array.
	 * @param a  the array into which the elements of this list are to be stored.
	 * @return  an array containing all of the elements in this list in proper sequence.
	 * @see java.util.List#toArray(Object[])
	 * @uml.property  name="machine"
	 */
	public <T extends Machine> T[] machineToArray(T[] machine) {
		return (T[]) this.machine.toArray(machine);
	}

	/**
	 * Inserts the specified element at the specified position in this list (optional operation)
	 * @param index  index at which the specified element is to be inserted.
	 * @param element  element to be inserted.
	 * @see java.util.List#add(int,Object)
	 * @uml.property  name="machine"
	 */
	public void addMachine(int index, Machine machine) {
		this.machine.add(index, machine);
	}

	/**
	 * Appends the specified element to the end of this list (optional operation).
	 * @param element  element to be appended to this list.
	 * @return  <tt>true</tt> (as per the general contract of the <tt>Collection.add</tt> method).
	 * @see java.util.List#add(Object)
	 * @uml.property  name="machine"
	 */
	public boolean addMachine(Machine machine) {
		return this.machine.add(machine);
	}

	/**
	 * Removes the element at the specified position in this list (optional operation).
	 * @param index  the index of the element to removed.
	 * @return  the element previously at the specified position.
	 * @see java.util.List#remove(int)
	 * @uml.property  name="machine"
	 */
	public Object removeMachine(int index) {
		return machine.remove(index);
	}

	/**
	 * Removes the first occurrence in this list of the specified element  (optional operation).
	 * @param element  element to be removed from this list, if present.
	 * @return  <tt>true</tt> if this list contained the specified element.
	 * @see java.util.List#remove(Object)
	 * @uml.property  name="machine"
	 */
	public boolean removeMachine(Machine machine) {
		return this.machine.remove(machine);
	}

	/**
	 * Removes all of the elements from this list (optional operation).
	 * @see java.util.List#clear()
	 * @uml.property  name="machine"
	 */
	public void clearMachine() {
		machine.clear();
	}

	/** 
	 * Setter of the property <tt>machine</tt>
	 * @param machine  the machine to set.
	 * @uml.property  name="machine"
	 */
	public void setMachine(List<Machine> machine) {
		this.machine = machine;
	}

	/**
	 * @uml.property  name="name"
	 */
	private String name;

	/**
	 * Getter of the property <tt>name</tt>
	 * @return  Returns the name.
	 * @uml.property  name="name"
	 */
	public String getName() {
		return name;
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
	 * @uml.property  name="virtualOrganization"
	 * @uml.associationEnd  inverse="dataCenter:pl.edu.agh.model.VirtualOrganization"
	 */
	private VirtualOrganization virtualOrganization;

	/**
	 * Getter of the property <tt>virtualOrganization</tt>
	 * @return  Returns the virtualOrganization.
	 * @uml.property  name="virtualOrganization"
	 */
	public VirtualOrganization getVirtualOrganization() {
		return virtualOrganization;
	}

	/**
	 * Setter of the property <tt>virtualOrganization</tt>
	 * @param virtualOrganization  The virtualOrganization to set.
	 * @uml.property  name="virtualOrganization"
	 */
	public void setVirtualOrganization(VirtualOrganization virtualOrganization) {
		this.virtualOrganization = virtualOrganization;
	}

}
