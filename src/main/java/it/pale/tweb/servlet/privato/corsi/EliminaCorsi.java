package it.pale.tweb.servlet.privato.corsi;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import it.pale.tweb.dao.beans.Corso;
import it.pale.tweb.dao.beans.CorsoDAO;

/**
 * Servlet implementation class Corsi
 */
@WebServlet("/privato/corsi/EliminaCorsi")
public class EliminaCorsi extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EliminaCorsi() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("autenticato")==null) {
			response.sendRedirect("/RichiediLogin?errore");
			return ;
		}
		
		try {
			boolean esito=false;
			String ids=request.getParameter("id");
			
			int id=Integer.parseInt(ids);
			
			Corso corso= new Corso();
			corso.setId(id);
			CorsoDAO corsoDAO= new CorsoDAO();
			corsoDAO.elimina(corso);
			if(esito) {
				response.sendRedirect("RichiediCorsi");
			}
			else {
				response.sendRedirect("RichiediCorsi?errore");
			}
		}catch(Exception e) {
			response.sendRedirect("RichiediCorsi?errore");
		}
	}

}
