package testDAO;

import javax.swing.JOptionPane;

import org.hibernate.mapping.List;
import org.hibernate.validator.AssertTrue;

import beans.Ligne;
import beans.Station;
import dao.LigneDAO;
import dao.StationDAO;
import junit.framework.TestCase;

/****
 * 
 */
public class LigneDAOTest extends TestCase {

	
	String testnomL ;
	String testcommentL ;
	Ligne lg = new Ligne();
	StationDAO daostation ;
	LigneDAO daoligne = new LigneDAO();
	boolean res ; 
	
	@AssertTrue
	public void testCreateLigne() {
				
		
		String testnomL = daoligne.generateRandom();
		String testcommentL = daoligne.generateRandom() ;
		lg = new Ligne(testnomL, testcommentL);
		//Je cree mon instance dans la base 
		daoligne.createLigne(testnomL, testcommentL);
		//une instance de verif
	
		 res = daoligne.existLigne(lg);	
		 
		 System.out.println(res);
		 assertTrue(res);
		 
	} 
	
	public void testSupprimerLigne() {
		String testnomL = daoligne.generateRandom();
		String testcommentL = daoligne.generateRandom();
		
		daoligne.createLigne(testnomL, testcommentL);
		
		int der = daoligne.derniereLigne(lg) ;
     	daoligne.supprimerLigne(der);
     	lg.setIdLigne(der);  
      	boolean res = daoligne.existLigne(lg);
      	assertTrue(res);
	}

	public void testListerLigne() {
		
		String testnomL = daoligne.generateRandom();
		String testcommentL = daoligne.generateRandom();
		
		daoligne.createLigne(testnomL, testcommentL);
	
		
		assertNotNull(daoligne.listerLigne());
	}
	/**
	public void testGetLigneByID() {
		assertNotNull(lg);
		
	}

	public void testModifierLigne() {
		fail("Not yet implemented");
	}
**/	
}
