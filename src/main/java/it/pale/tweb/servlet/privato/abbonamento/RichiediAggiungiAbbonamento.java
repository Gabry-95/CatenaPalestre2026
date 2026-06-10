package it.pale.tweb.servlet.privato.abbonamento;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import java.util.Vector;
import it.pale.tweb.dao.beans.Corso;
import it.pale.tweb.dao.beans.CorsoDAO;
import it.pale.tweb.dao.beans.Palestra;

/**
 * Servlet implementation class RichiediAggiungiAbbonamento
 */
@WebServlet("/privato/abbonamento/RichiediAggiungiAbbonamento")
public class RichiediAggiungiAbbonamento extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RichiediAggiungiAbbonamento() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id=(int)request.getSession().getAttribute("Palestra");
		Palestra p= new Palestra();
		p.setId(id);
				
		CorsoDAO cDAO= new CorsoDAO();
		Vector<Corso> corsi= cDAO.getCorso(p); 
		
		request.setAttribute("corsi", corsi);
		request.getRequestDispatcher("/WEB-INF/privato/abbonamento/aggiungiAbbonamento.jsp").forward(request, response);
	}
}