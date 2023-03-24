package it.polito.tdp.corsi.db;

import it.polito.tdp.corsi.model.Corso;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;



public class CorsoDAO {
	
	/**
	 * 
	 * L'utente passa il periodo richiesto (1 o 2)
	 * @param periodo
	 * @return i corsi per quel periodo
	 */
	public List<Corso> getCorsiByPeriodo(int periodo) {
		
		String sql = "SELECT * "
				+ "FROM corso "
				+ "WHERE pd = ?";
		
		List<Corso> resultCorso = new ArrayList<>();
		
		//apro la connessione
		Connection conn = ConnectDB.getConnection();
		
		try {
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, periodo); //1 = primo parametro (?) -- periodo è il valore che inserisco
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Errore in corsoDAO"+ e);
			return null;
		}
		
		
		
	}
	
}
