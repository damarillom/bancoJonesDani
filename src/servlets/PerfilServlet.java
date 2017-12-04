package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.ClienteDAO;
import beans.Account;
import beans.Cliente;
import DAO.AccountsDAO;

/**
 * Servlet implementation class PerfilServlet
 */
@WebServlet("/PerfilServlet")
public class PerfilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PerfilServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cliente = request.getParameter("cliente");
		List<Account> accounts = AccountsDAO.getAccounts(cliente);
		if (/*c.isValid()*/true) {
			HttpSession session = request.getSession();
			//session.setAttribute("clientSession", c);
			String encodeURL = response.encodeRedirectURL("loginok.jsp");
			response.sendRedirect(encodeURL);
			//request.getRequestDispatcher("loginok.jsp").include(request,response);
		} else {
			request.getRequestDispatcher("loginko.jsp").include(request,response);
		}
	}

}
