package it.pale.tweb.servlet.privato.cliente;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Vector;

import it.pale.tweb.dao.beans.Cliente;
import it.pale.tweb.dao.beans.ClienteDAO;
import it.pale.tweb.dao.beans.Personal_trainer;

import org.openpdf.text.Document;
import org.openpdf.text.Element;
import org.openpdf.text.Font;
import org.openpdf.text.Paragraph;
import org.openpdf.text.pdf.PdfPTable;
import org.openpdf.text.pdf.PdfWriter;

/**
 * Servlet implementation class ClientiPDF
 */
@WebServlet("/privato/cliente/ClientiPDF")
public class ClientiPDF extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClientiPDF() {
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
			int id=Integer.parseInt(request.getParameter("pt"));
	        Personal_trainer pt= new Personal_trainer();
	        pt.setMatricola(id);
	        ClienteDAO cDAO= new ClienteDAO();
	    	Vector<Cliente> clientiSeguiti=cDAO.elencaClientiPT(pt);
			
	    	//interpreta i byte della risposta come un pdf
	    	response.setContentType("application/pdf");
	    	
	    	String nomeFile = "Clienti_Seguiti_"+id+".pdf";
	    	
	    	//contenti-disposition impone di scaricare il file, successivamente è riportato il nome consigliato
	    	response.setHeader("Content-Disposition","attachment; filename=\"" + nomeFile + "\"");
	        
			Document document= new Document();
			//collega il documento (cioè il file pdf) alla risposta http
			PdfWriter.getInstance(document, response.getOutputStream());
			document.open();
			
			//TITOLO
			Font titleFont = new Font(Font.HELVETICA, 18, Font.BOLD);
			Paragraph title = new Paragraph("Lista Clienti Seguiti", titleFont);
			title.setAlignment(Element.ALIGN_CENTER);
			document.add(title);
			document.add(new Paragraph(" "));
			
			//TABELLA
			PdfPTable table = new PdfPTable(4);
			
			//COLONNE
			table.addCell("Matricola");
	        table.addCell("Nome");
	        table.addCell("Cognome");
	        table.addCell("Telefono");
	        
	        for(Cliente c: clientiSeguiti) {
	        	table.addCell(Integer.toString(c.getMatricola()));
	        	table.addCell(c.getNome());
	        	table.addCell(c.getCognome());
	        	table.addCell(Long.toString(c.getTelefono()));
	        }
	        
	        document.add(table);
	        document.close();
	        
		}catch(Exception e) {
			response.sendRedirect("/privato/dipendenti/Dipendenti?errore");
		}
	}
}
