package pl.edu.agh.model;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class File implements IName{

	/**
	 * @uml.property  name="file"
	 */
	private java.io.File file;

	/**
	 * Getter of the property <tt>file</tt>
	 * @return  Returns the file.
	 * @uml.property  name="file"
	 */
	public java.io.File getFile() {
		return file;
	}

	/**
	 * Setter of the property <tt>file</tt>
	 * @param file  The file to set.
	 * @uml.property  name="file"
	 */
	public void setFile(java.io.File file) {
		this.file = file;
	}

	/**
	 * @uml.property  name="task"
	 * @uml.associationEnd  inverse="files:pl.edu.agh.model.Task"
	 */
	private Task task;

	/**
	 * Getter of the property <tt>task</tt>
	 * @return  Returns the task.
	 * @uml.property  name="task"
	 */
	public Task getTask() {
		return task;
	}

	/**
	 * Setter of the property <tt>task</tt>
	 * @param task  The task to set.
	 * @uml.property  name="task"
	 */
	public void setTask(Task task) {
		this.task = task;
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

}
