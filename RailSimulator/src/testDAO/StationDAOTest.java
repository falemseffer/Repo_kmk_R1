package testDAO;

import javax.swing.JOptionPane;

import org.hibernate.mapping.List;

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
	
				
	public void testCreateStation() {
		
		
		String testnomS = JOptionPane.showInputDialog("Entrer le nom");
		String testcommentS = JOptionPane.showInputDialog("Entrer le commentaire");
				
		daostation.createStation(testnomS, testcommentS);
		st.setNomStation(testnomS);
		st.setCommentaireStation(testcommentS);		

		assertTrue(daostation.existStation(st));
		
	}

	public void testSupprimerStation() {
		String testnomS = JOptionPane.showInputDialog("creer une station pour tester la suppression ensuite, le nom ?");
		String testcommentS = JOptionPane.showInputDialog("Entrer le commentaire");
		
		daostation.createStation(testnomS, testcommentS);
		JOptionPane.showMessageDialog(null, "Merci de cliquer pour supp","supp", JOptionPane.INFORMATION_MESSAGE);
      	daostation.supprimerStation(daostation.derniereStation(st));		
      	assertFalse(daostation.existStation(st));
		
	}

	public void testGetStationByID() {
		
		assertNotNull(st);
	}

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
			
		assertFalse(nouvNom.equals(testnomS));
						
	}

	public void testListerStation() {
		
		List li = (List) daostation.listerStation();
		//assertNotNull(daostation.listerStation());
		assertEquals(li, daostation.listerStation());
	}

}
