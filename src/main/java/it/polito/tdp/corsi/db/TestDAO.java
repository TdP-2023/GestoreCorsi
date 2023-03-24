package it.polito.tdp.corsi.db;


import it.polito.tdp.corsi.model.Corso;


import java.util.*;

public class TestDAO {
	public static void main(String[] args) {
		
		CorsoDAO dao = new CorsoDAO();
		
		List<Corso> result = new ArrayList<>();
		
		for (Corso c : result) {
			System.out.println(""+c);
		}
		
	}
}
