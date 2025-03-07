package week2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SessionTest
 */
@WebServlet(urlPatterns = { "/SessionTest", "/session_test" }, initParams = {
		@WebInitParam(name = "msg", value = "Hello from Annotation") })
public class SessionTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String msg;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SessionTest() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		msg = config.getInitParameter("msg");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println(msg);

		request.setAttribute("msg", msg);

//		RequestDispatcher dispatcher = request.getRequestDispatcher("session_test.jsp");
//		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		HttpSession session = request.getSession();

		@SuppressWarnings("unchecked")
		HashMap<String, String> contacts = (HashMap<String, String>) session.getAttribute("contacts");

		if (contacts == null) {
			contacts = new HashMap<String, String>();
		}

		String[] input = { phone, name };
		contacts.put(phone, name);
		session.setAttribute("contacts", contacts);

		request.setAttribute("input", input);
		request.setAttribute("contacts", contacts);
		request.getRequestDispatcher("session_post.jsp").forward(request, response);
	}

}
