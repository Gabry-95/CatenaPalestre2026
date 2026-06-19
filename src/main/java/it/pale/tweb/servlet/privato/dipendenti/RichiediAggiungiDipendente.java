package it.pale.tweb.servlet.privato.dipendenti;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Vector;

import it.pale.tweb.dao.beans.Corso;
import it.pale.tweb.dao.beans.CorsoDAO;
import it.pale.tweb.dao.beans.Palestra;

/**
 * Servlet implementation class RichiediAggiungiDipendente
 */
@WebServlet("/privato/dipendenti/RichiediAggiungiDipendente")
public class RichiediAggiungiDipendente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RichiediAggiungiDipendente() {
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
		
		int id=(int)request.getSession().getAttribute("Palestra");
		Palestra p= new Palestra();
		p.setId(id);
		
		CorsoDAO cDAO= new CorsoDAO();
		Vector<Corso> corsi= cDAO.getCorso(p); 
		
		request.setAttribute("corsi", corsi);
		request.getRequestDispatcher("/WEB-INF/privato/dipendenti/aggiungiDipendente.jsp").forward(request, response);
	}

}
