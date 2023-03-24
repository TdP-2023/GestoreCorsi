package it.polito.tdp.corsi.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {

	public static Connection getConnection() {
		
		String url = "jdbc:mariadb://localhost/iscritticorsi?user=root&password=root";
		
		try {
			return DriverManager.getConnection(url);
		} catch (SQLException e) {
			System.out.println("Errore nella connessione al database: "+ e);
		}
		return null;
		
	}
	
}
