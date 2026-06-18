package it.pale.tweb.servlet.privato.corsi;

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
 * Servlet implementation class RichiediAggiungi
 */
@WebServlet("/privato/corsi/RichiediAggiungiCorsi")
public class RichiediAggiungiCorsi extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RichiediAggiungiCorsi() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	HttpSession session= request.getSession();
	int id= (int) session.getAttribute("Palestra");
	Palestra p= new Palestra();
	p.setId(id);
	
	CorsoDAO corsiDAO= new CorsoDAO();
	Vector<Corso> corsi= corsiDAO.getAll();
	
	int prossimoID=1;
	if (!corsi.isEmpty()) {
		prossimoID=corsi.lastElement().getId()+1;
	}
	
	request.setAttribute("prossimoID", prossimoID);
	
	
	request.getRequestDispatcher("/WEB-INF/privato/corsi/aggiungiCorsi.jsp").forward(request, response);

	
	}

}
