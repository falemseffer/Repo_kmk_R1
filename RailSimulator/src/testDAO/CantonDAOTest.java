package testDAO;

import javax.swing.JOptionPane;

import org.hibernate.mapping.List;

import dao.CantonDAO;
import dao.LigneDAO;
import dao.StationDAO;

import beans.Canton;
import beans.Ligne;
import beans.Station;

import junit.framework.TestCase;

/****
 * 
 * @author faycallemseffer
 * Test unitaire DAO Canton 
 * 
 *
 */

public class CantonDAOTest extends TestCase {

	String testnomC ;
	String testcommentC ;
	Canton ct = new Canton();	
	CantonDAO daocanton = new CantonDAO();
	LigneDAO daoligne = new LigneDAO();
	StationDAO daostation = new StationDAO();
	Ligne l ;
	Station s ;
	boolean res ; 
	
	public void testCreateCanton() {
		
		String testnomL = daoligne.generateRandom();
		String testcommentL = daoligne.generateRandom() ;
		l = new Ligne(testnomL, testcommentL);
		daoligne.createLigne(testnomL, testcommentL);
		
		String testnomS = daostation.generateRandom();
		String testcommentS = daostation.generateRandom() ;
		s = new Station(testnomS, testcommentS);
		daostation.createStation(testnomS, testcommentS);
		
		String testnomC = daocanton.generateRandom();
		String testcommentC = daocanton.generateRandom() ;					
		daocanton.createCanton(testnomC, testcommentC, l, s);

		res = daocanton.existCanton(ct);			 
		
		 assertTrue(res);
	}
/**
	public void testSupprimerCanton() {

	
		testnomC = "test";
		testcommentC = "test";
		
		 daocanton.createCanton(testnomC, testcommentC,l,s);
		JOptionPane.showMessageDialog(null, "Merci de cliquer pour supp","supp", JOptionPane.INFORMATION_MESSAGE);
		daocanton.supprimerCanton(daocanton.dernierCanton(ct));		
      	assertFalse(daocanton.existCanton(ct));
     }

	public void testListerCanton() {

		List li = (List) daocanton.listerCanton();
		//assertNotNull(daostation.listerStation());
		assertEquals(li, daocanton.listerCanton());
	}

	public void testGetCantonByID() {
		assertNotNull(ct);
	}


	public void testModifierCanton() {
		fail("Not yet implemented");
	}
**/
}
