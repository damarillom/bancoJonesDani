package servlets;

import java.io.IOException;
import java.time.LocalDateTime;

import beans.Account;
import beans.Cliente;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.AccountsDAO;
import DAO.TransaccionesDAO;
import beans.Transaccion;

/**
 * Servlet implementation class ListTransactionsServlet
 */
@WebServlet("/ListTransactionsServlet")
public class ListTransactionsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListTransactionsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public List<Transaccion> listaTrans(){
		List<Transaccion> lTrans = new ArrayList<Transaccion>();
		for (int i = 0; i<100; i++){
			Transaccion t = new Transaccion(i,null,0.1,"XXXXXXXXXXXXXXXXXXXXXXXX","XXXXXXXXXXXXXXXXXXXXXXYY");
			lTrans.add(t);
		}
		return lTrans;
	}
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String iban = (String) request.getParameter("iban");
		System.out.println(iban);
		response.sendRedirect("listaTransacciones.jsp?account=" + iban);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
