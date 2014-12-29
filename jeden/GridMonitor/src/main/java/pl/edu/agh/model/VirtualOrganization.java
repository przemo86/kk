package pl.edu.agh.model;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class VirtualOrganization implements IName{
	

	/**
	 * @uml.property name="name"
	 */
	private String name;

	/** 
	 * @uml.property name="dataCenter"
	 * @uml.associationEnd multiplicity="(0 -1)" ordering="true" inverse="virtualOrganization:pl.edu.agh.model.DataCenter"
	 */
	

	private List<DataCenter> dataCenter = new java.util.ArrayList();

	/** 
	 * Getter of the property <tt>dataCenter</tt>
	 * public List<DataCenter> getDataCenter() {
	 * return dataCenter;
	 * }
	 * /
	 * Getter of the property <tt>dataCenter</tt>
	 * @return Returns the dataCenter.
	 * @uml.property  name="dataCenter"
	 */
	public DataCenter getDataCenter(int i) {
		return (DataCenter) dataCenter.get(i);
	}

	/**
	 * Returns an iterator over the elements in this list in proper sequence.
	 * 
	 * @return an iterator over the elements in this list in proper sequence.
	 * @see java.util.List#iterator()
	 * @uml.property name="dataCenter"
	 */
	public Iterator<DataCenter> dataCenterIterator() {
		return dataCenter.iterator();
	}

	/**
	 * Returns <tt>true</tt> if this list contains no elements.
	 * 
	 * @return <tt>true</tt> if this list contains no elements.
	 * @see java.util.List#isEmpty()
	 * @uml.property name="dataCenter"
	 */
	public boolean isDataCenterEmpty() {
		return dataCenter.isEmpty();
	}

	/**
	 * Returns <tt>true</tt> if this list contains the specified element.
	 * @param element  element whose presence in this list is to be tested.
	 * @return  <tt>true</tt> if this list contains the specified element.
	 * @see java.util.List#contains(Object)
	 * @uml.property  name="dataCenter"
	 */
	public boolean containsDataCenter(DataCenter dataCenter) {
		return this.dataCenter.contains(dataCenter);
	}

	/**
	 * Returns <tt>true</tt> if this list contains all of the elements of the specified collection.
	 * @param elements  collection to be checked for containment in this list.
	 * @return  <tt>true</tt> if this list contains all of the elements of the specified collection.
	 * @see java.util.List#containsAll(Collection)
	 * @uml.property  name="dataCenter"
	 */
	public boolean containsAllDataCenter(
			Collection<? extends DataCenter> dataCenter) {
				return this.dataCenter.containsAll(dataCenter);
			}

	/**
	 * Returns the number of elements in this list.
	 * 
	 * @return the number of elements in this list.
	 * @see java.util.List#size()
	 * @uml.property name="dataCenter"
	 */
	public int dataCenterSize() {
		return dataCenter.size();
	}

	/**
	 * Returns an array containing all of the elements in this list in proper
	 * sequence.
	 * 
	 * @return an array containing all of the elements in this list in proper
	 *         sequence.
	 * @see java.util.List#toArray()
	 * @uml.property name="dataCenter"
	 */
	public DataCenter[] dataCenterToArray() {
		return dataCenter.toArray(new DataCenter[dataCenter.size()]);
	}

	/**
	 * Returns an array containing all of the elements in this list in proper sequence; the runtime type of the returned array is that of the specified array.
	 * @param a  the array into which the elements of this list are to be stored.
	 * @return  an array containing all of the elements in this list in proper sequence.
	 * @see java.util.List#toArray(Object[])
	 * @uml.property  name="dataCenter"
	 */
	public <T extends DataCenter> T[] dataCenterToArray(T[] dataCenter) {
		return (T[]) this.dataCenter.toArray(dataCenter);
	}

	/**
	 * Inserts the specified element at the specified position in this list (optional operation)
	 * @param index  index at which the specified element is to be inserted.
	 * @param element  element to be inserted.
	 * @see java.util.List#add(int,Object)
	 * @uml.property  name="dataCenter"
	 */
	public void addDataCenter(int index, DataCenter dataCenter) {
		this.dataCenter.add(index, dataCenter);
	}

	/**
	 * Appends the specified element to the end of this list (optional operation).
	 * @param element  element to be appended to this list.
	 * @return  <tt>true</tt> (as per the general contract of the <tt>Collection.add</tt> method).
	 * @see java.util.List#add(Object)
	 * @uml.property  name="dataCenter"
	 */
	public boolean addDataCenter(DataCenter dataCenter) {
		return this.dataCenter.add(dataCenter);
	}

	/**
	 * Removes the element at the specified position in this list (optional operation).
	 * @param index  the index of the element to removed.
	 * @return  the element previously at the specified position.
	 * @see java.util.List#remove(int)
	 * @uml.property  name="dataCenter"
	 */
	public Object removeDataCenter(int index) {
		return dataCenter.remove(index);
	}

	/**
	 * Removes the first occurrence in this list of the specified element  (optional operation).
	 * @param element  element to be removed from this list, if present.
	 * @return  <tt>true</tt> if this list contained the specified element.
	 * @see java.util.List#remove(Object)
	 * @uml.property  name="dataCenter"
	 */
	public boolean removeDataCenter(DataCenter dataCenter) {
		return this.dataCenter.remove(dataCenter);
	}

	/**
	 * Removes all of the elements from this list (optional operation).
	 * 
	 * @see java.util.List#clear()
	 * @uml.property name="dataCenter"
	 */
	public void clearDataCenter() {
		dataCenter.clear();
	}

	/** 
	 * Setter of the property <tt>dataCenter</tt>
	 * @param dataCenter the dataCenter to set.
	 * @uml.property  name="dataCenter"
	 */
	public void setDataCenter(List<DataCenter> dataCenter) {
		this.dataCenter = dataCenter;
	}
	
	/**
	 * Getter of the property <tt>name</tt>
	 * 
	 * @return Returns the name.
	 * @uml.property name="name"
	 */
	public String getName() {
		return name;
	}

	/**
	 * Setter of the property <tt>name</tt>
	 * 
	 * @param name
	 *            The name to set.
	 * @uml.property name="name"
	 */

	public void setName(String name) {
		this.name = name;
	}

	public VirtualOrganization(String name, List<DataCenter> dataCenter) {
		this.name = name;
		this.dataCenter = dataCenter;
	}

	public VirtualOrganization() {
	}

	/** 
	 * Getter of the property <tt>dataCenter</tt>
	 * public List<DataCenter> getDataCenter() {
	 * return dataCenter;
	 * }
	 * /
	 * Getter of the property <tt>dataCenter</tt>
	 * @return Returns the dataCenter.
	 * @uml.property  name="dataCenter"
	 */
	@XmlAnyElement
	@XmlElementRef
	public List<DataCenter> getDataCenter() {
		return dataCenter;
	}

	
	
}
