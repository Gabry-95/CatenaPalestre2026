package it.pale.tweb.servlet.privato.cliente;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import it.pale.tweb.dao.beans.Cliente;
import it.pale.tweb.dao.beans.ClienteDAO;

/**
 * Servlet implementation class AggiungiCliente
 */
@WebServlet("/privato/cliente/AggiungiCliente")
public class AggiungiCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AggiungiCliente() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if (request.getSession().getAttribute("autenticato")==null) {
			response.sendRedirect("/RichiediLogin?errore");
			return;
		}
		
		String nome=request.getParameter("nome");
		String cognome=request.getParameter("cognome");
		long telefono=Long.parseLong(request.getParameter("telefono"));
		
		Cliente c= new Cliente();
		ClienteDAO cDAO= new ClienteDAO();
		
		c.setNome(nome);
		c.setCognome(cognome);
		c.setTelefono(telefono);
		boolean esito= cDAO.salva(c);
		
		if(esito) {
			request.getRequestDispatcher("/WEB-INF/privato/cliente/aggiungiCliente.jsp").forward(request, response);
		}
		else {
			request.getRequestDispatcher("/WEB-INF/errore1.jsp").forward(request, response);
		}
	}
}
