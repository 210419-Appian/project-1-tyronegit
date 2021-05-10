package project_1.web;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project_1.controllers.AccountController;
import project_1.controllers.UserController;

public class Project_1ControllerServlet extends HttpServlet {

	private String BaseURL = null;
	private AccountController avControl = new AccountController();
	private AccountController UserControl = new AccountController();

	@Override
	public void init(ServletConfig config) throws ServletException {
		BaseURL = config.getInitParameter("BaseURL");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json");

		resp.setStatus(404); // default if someone sends a malformed request.

		final String URL = req.getRequestURI().replace(BaseURL, "");

		System.out.println(URL);

		// A path variable is a way to pass information about the request in the URL
		// itself. Generally you have
		// a final / in the url that takes a variable input. i.e. Account/1 will get you
		// the first Account while
		// Account/2 gets the second etc.

		String[] sections = URL.split("/");

		System.out.println(sections);

		switch (sections[0]) {
		case "Accounts":
			if (req.getMethod().equals("GET")) {
				if (sections.length == 2) {
					int id = Integer.parseInt(sections[1]);
					avControl.getAccount(resp, id);
				} else {
					avControl.getAllAccounts(resp);
				}
			} else if (req.getMethod().equals("POST")) {
				avControl.addAccount(req, resp);
			} else if (req.getMethod().equals("PUT")&&sections.length==2) {
				avControl.putAccount(req, resp);
			} else if (req.getMethod().equals("PATCH")&&sections.length==2) {
				avControl.patchAccount(req, resp);
			} else if (req.getMethod().equals("DELETE")&&sections.length==2) {
				avControl.killAccount(resp, sections[1]);
			}
			break;
		case "Users":
			if (req.getMethod().equals("GET")) {
				if (sections.length == 2) {
					UserControl.getUser(resp, sections[1]);
				} else {
					UserControl.getAllAccounts(resp);
				}
			}else if(req.getMethod().equals("POST")) {
				UserControl.addUser(req, resp);
			}
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
	protected void doPatch(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(req.getMethod().equals("PATCH")) {
			doPatch(req, resp);
		}else {
			super.service(req, resp);
		}
	}
	
}
