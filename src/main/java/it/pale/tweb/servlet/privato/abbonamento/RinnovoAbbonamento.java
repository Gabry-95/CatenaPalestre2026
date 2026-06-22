package it.pale.tweb.servlet.privato.abbonamento;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Vector;

import it.pale.tweb.dao.beans.Abbonamento;
import it.pale.tweb.dao.beans.AbbonamentoDAO;
import it.pale.tweb.dao.beans.Corso;
import it.pale.tweb.dao.beans.CorsoDAO;

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
		
		try {
			AbbonamentoDAO aDAO= new AbbonamentoDAO();
			Abbonamento scaduto=new Abbonamento();
			CorsoDAO cDAO= new CorsoDAO();
			boolean esito=false;
			int costiAggiornati=0;
			
			int fattura=Integer.parseInt(request.getParameter("fattura"));
			scaduto.setFattura(fattura);
			scaduto=aDAO.get(scaduto);
			
			Vector<Corso> corsiSeguiti=cDAO.getCorsiSeguiti(scaduto);
			costiAggiornati=cDAO.costoCorsiAbbonamento(corsiSeguiti);
			
			Abbonamento nuovo=new Abbonamento(scaduto.getFattura(), scaduto.getTipo(), scaduto.getCliente(), costiAggiornati);
			esito=aDAO.rinnovaAbbonamento(nuovo);
			if(esito) {
				request.getRequestDispatcher("/WEB-INF/privato/abbonamento/dettagliAbbonamento.jsp").forward(request, response);
			}
			else {
				response.sendRedirect("/privato/abbonamento/DettagliAbbonamento?errore");
				return;
			}
		}catch(Exception e) {
			response.sendRedirect("/privato/abbonamento/DettagliAbbonamento?errore");
			return;
		}
	}

}
