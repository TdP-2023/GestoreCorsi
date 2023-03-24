package it.polito.tdp.corsi.db;

import it.polito.tdp.corsi.model.Corso;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
			ResultSet rs = st.executeQuery();
			
			while(rs.next()) {
				
				//dentro i get DEVO USARE i nomi delle colonne del db
				Corso c = new Corso(rs.getString("codins"), rs.getInt("crediti"), rs.getString("nome"), rs.getInt("pd"));
				resultCorso.add(c);
			}
			
			rs.close();
			st.close();
			conn.close();
			
			return resultCorso;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Errore in corsoDAO"+ e);
			return null;
		}
	}
	
	public Map<Corso, Integer> getCorsiIscritti (int periodo) {
		
		String sql = "SELECT c.codins, c.crediti, c.nome, c.pd, COUNT(*) AS n "
				+ "FROM corso c, iscrizione i "
				+ "WHERE c.codins = i.codins AND pd = ? "
				+ "GROUP BY c.codins, c.crediti, c.nome, c.pd";
		
		Map<Corso, Integer> result = new HashMap<>();
		Connection conn = ConnectDB.getConnection();
		try {

			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, periodo); //1 = primo parametro (?) -- periodo è il valore che inserisco
			ResultSet rs = st.executeQuery();
			
			while (rs.next()) {
				Corso c = new Corso(rs.getString("codins"), rs.getInt("crediti"), rs.getString("nome"), rs.getInt("pd"));
				result.put(c, rs.getInt("n"));
			}
			
			rs.close();
			st.close();
			conn.close();
			
			return result;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Errore in corsoDAO"+ e);
			return null;
		}
		
	}
	
}
