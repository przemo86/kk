package pl.edu.agh.rest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import pl.edu.agh.model.DataCenter;
import pl.edu.agh.model.File;
import pl.edu.agh.model.IODevice;
import pl.edu.agh.model.Machine;
import pl.edu.agh.model.Task;
import pl.edu.agh.model.VirtualOrganization;

public class ServiceImplXML extends Service {
	private XPath xpath = XPathFactory.newInstance().newXPath();
	private XPathExpression expr;
	private Document doc;

	public ServiceImplXML() {
		DocumentBuilderFactory domFactory = DocumentBuilderFactory
				.newInstance();
		domFactory.setNamespaceAware(true);
		DocumentBuilder builder;
		try {
			builder = domFactory.newDocumentBuilder();
			doc = builder.parse(this.getClass().getClassLoader()
					.getResourceAsStream("grid.xml"));

		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public List<VirtualOrganization> getVirtualOrganizations() {
		try {
			expr = xpath.compile("//virtualOrganizations/virtualOrganization");
			Object result = expr.evaluate(doc, XPathConstants.NODESET);
			NodeList nodes = (NodeList) result;
			List<VirtualOrganization> retList = new ArrayList<VirtualOrganization>();
			for (int i = 0; i < nodes.getLength(); i++) {
				VirtualOrganization vo = new VirtualOrganization();
				expr = xpath
						.compile("//virtualOrganizations/virtualOrganization["
								+ Integer.toString(i + 1) + "]/name");
				result = expr.evaluate(doc, XPathConstants.STRING);
				vo.setName(result.toString());
				retList.add(vo);
			}
			return retList;
		} catch (XPathExpressionException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<DataCenter> getDataCenters(VirtualOrganization vo) {
		try {
			expr = xpath
					.compile("//virtualOrganizations/virtualOrganization[name='"
							+ vo.getName() + "']/dataCenter");
			Object result = expr.evaluate(doc, XPathConstants.NODESET);
			NodeList nodes = (NodeList) result;
			List<DataCenter> retList = new ArrayList<DataCenter>();
			for (int i = 0; i < nodes.getLength(); i++) {
				DataCenter dc = new DataCenter();
				expr = xpath
						.compile("//virtualOrganizations/virtualOrganization[name='"
								+ vo.getName()
								+ "']/dataCenter["
								+ Integer.toString(i + 1) + "]/name");
				result = expr.evaluate(doc, XPathConstants.STRING);
				dc.setName(result.toString());
				dc.setVirtualOrganization(vo);
				retList.add(dc);
			}
			return retList;
		} catch (XPathExpressionException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Machine> getMachines(DataCenter dc) {
		try {
			expr = xpath
					.compile("//virtualOrganizations/virtualOrganization[name='"
							+ dc.getVirtualOrganization().getName()
							+ "']/dataCenter[name='"
							+ dc.getName()
							+ "']/machine");
			Object result = expr.evaluate(doc, XPathConstants.NODESET);
			NodeList nodes = (NodeList) result;
			List<Machine> retList = new ArrayList<Machine>();
			for (int i = 0; i < nodes.getLength(); i++) {
				Machine m = new Machine();
				expr = xpath
						.compile("//virtualOrganizations/virtualOrganization[name='"
								+ dc.getVirtualOrganization().getName()
								+ "']/dataCenter[name='"
								+ dc.getName()
								+ "']/machine["
								+ Integer.toString(i + 1)
								+ "]/name");
				result = expr.evaluate(doc, XPathConstants.STRING);
				m.setName(result.toString());
				m.setDataCenter(dc);
				expr = xpath
						.compile("count(//virtualOrganizations/virtualOrganization[name='"
								+ dc.getVirtualOrganization().getName()
								+ "']/dataCenter[name='"
								+ dc.getName()
								+ "']/machine["
								+ Integer.toString(i + 1)
								+ "]/nodes/node)");
				result = expr.evaluate(doc, XPathConstants.NUMBER);
				Float cnt = Float.parseFloat(result.toString());
				if (cnt > 0)
					for (int j = 0; j < cnt.intValue(); j++) {
						m.getNodes().add(new Machine());
					}
				else {
					expr = xpath
							.compile("//virtualOrganizations/virtualOrganization[name='"
									+ dc.getVirtualOrganization().getName()
									+ "']/dataCenter[name='"
									+ dc.getName()
									+ "']/machine["
									+ Integer.toString(i + 1)
									+ "]/cpuUtilization");
					result = expr.evaluate(doc, XPathConstants.NUMBER);
					cnt = Float.parseFloat(result.toString());
					m.setCpuUtilization(cnt.floatValue());

					expr = xpath
							.compile("//virtualOrganizations/virtualOrganization[name='"
									+ dc.getVirtualOrganization().getName()
									+ "']/dataCenter[name='"
									+ dc.getName()
									+ "']/machine["
									+ Integer.toString(i + 1)
									+ "]/swap");
					result = expr.evaluate(doc, XPathConstants.NUMBER);
					cnt = Float.parseFloat(result.toString());
					m.setSwap(cnt.floatValue());

					expr = xpath
							.compile("//virtualOrganizations/virtualOrganization[name='"
									+ dc.getVirtualOrganization().getName()
									+ "']/dataCenter[name='"
									+ dc.getName()
									+ "']/machine["
									+ Integer.toString(i + 1)
									+ "]/memoryLoad");
					result = expr.evaluate(doc, XPathConstants.NUMBER);
					cnt = Float.parseFloat(result.toString());
					m.setMemoryLoad(cnt.floatValue());
				}
				retList.add(m);
			}
			return retList;
		} catch (XPathExpressionException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Machine> getNodes(Machine parent) {
		String nodePath = "";
		Object result;
		NodeList nodes;
		try {
			if (parent.getTopParent(parent) != null)
				if (parent.getTopParent(parent).getName()
						.equals(parent.getName())) {
					nodePath = "//virtualOrganizations/virtualOrganization[name='"
							+ parent.getTopParent(parent).getDataCenter()
									.getVirtualOrganization().getName()
							+ "']/dataCenter[name='"
							+ parent.getTopParent(parent).getDataCenter()
									.getName()
							+ "']/machine[name='"
							+ parent.getTopParent(parent).getName()
							+ "']/nodes/node ";

				} else {
					System.out.println("ELSE");
					nodePath = "//virtualOrganizations/virtualOrganization[name='"
							+ parent.getTopParent(parent).getDataCenter()
									.getVirtualOrganization().getName()
							+ "']/dataCenter[name='"
							+ parent.getTopParent(parent).getDataCenter()
									.getName()
							+ "']/machine[name='"
							+ parent.getTopParent(parent).getName()
							+ "']/*/node[name='"
							+ parent.getName()
							+ "']/nodes/node";
				}
			expr = xpath.compile(nodePath);
			result = expr.evaluate(doc, XPathConstants.NODESET);
			nodes = (NodeList) result;
			List<Machine> retList = new ArrayList<Machine>();
			for (int i = 0; i < nodes.getLength(); i++) {
				Machine m = new Machine();
				expr = xpath.compile(nodePath + "[" + Integer.toString(i + 1)
						+ "]/name");
				result = expr.evaluate(doc, XPathConstants.STRING);
				m.setName(result.toString());
				m.setParentNode(parent);
				Float cnt;
				expr = xpath.compile(nodePath + "[" + Integer.toString(i + 1)
						+ "]/cpuUtilization");
				result = expr.evaluate(doc, XPathConstants.NUMBER);
				cnt = Float.parseFloat(result.toString());
				m.setCpuUtilization(cnt.floatValue());

				expr = xpath.compile(nodePath + "[" + Integer.toString(i + 1)
						+ "]/swap");
				result = expr.evaluate(doc, XPathConstants.NUMBER);
				cnt = Float.parseFloat(result.toString());
				m.setSwap(cnt.floatValue());

				expr = xpath.compile(nodePath + "[" + Integer.toString(i + 1)
						+ "]/memoryLoad");
				result = expr.evaluate(doc, XPathConstants.NUMBER);
				cnt = Float.parseFloat(result.toString());
				m.setMemoryLoad(cnt.floatValue());
				retList.add(m);
			}
			return retList;
		} catch (XPathExpressionException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Task> getTasks(Machine m) {
		try {
			String taskPath = "";

			Object result;
			NodeList nodes;

			if (m.getTopParent(m) != null)
				if (m.getTopParent(m).getName().equals(m.getName())) {
					taskPath = "//virtualOrganizations/virtualOrganization[name='"
							+ m.getTopParent(m).getDataCenter()
									.getVirtualOrganization().getName()
							+ "']/dataCenter[name='"
							+ m.getTopParent(m).getDataCenter().getName()
							+ "']/machine[name='"
							+ m.getTopParent(m).getName()
							+ "']/runningTasks/task";

				} else {
					taskPath = "//virtualOrganizations/virtualOrganization[name='"
							+ m.getTopParent(m).getDataCenter()
									.getVirtualOrganization().getName()
							+ "']/dataCenter[name='"
							+ m.getTopParent(m).getDataCenter().getName()
							+ "']/machine[name='"
							+ m.getTopParent(m).getName()
							+ "']/nodes/node['"
							+ m.getName()
							+ "']/runningTasks/task";
				}

			System.out.println(taskPath);
			expr = xpath.compile(taskPath);
			result = expr.evaluate(doc, XPathConstants.NODESET);
			nodes = (NodeList) result;
			List<Task> retList = new ArrayList<Task>();
			for (int i = 0; i < nodes.getLength(); i++) {
				Task t = new Task();
				expr = xpath.compile(taskPath + "[" + Integer.toString(i + 1)
						+ "]/taskName");
				result = expr.evaluate(doc, XPathConstants.STRING);
				t.setTaskName(result.toString());
				t.setMachine(m);
				Float cnt;
				expr = xpath.compile(taskPath + "[" + Integer.toString(i + 1)
						+ "]/cpuTime");
				result = expr.evaluate(doc, XPathConstants.NUMBER);
				cnt = Float.parseFloat(result.toString());
				t.setCpuTime(cnt.floatValue());

				expr = xpath.compile(taskPath + "[" + Integer.toString(i + 1)
						+ "]/memoryUsed");
				result = expr.evaluate(doc, XPathConstants.NUMBER);
				cnt = Float.parseFloat(result.toString());
				t.setMemoryUsed(cnt.floatValue());

				retList.add(t);
			}
			return retList;
		} catch (XPathExpressionException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<IODevice> getDevices(Task m) {
		try {
			String devicePath = "";
			Object result;
			NodeList nodes;

			if (m.getMachine().getTopParent(m.getMachine()) != m.getMachine()) {
				devicePath = "//virtualOrganizations/virtualOrganization[name='"
						+ m.getMachine().getParentNode().getDataCenter()
								.getVirtualOrganization().getName()
						+ "']/dataCenter[name='"
						+ m.getMachine().getParentNode().getDataCenter()
								.getName()
						+ "']/machine[name='"
						+ m.getMachine().getTopParent(m.getMachine()).getName()
						+ "']/nodes/node['"
						+ m.getMachine().getName()
						+ "']/runningTasks/task[taskName='"
						+ m.getTaskName()
						+ "']/devices/device";

			} else {
				devicePath = "//virtualOrganizations/virtualOrganization[name='"
						+ m.getMachine().getParentNode().getDataCenter()
								.getVirtualOrganization().getName()
						+ "']/dataCenter[name='"
						+ m.getMachine().getParentNode().getDataCenter()
								.getName()
						+ "']/machine[name='"
						+ m.getMachine().getName()
						+ "']/runningTasks/task[taskName='"
						+ m.getTaskName()
						+ "']/devices/device";
			}
System.out.println(devicePath);
			expr = xpath.compile(devicePath);
			result = expr.evaluate(doc, XPathConstants.NODESET);
			nodes = (NodeList) result;
			List<IODevice> retList = new ArrayList<IODevice>();
			for (int i = 0; i < nodes.getLength(); i++) {
				IODevice t = new IODevice();
				expr = xpath.compile(devicePath + "[" + Integer.toString(i + 1)
						+ "]/name");
				result = expr.evaluate(doc, XPathConstants.STRING);
				t.setName(result.toString());
				t.setTask(m);

				retList.add(t);
			}
			return retList;
		} catch (XPathExpressionException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<File> getFiles(Task m) {
		try {
			String devicePath = "";
			Object result;
			NodeList nodes;
			if (m.getMachine().getParentNode() != null) {
				devicePath = "//virtualOrganizations/virtualOrganization[name='"
						+ m.getMachine().getParentNode().getDataCenter()
								.getVirtualOrganization().getName()
						+ "']/dataCenter[name='"
						+ m.getMachine().getParentNode().getDataCenter()
								.getName()
						+ "']/machine[name='"
						+ m.getMachine().getParentNode().getName()
						+ "']/nodes/node[name='"
						+ m.getMachine().getName()
						+ "']/runningTasks/task[taskName='"
						+ m.getTaskName()
						+ "']/files/file";
			} else {
				devicePath = "//virtualOrganizations/virtualOrganization[name='"
						+ m.getMachine().getDataCenter()
								.getVirtualOrganization().getName()
						+ "']/dataCenter[name='"
						+ m.getMachine().getDataCenter().getName()
						+ "']/machine[name='"
						+ m.getMachine().getName()
						+ "']/runningTasks/task[taskName='"
						+ m.getTaskName()
						+ "']/files/file";
			}
			System.out.println(devicePath);
			expr = xpath.compile(devicePath);
			result = expr.evaluate(doc, XPathConstants.NODESET);
			nodes = (NodeList) result;
			List<File> retList = new ArrayList<File>();
			for (int i = 0; i < nodes.getLength(); i++) {
				File t = new File();
				expr = xpath.compile(devicePath + "[" + Integer.toString(i + 1)
						+ "]/name");
				result = expr.evaluate(doc, XPathConstants.STRING);
				t.setName(result.toString());
				t.setTask(m);

				retList.add(t);
			}
			return retList;
		} catch (XPathExpressionException e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean isLeaf(Machine m) {
		try {
			if (m.getTopParent(m) != null)
				if (m.getTopParent(m).getName().equals(m.getName())) {
					expr = xpath
							.compile("count( "
									+ "//virtualOrganizations/virtualOrganization[name='"
									+ m.getTopParent(m).getDataCenter()
											.getVirtualOrganization().getName()
									+ "']/dataCenter[name='"
									+ m.getTopParent(m).getDataCenter()
											.getName() + "']/machine[name='"
									+ m.getTopParent(m).getName()
									+ "']/nodes/node " + ")");

				} else {
					expr = xpath
							.compile("count(//virtualOrganizations/virtualOrganization[name='"
									+ m.getTopParent(m).getDataCenter()
											.getVirtualOrganization().getName()
									+ "']/dataCenter[name='"
									+ m.getTopParent(m).getDataCenter()
											.getName()
									+ "']/machine[name='"
									+ m.getTopParent(m).getName()
									+ "']/*/node[name='"
									+ m.getName()
									+ "']/nodes/node )");
				}

			Object result = expr.evaluate(doc, XPathConstants.STRING);
			Float cnt = Float.parseFloat(result.toString());
			System.out.println(cnt);
			if (cnt == 0)
				return true;

			return false;
		} catch (XPathExpressionException e) {
			e.printStackTrace();
		}
		return false;
	}

}