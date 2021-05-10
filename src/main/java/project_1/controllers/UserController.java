package project_1.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import project_1.daos.UserDAO;
import project_1.models.User;
import project_1.services.UserService;

public class UserController {

	private UserService UserServ = new UserService();
	private ObjectMapper om = new ObjectMapper();

	public void getUser(HttpServletResponse resp, String string) throws IOException {
		UserDAO u = UserServ.findUserByName(string);

		// Convert Java object into a JSON string that can be written to the body of an
		// HTTP response
		String json = om.writeValueAsString(u);
		System.out.println(json);
		PrintWriter pw = resp.getWriter();
		pw.print(json);
		resp.setStatus(200);

	}

	public void getAllUsers(HttpServletResponse resp) throws IOException {
		List<User> list = UserServ.getAllUsers();
		String json = om.writeValueAsString(list);
		System.out.println(json);
		PrintWriter pw = resp.getWriter();
		pw.print(json);
		resp.setStatus(200);
	}

	public void addUser(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		BufferedReader reader = req.getReader();

		StringBuilder sb = new StringBuilder();

		String line = reader.readLine();

		while (line != null) {
			sb.append(line);
			line = reader.readLine();
		}

		String body = new String(sb);

		User User = om.readValue(body, User.class);
		
		if(UserServ.createUser(User)) {
			resp.setStatus(201);
		}else {
			resp.setStatus(406);
		}
	}

}
