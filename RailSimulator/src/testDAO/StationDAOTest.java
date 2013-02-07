package testDAO;



import javax.swing.JOptionPane;

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
	
/**				
	public void testCreateStation() {
		
		
		String testnomS = "testCrea";
		String testcommentS = "testcrea";
		
		//Je cree mon instance dans la base 
		daostation.createStation(testnomS, testcommentS);
		
		st.setNomStation(testnomS);
		st.setCommentaireStation(testcommentS);
		
		//une instance de verif
		 res = daostation.existStation(st);
		 
		 assertTrue(res);
		
	}

	public void testSupprimerStation() {
		String testnomS ="testSupprimer1";
		String testcommentS ="testSuprimer1";
		
		daostation.createStation(testnomS, testcommentS);
		
		int der = daostation.derniereStation(st) ;
		
     	daostation.supprimerStation(der);
     	st.setIdStation(der);
  
      	boolean res = daostation.existStation(st);
      	assertTrue(res);
		
	}
	**/
	/**
	public void testGetStationByID() {
		
		assertNotNull(st);
	}
**/
	
	public void testModifierStation() {
		
		//insert dans la base
		String testnomS = JOptionPane.showInputDialog("creez pour modifier ensuite");
		String testcommentS = JOptionPane.showInputDialog("Entrer le commentaire");
		
		daostation.createStation(testnomS, testcommentS);
		st.setNomStation(testnomS);
		st.setCommentaireStation(testcommentS);
		
		String nouvNom = JOptionPane.showInputDialog("le nouveau nom ?");
		String nouvComment = JOptionPane.showInputDialog("Entrer le nouveau commentaire");
		
	
		st.setNomStation(nouvNom);
		st.setCommentaireStation(nouvComment);
		//modifie
		daostation.modifierStation(st);
			
			
			assertTrue(daostation.existStation(st));
						
	}
/**
	public void testListerStation() {
		
		List li = (List) daostation.listerStation();
		//assertNotNull(daostation.listerStation());
		assertEquals(li, daostation.listerStation());
	}**/
}

