package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.ClienteDAO;
import beans.Cliente;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
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
	 * Cliente c = ClienteDAO.regValid(dni,pass,surname,birthday,sex,address,name,phone);
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
		String dni = request.getParameter("dniReg");
		String pass = request.getParameter("passReg");
		String surname = request.getParameter("surnameReg");
		String birthday = request.getParameter("birthdayReg");
		char sex = request.getParameter("sexReg").charAt(0);
		String address = request.getParameter("addressReg"); 
		String name = request.getParameter("nameReg");
		String phone = request.getParameter("phoneReg");	
		boolean result = ClienteDAO.regValid(dni, surname, birthday, pass, sex, address, name, phone);
		
		if (result) {
			request.getRequestDispatcher("loginok.jsp").include(request,response);
		} else {
			request.getRequestDispatcher("loginko.jsp").include(request,response);
		}
	}

}
