package it.pale.tweb.dao.beans;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.sql.Connection;
import it.pale.tweb.dao.utils.DBManager;

public class ClienteDAO {
	private static Connection conn = null;

	public Cliente get(Cliente cliente) {
		String query = "SELECT * FROM Cliente WHERE Matricola=?";

		Cliente res = null;
		PreparedStatement ps;
		conn = DBManager.startConnection();
		try {
			ps = conn.prepareStatement(query);
			ps.setInt(1, cliente.getMatricola());
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				res = recordToCliente(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBManager.closeConnection();
		return res;
	}

	public boolean salva(Cliente cliente) {
		String query = "INSERT INTO Cliente (nome, cognome, telefono) VALUES ( ?, ?, ?)";
		boolean esito = false;

		PreparedStatement ps;
		conn = DBManager.startConnection();
		try {
			ps = conn.prepareStatement(query);

			ps.setString(1, cliente.getNome());
			ps.setString(2, cliente.getCognome());
			ps.setLong(3, cliente.getTelefono());

			int tmp = ps.executeUpdate();
			if (tmp == 1)
				esito = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBManager.closeConnection();
		return esito;
	}

	private Cliente recordToCliente(ResultSet rs) throws SQLException {
		Cliente cliente = new Cliente();
		cliente.setMatricola(rs.getInt("matricola"));
		cliente.setNome(rs.getString("nome"));
		cliente.setCognome(rs.getString("cognome"));
		cliente.setTelefono(rs.getLong("telefono"));
		return cliente;
	}

	public boolean elimina(Cliente cliente) {
		String query = "DELETE FROM Cliente WHERE Matricola = ?";
		boolean esito = false;

		PreparedStatement ps;
		conn = DBManager.startConnection();
		try {
			ps = conn.prepareStatement(query);
			ps.setInt(1, cliente.getMatricola());

			int tmp = ps.executeUpdate();
			if (tmp == 1)
				esito = true;

		} catch (SQLException e) {
			esito = false;
			e.printStackTrace();
		}
		DBManager.closeConnection();
		return esito;
	}

	public Vector<Cliente> getAll() {
		String query = "SELECT * FROM Cliente order by matricola";

		Vector<Cliente> res = new Vector<Cliente>();
		PreparedStatement ps;
		conn = DBManager.startConnection();
		try {
			ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Cliente cliente = recordToCliente(rs);
				res.add(cliente);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBManager.closeConnection();
		return res;
	}

	public boolean modifica(Cliente cliente) {
		String query = "UPDATE Cliente SET nome=?, cognome=?, telefono=? WHERE Matricola=?";
		boolean esito = false;

		PreparedStatement ps;
		conn = DBManager.startConnection();
		try {
			ps = conn.prepareStatement(query);

			ps.setString(1, cliente.getNome());
			ps.setString(2, cliente.getCognome());
			ps.setLong(3, cliente.getTelefono());
			ps.setInt(4, cliente.getMatricola());

			int tmp = ps.executeUpdate();
			if (tmp == 1)
				esito = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBManager.closeConnection();
		return esito;
	}

	public Vector<Cliente> elencaClientiPT(Personal_trainer pt) {
		
		String query ="SELECT cliente.matricola, cliente.Nome, cliente.cognome, cliente.telefono FROM personal_trainer "
				+ "JOIN segue ON segue.PersonalTrainer = personal_trainer.Matricola "
				+ "JOIN abbonamento ON abbonamento.Fattura = segue.Abbonamento "
				+ "JOIN cliente ON cliente.Matricola = abbonamento.Cliente "
				+ "WHERE personal_trainer.Matricola=?";

		Vector<Cliente> res = new Vector<Cliente>();
		PreparedStatement ps;
		conn = DBManager.startConnection();
		try {
			ps = conn.prepareStatement(query);
			ps.setInt(1, pt.getMatricola());
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Cliente c = recordToCliente(rs);
				res.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBManager.closeConnection();
		return res;
	}
	
	public Vector<Cliente> IscrittiCorso(Corso c){
	
		String query="SELECT DISTINCT cliente.matricola, cliente.nome, cliente.cognome, cliente.telefono FROM cliente "
				+ "JOIN abbonamento ON abbonamento.cliente = cliente.Matricola "
				+ "JOIN frequenta ON frequenta.Abbonamento = abbonamento.Fattura "
				+ "JOIN corso ON corso.ID = frequenta.Corso "
				+ "WHERE corso.ID=?";
		
		Vector<Cliente> res= new Vector<Cliente>();
		PreparedStatement ps;
		conn = DBManager.startConnection();
		try {
			ps = conn.prepareStatement(query);
			ps.setInt(1, c.getId());
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Cliente cliente = recordToCliente(rs);
				res.add(cliente);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return res;
	}
	
	public Cliente getFromTelefono(Cliente c) {
		String query = "SELECT * FROM Cliente WHERE telefono=?";

		Cliente res = null;
		PreparedStatement ps;
		conn = DBManager.startConnection();
		try {
			ps = conn.prepareStatement(query);
			ps.setLong(1, c.getTelefono());
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				res = recordToCliente(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBManager.closeConnection();
		return res;
	}
}
