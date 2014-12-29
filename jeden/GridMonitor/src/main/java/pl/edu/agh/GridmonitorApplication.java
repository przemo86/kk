package pl.edu.agh;

import java.util.ArrayList;
import java.util.Collections;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vaadin.Application;
import com.vaadin.terminal.gwt.server.HttpServletRequestListener;
import com.vaadin.ui.Label;
import com.vaadin.ui.Window;

public class GridmonitorApplication extends Application implements
		HttpServletRequestListener {
	@Override
	public void init() {
		Window mainWindow = new Window("Gridmonitor Application");
		Label label = new Label("Hello Vaadin user");
		mainWindow.addComponent(label);
		setMainWindow(mainWindow);
	}

	public void onRequestStart(HttpServletRequest request,
			HttpServletResponse response) {
	
	}

	public void onRequestEnd(HttpServletRequest request,
			HttpServletResponse response) {

	}

}
