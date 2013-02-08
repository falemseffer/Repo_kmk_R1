package testDAO;


import dao.StationDAO;
import beans.Station;
import junit.framework.TestCase;

/**
 * **/


public class StationDAOTest extends TestCase {
		
		String testnomS ;
		String testcommentS ;
		Station st = new Station();		
		StationDAO daostation = new StationDAO();	
		boolean res ; 
	
			
	public void testCreateStation() {	
			
		String testnomS = daostation.generateRandom();
		String testcommentS = daostation.generateRandom() ;
		st = new Station(testnomS, testcommentS);
		//Je cree mon instance dans la base 
		daostation.createStation(testnomS, testcommentS);
		//une instance de verif
		 res = daostation.existStation(st);	
		 assertTrue(res);
		
	}

	public void testSupprimerStation() {
		//initialise deux chaines pour la création d'une nouvelle station qui sera suprimer après
		String testnomS = daostation.generateRandom();
		String testcommentS = daostation.generateRandom();
		st = new Station(testnomS, testcommentS);
		daostation.createStation(testnomS,testcommentS);		
		st = new Station(testnomS,testcommentS);
		int der = daostation.derniereStation() ;	
		st.setIdStation(der);
     	daostation.supprimerStation(der);  	  
     	res = daostation.existStation(st);     	
      	assertTrue(res);
		
	}
	
	public void testListerStation() {
		
		String testnomS = daostation.generateRandom();
		String testcommentS = daostation.generateRandom();
	
		daostation.createStation(testnomS, testcommentS);	
	
		assertNotNull(daostation.listerStation());
}

/**
	public void testGetStationByID() {
		
		int sta = daostation.getStationByID(st.getIdStation()).getIdStation();
		
		assertEquals(st.getIdStation(),""+sta);
	}
	
**/	
	public void testModifierStation() {
		
		//insert dans la base
		String testnomS = daostation.generateRandom();
		String testcommentS = daostation.generateRandom();
		
		daostation.createStation(testnomS, testcommentS);
		
		String nouvNom = daostation.generateRandom();
		String nouvComment = daostation.generateRandom();	
				
		st.setNomStation(nouvNom);
		st.setCommentaireStation(nouvComment);
		st.setIdStation(daostation.derniereStation());
		daostation.modifierStation(st);				
		assertNotSame(testnomS, st.getNomStation());
			
						
	}



}

