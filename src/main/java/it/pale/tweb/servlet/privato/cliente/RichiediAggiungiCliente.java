package it.pale.tweb.servlet.privato.cliente;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * Servlet implementation class RichiediAggiungiCliente
 */
@WebServlet("/privato/cliente/RichiediAggiungiCliente")
public class RichiediAggiungiCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RichiediAggiungiCliente() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//QUI NON HO NECESSITA' DI SAPERE A QUALE PALESTRA APPARTIENE 
		
		request.getRequestDispatcher("/WEB-INF/privato/cliente/aggiungiCliente.jsp").forward(request, response);
	
	}
}
