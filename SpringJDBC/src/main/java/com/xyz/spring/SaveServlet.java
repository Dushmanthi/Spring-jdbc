package com.xyz.spring;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String name = request.getParameter("name");
		String country = request.getParameter("country");

		ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");

		User u = (User) app.getBean("usr");
		u.setName(name);
		u.setCountry(country);

		UserDao dao = (UserDao)app.getBean("udao");

		int status = dao.saveUser(u);

		if (status > 0) {
			out.print("<p>Successfully Recorded into database!</p>");
			request.getRequestDispatcher("index.jsp").include(request, response);
		} else {
			out.print("<p>Someting wrong! <br>Please try again!</p>");
		}

		out.close();
	}

}
