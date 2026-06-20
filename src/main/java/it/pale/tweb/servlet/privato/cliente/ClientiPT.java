package it.pale.tweb.servlet.privato.cliente;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Vector;

import it.pale.tweb.dao.beans.Personal_trainer;
import it.pale.tweb.dao.beans.Cliente;
import it.pale.tweb.dao.beans.ClienteDAO;


/**
 * Servlet implementation class ClientiPT
 */
@WebServlet("/privato/cliente/ClientiPT")
public class ClientiPT extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClientiPT() {
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
    	
    	Integer id=Integer.parseInt(request.getParameter("pt"));
    	Personal_trainer pt= new Personal_trainer();
    	pt.setMatricola(id);
    	ClienteDAO cDAO= new ClienteDAO();
    	Vector<Cliente> clientiSeguiti=cDAO.elencaClientiPT(pt);
    	
    	request.setAttribute("clientiSeguiti", clientiSeguiti);
    	request.setAttribute("pt", id);
    	request.getRequestDispatcher("/WEB-INF/privato/cliente/clientiPT.jsp").forward(request, response);
    }

}
