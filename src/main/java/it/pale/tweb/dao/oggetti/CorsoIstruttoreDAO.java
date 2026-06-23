package it.pale.tweb.dao.oggetti;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.sql.Connection;
import it.pale.tweb.dao.utils.DBManager;

import it.pale.tweb.dao.beans.Corso;
import it.pale.tweb.dao.beans.Istruttore_corso;
import it.pale.tweb.dao.beans.Palestra;

public class CorsoIstruttoreDAO {
	private static Connection conn = null;
	
	private CorsoIstruttore recordToCorsoIstruttore(ResultSet rs) throws SQLException {
		
		Corso corso = new Corso();
		corso.setId(rs.getInt("id"));
		corso.setNome(rs.getString("nome_corso"));
		corso.setCosto(rs.getInt("costo"));
		corso.setTipo(rs.getString("tipo"));
		corso.setPalestra(rs.getInt("palestra_corso"));

		Istruttore_corso istruttoreC = new Istruttore_corso();
		istruttoreC.setMatricola(rs.getInt("matricola"));
		istruttoreC.setNome(rs.getString("nome_istruttore"));
		istruttoreC.setCognome(rs.getString("cognome"));
		istruttoreC.setPalestra(rs.getInt("palestra_istruttore"));
		istruttoreC.setTelefono(rs.getLong("telefono"));
		
		CorsoIstruttore corsoIstruttore = new CorsoIstruttore(istruttoreC, corso);

		return corsoIstruttore;
	}
	
	public Vector<CorsoIstruttore> ListaCorsoIstruttore(Palestra p){
		String query = "SELECT ic.Matricola, ic.Nome AS \"nome_istruttore\", ic.Cognome, ic.Palestra AS \"palestra_istruttore\", ic.Telefono, c.ID, c.Nome AS \"nome_corso\", c.Costo, c.Tipo, c.Palestra AS \"palestra_corso\" "
				+ "FROM istruttore_corso AS ic "
				+ "JOIN insegna ON ic.Matricola = insegna.istruttoreCorso "
				+ "JOIN corso AS c ON insegna.Corso = c.ID "
				+ "WHERE ic.Palestra=?";

		Vector<CorsoIstruttore> res = new Vector<CorsoIstruttore>();
		PreparedStatement ps;
		conn = DBManager.startConnection();
		try {
			ps = conn.prepareStatement(query);
			ps.setInt(1, p.getId());
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				CorsoIstruttore ci = recordToCorsoIstruttore(rs);
				res.add(ci);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBManager.closeConnection();
		return res;
	}
	
}
