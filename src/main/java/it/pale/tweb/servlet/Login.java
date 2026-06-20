package it.pale.tweb.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import it.pale.tweb.dao.beans.Account;
import it.pale.tweb.dao.beans.AccountDAO;
import it.pale.tweb.dao.beans.Personale_amministrativo;
import it.pale.tweb.dao.beans.Personale_amministrativoDAO;
import it.pale.tweb.dao.utils.SecurityPassword;
/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String hashPassword=SecurityPassword.sha512(password); 
			String rememberString = request.getParameter("remember");
			boolean remember = false;
			if(rememberString!=null) {
				remember=true;
			}
			Account account = new Account();
			account.setUsername(username);
			account.setPassword(hashPassword);
			AccountDAO aDAO = new AccountDAO();
			Integer matricola=aDAO.login(account);
			if (matricola!=null) {
				if(remember) {
					Cookie cookieU = new Cookie("username", username);
					Cookie cookieP = new Cookie("password", hashPassword);
					cookieU.setMaxAge(60*60*24);
					cookieP.setMaxAge(60*60*24);
					response.addCookie(cookieU);
					response.addCookie(cookieP);
				}
				
				Personale_amministrativo utente= new Personale_amministrativo();
				utente.setMatricola(matricola);
				Personale_amministrativoDAO pDAO= new Personale_amministrativoDAO();
				int idPalestra=pDAO.getPalestra(utente);
				
				HttpSession session = request.getSession();
				session.setAttribute("autenticato", true);
				session.setAttribute("Palestra", idPalestra);
				
				request.getRequestDispatcher("/WEB-INF/privato/index.jsp").forward(request, response);
			}
			else {
				response.sendRedirect("/RichiediLogin?errore");
			}
		}catch(Exception e) {
			response.sendRedirect("/RichiediLogin?errore");
		}
	}
}
