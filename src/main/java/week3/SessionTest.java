package week3;

import java.io.IOException;
import java.util.*;

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
@WebServlet(urlPatterns = "/contact", initParams = { @WebInitParam(name = "msg", value = "Hello from Annotation"),
		@WebInitParam(name = "x", value = "10"), })
public class SessionTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

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
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		request.getRequestDispatcher("week3/session_get.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String[] newContact = { request.getParameter("phone"), request.getParameter("name") };

		HttpSession session = request.getSession(true);

		List<String[]> contacts = (List<String[]>) session.getAttribute("contacts");

		if (contacts == null) {
			contacts = new ArrayList<>();
		}

		boolean exist = false;

		for (String[] contact : contacts) {
			if (contact[0].equals(newContact[0])) {
				exist = true;
				break;
			}
		}

		if (!exist) {
			contacts.add(newContact);
		}

		session.setAttribute("contacts", contacts);

		request.setAttribute("contacts", contacts);

		request.getRequestDispatcher("week3/session_post.jsp").forward(request, response);
		;
	}

}
