package week3;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Test
 */
@WebServlet("/test_session")
public class Test extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Test() {
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
		request.getRequestDispatcher("test/test_get.jsp").forward(request, response);
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

		if(contacts == null) contacts = new ArrayList<>();
		
		boolean exist = false;
		
		for(String[] contact : contacts) {
			if(contact[0].equals(newContact[0])) {
				exist = true;
				break;
			}
		}
		
		if (!exist) {
			contacts.add(newContact);
		}
		
		session.setAttribute("contacts", contacts);
		
		request.getRequestDispatcher("test/test_post.jsp").forward(request, response);
	}

}
