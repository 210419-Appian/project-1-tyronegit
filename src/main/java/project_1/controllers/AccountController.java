package project_1.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import project_1.models.Account;
import project_1.models.AccountStatus;
import project_1.services.AccountService;

public class AccountController {

	private Account acService = new Account();
	private ObjectMapper om = new ObjectMapper();

	public void getAllAccounts(HttpServletResponse resp) throws IOException {
		// Gets my Accounts from the db.
		int list = acService.getAccountId();
		// Convert Java object into a JSON string that can be written to the body of an
		// HTTP response
		String json = om.writeValueAsString(list);
		System.out.println(json);
		PrintWriter pw = resp.getWriter();
		pw.print(json);
		resp.setStatus(200);
	}

	public void getAccount(HttpServletResponse resp, int id) throws IOException {

		AccountStatus a = acService.getStatus();

		// Convert Java object into a JSON string that can be written to the body of an
		// HTTP response
		String json = om.writeValueAsString(a);
		System.out.println(json);
		PrintWriter pw = resp.getWriter();
		pw.print(json);
		resp.setStatus(200);
	}

	public void addAccount(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		BufferedReader reader = req.getReader();

		StringBuilder sb = new StringBuilder();

		String line = reader.readLine();

		while (line != null) {
			sb.append(line);
			line = reader.readLine();
		}

		String body = new String(sb);

		Account a = om.readValue(body, Account.class);

		if (acService.setStatus(null)) {
			resp.setStatus(201);
		} else {
			resp.setStatus(406);
		}

	}

	public void putAccount(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		BufferedReader reader = req.getReader();

		StringBuilder sb = new StringBuilder();

		String line = reader.readLine();

		while (line != null) {
			sb.append(line);
			line = reader.readLine();
		}

		String body = new String(sb);

		Account a = om.readValue(body, Account.class);

		if(acService.equals(a)) {
			resp.setStatus(200);
		}else {
			resp.setStatus(400);
		}
	}
	
//	public void patchAccount(HttpServletRequest req, HttpServletResponse resp) throws IOException {
//		BufferedReader reader = req.getReader();
//
//		StringBuilder sb = new StringBuilder();
//
//		String line = reader.readLine();
//
//		while (line != null) {
//			sb.append(line);
//			line = reader.readLine();
//		}
//
//		String body = new String(sb);
//
//		Account a = om.readValue(body, Account.class);
//
//		if(acService.updatePartialAccount(a)) {
//			resp.setStatus(200);
//		}else {
//			resp.setStatus(400);
//		}
//	}
//	
//	public void killAccount(HttpServletResponse resp, String mark) {
//		try {
//			int id = Integer.parseInt(mark);
//			if(acService.killAccount(id)) {
//				resp.setStatus(204);
//			}else {
//				resp.setStatus(400);
//			}
//		}catch(NumberFormatException e) {
//			e.printStackTrace();
//			resp.setStatus(418);
//		}
//	}

}
