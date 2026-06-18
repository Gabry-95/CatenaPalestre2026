package it.pale.tweb.servlet.privato.corsi;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import it.pale.tweb.dao.beans.Corso;
import it.pale.tweb.dao.beans.CorsoDAO;
import it.pale.tweb.dao.beans.Palestra;

/**
 * Servlet implementation class AggiungiCorsi
 */
@WebServlet("/privato/corsi/AggiungiCorsi")
public class AggiungiCorsi extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AggiungiCorsi() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	HttpSession session= request.getSession();
	int id=(int) session.getAttribute("Palestra");
	Palestra p= new Palestra();
	p.setId(id);
	
	String idS= request.getParameter("ID");
	String nome= request.getParameter("nome");
	String costoS=request.getParameter("costo");
	String tipo=request.getParameter("tipo");
	
	int idSS= Integer.parseInt(idS);
	int costo= Integer.parseInt(costoS);
	
	Corso c= new Corso();
	c.setId(idSS);
	c.setNome(nome);
	c.setCosto(costo);
	c.setTipo(tipo);
	c.setPalestra(id);
	
	CorsoDAO corsoDAO= new CorsoDAO();
	
	corsoDAO.salva(c);
	response.sendRedirect("RichiediCorsi");
	}

}
