package pl.edu.agh.rest;

import java.util.List;

import pl.edu.agh.model.IName;

public class HTMLListBuilder<T extends IName> {

	public String build(List<T> t, String prefix, String postfix) {
		StringBuilder sb = new StringBuilder();

		sb.append("<html>\n");
		sb.append("<body>\n");
		sb.append("<ol>\n");

		for (T tmp : t) {
			sb.append("<li>");
			sb.append("<a href=\"");
			sb.append(prefix + "/"+ tmp.getName() + "/" + postfix);
			sb.append("\">" + tmp.getName() + "</a>");
			sb.append("</li>");
		}
		sb.append("</ol>\n");
		sb.append("</body>\n");
		sb.append("</html>\n");

		return sb.toString();
	}
	
	public static String getHTMLHeaderWithList() {
		StringBuilder sb = new StringBuilder();

		sb.append("<html>\n");
		sb.append("<body>\n");
		sb.append("<ol>\n");
		
		return sb.toString();
	}
	
	public static String getHTMLFooterWithList() {
		StringBuilder sb = new StringBuilder();

		sb.append("</ol>\n");
		sb.append("</body>\n");
		sb.append("</html>\n");
		
		return sb.toString();
	}
	
	public static String getHTMLHeader() {
		StringBuilder sb = new StringBuilder();

		sb.append("<html>\n");
		sb.append("<body>\n");
		
		return sb.toString();
	}
	
	public static String getHTMLFooter() {
		StringBuilder sb = new StringBuilder();

		sb.append("</body>\n");
		sb.append("</html>\n");
		
		return sb.toString();
	}
	
	public static <T extends IName> String getHTMLListItemHRef(T t, String prefix, String postfix) {
		StringBuilder sb = new StringBuilder();
		sb.append("<li>");
		sb.append("<a href=\"");
		sb.append(prefix + "/"+ t.getName() + "/" + postfix);
		sb.append("\">" + t.getName() + "</a>");
		sb.append("</li>");
		return sb.toString();
	}
}
