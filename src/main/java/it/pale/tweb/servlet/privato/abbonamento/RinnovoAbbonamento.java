package it.pale.tweb.servlet.privato.abbonamento;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import it.pale.tweb.dao.beans.Abbonamento;
import it.pale.tweb.dao.beans.AbbonamentoDAO;

/**
 * Servlet implementation class RinnovoAbbonamento
 */
@WebServlet("/privato/abbonamento/RinnovoAbbonamento")
public class RinnovoAbbonamento extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RinnovoAbbonamento() {
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
		
		AbbonamentoDAO aDAO= new AbbonamentoDAO();
		Abbonamento a=new Abbonamento();
		boolean esito=false;
		
		int fattura=Integer.parseInt(request.getParameter("fattura"));
		a.setFattura(fattura);
		try {
			esito=aDAO.rinnovaAbbonamento(a);
		}catch(Exception e) {
			response.sendRedirect("/WEB-INF/errore.jsp");
			return;
		}
		if(esito) {
			request.getRequestDispatcher("/WEB-INF/privato/abbonamento/dettagliAbbonamento.jsp").forward(request, response);
		}
		else {
			response.sendRedirect("/WEB-INF/errore.jsp");
			return;
		}
		
		
	}

}
