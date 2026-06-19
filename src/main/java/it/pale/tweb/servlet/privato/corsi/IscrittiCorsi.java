package it.pale.tweb.servlet.privato.corsi;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.Vector;

import it.pale.tweb.dao.beans.Cliente;
import it.pale.tweb.dao.beans.ClienteDAO;
import it.pale.tweb.dao.beans.Corso;
import it.pale.tweb.dao.beans.CorsoDAO;
import it.pale.tweb.dao.beans.Palestra;

/**
 * Servlet implementation class IscrittiCorsi
 */
@WebServlet("/privato/corsi/IscrittiCorsi")
public class IscrittiCorsi extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IscrittiCorsi() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("autenticato")==null) {
			response.sendRedirect("/RichiediLogin?errore");
			return ; 
		}
		
		int idPale= (int) request.getSession().getAttribute("Palestra");
		Palestra p= new Palestra();
		p.setId(idPale);
		
		Vector<Corso> corsi= new Vector<Corso>();
		CorsoDAO corsiDAO= new CorsoDAO();
		corsi=corsiDAO.getCorso(p);
		
		String idCorsiS=request.getParameter("id");
		if(idCorsiS!=null) {
			int idCorsi=Integer.parseInt(idCorsiS);
		
			Corso corsoScelto=new Corso();
			corsoScelto.setId(idCorsi);
			
			Vector<Cliente> c= new Vector<Cliente>();
			ClienteDAO cDAO= new ClienteDAO();
			c=cDAO.IscrittiCorso(corsoScelto);
			
		request.setAttribute("clienti", c);
		request.setAttribute("selected", corsoScelto);
		}
		request.setAttribute("corsi", corsi);
		request.getRequestDispatcher("/WEB-INF/privato/corsi/iscrittiCorsi.jsp").forward(request, response);
	}

}
