package it.pale.tweb.servlet.privato.abbonamento;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Vector;

import it.pale.tweb.dao.beans.AbbonamentoDAO;
import it.pale.tweb.dao.beans.Abbonamento;
import it.pale.tweb.dao.beans.Corso;
import it.pale.tweb.dao.beans.CorsoDAO;
import it.pale.tweb.dao.beans.Cliente;

/**
 * Servlet implementation class DettagliAbbonamento
 */
@WebServlet("/privato/abbonamento/DettagliAbbonamento")
public class DettagliAbbonamento extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DettagliAbbonamento() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String m=request.getParameter("matricola");
		
		if(m!=null) {
			
			Cliente cliente= new Cliente();
			CorsoDAO cDAO= new CorsoDAO();
			Vector<Corso> corsiSeguiti= new Vector<>();
			AbbonamentoDAO aDAO= new AbbonamentoDAO();
			Abbonamento a= new Abbonamento();
			boolean scadenza=false;
			
			try {
				Integer matricola=Integer.parseInt(m);
				cliente.setMatricola(matricola);
				a=aDAO.InfoAbbonamento(cliente);
				scadenza=aDAO.AbbonamentoScaduto(a);
				if(a.getLimiteIngressi()==null) {
					corsiSeguiti=cDAO.getCorsiSeguiti(a);
				}
			}catch(Exception e) {
				response.sendRedirect("/WEB-INF/privato/abbonamento/errore.jsp");
				return;
			}
			request.setAttribute("scadenza", scadenza);
			request.setAttribute("corsiSeguiti", corsiSeguiti);
			request.setAttribute("abbonamento", a);
		}
		request.getRequestDispatcher("/WEB-INF/privato/abbonamento/dettagliAbbonamento.jsp").forward(request, response);
	}

}
