package testDAO;

import javax.swing.JOptionPane;

import org.hibernate.mapping.List;

import dao.CantonDAO;

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
	Ligne l = new Ligne();
	Station s = new Station();
	
	public void testCreateCanton() {
		
		 testnomC = "creationStation";
		 testcommentC = "TestCreationStation";
			
		ct.setNomCanton(testnomC);
		ct.setCommentaireCanton(testcommentC);
		
		daocanton.createCanton(testnomC, testcommentC, l, s);
		
		ct.setNomCanton(testnomC);
		ct.setCommentaireCanton(testcommentC);	
		
		assertTrue(daocanton.existCanton(ct));
	}

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

}
