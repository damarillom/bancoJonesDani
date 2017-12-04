package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.AccountsDAO;
import beans.Account;
import beans.Cliente;

/**
 * Servlet implementation class ListAccountsServlet
 */
@WebServlet("/ListAccountsServlet")
public class ListAccountsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListAccountsServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Cliente c = (Cliente) request.getSession().getAttribute("clientSession");
		List<Account> list = AccountsDAO.getAccounts(c.getDni());
		c.setAccounts(list);
		if (!list.isEmpty()) {
			String encodeURL = response.encodeRedirectURL("listaCuentas.jsp");
			response.sendRedirect(encodeURL);
		}
		doGet(request, response);
		
	}

}
