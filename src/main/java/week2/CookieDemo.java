package week2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Cookie;

/**
 * Servlet implementation class Cookie
 */
@WebServlet("/Cookie")
public class CookieDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CookieDemo() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out = response.getWriter();
		out.println("""
				<!DOCTYPE html>
				<html>
				<head>
				<meta charset="UTF-8">
				<title>Insert title here</title>
				</head>
				<body>
					<form action="%s/Cookie" method="post">
						<h3>Create Cookie</h3>
						<label> Cookie name <input type='text' name='cookie_name' /></label><br>
						<label> Cookie value <input type='text' name='cookie_value' /></label><br>
						<input type='submit' value='Submit'/>
					</form>
					<a href="/servlet/CookieRead">View</a>
				</body>
				</html>
				""".formatted(request.getContextPath()));
		System.out.println("calling GET");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		Cookie cookie = new Cookie(request.getParameter("cookie_name"), request.getParameter("cookie_value"));
		cookie.setMaxAge(3600);
		response.addCookie(cookie);
		out.println("""
				<!DOCTYPE html>
				<html>
				<head>
				<meta charset="UTF-8">
				<title>Cookie Demo</title>
				</head>
				<body>
					<h3>Cookie Created</h3>
					<p>Cookie name: %s</p>
					<p>Cookie value: %s</p>
				</body>
				</html>
				""".formatted(request.getParameter("cookie_name"), request.getParameter("cookie_value")));
		System.out.println("calling POST");
	}

}
