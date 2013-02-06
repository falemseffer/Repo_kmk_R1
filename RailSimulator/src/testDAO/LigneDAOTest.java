package testDAO;

import javax.swing.JOptionPane;

import org.hibernate.mapping.List;
import org.hibernate.validator.AssertTrue;

import beans.Ligne;
import dao.LigneDAO;
import junit.framework.TestCase;

/****
 * 
 */
public class LigneDAOTest extends TestCase {

	
	String testnomL ;
	String testcommentL ;
	Ligne lg = new Ligne();
	
	LigneDAO daoligne = new LigneDAO();
	
	@AssertTrue
	public void testCreateLigne() {
		
		String testnomL = JOptionPane.showInputDialog("Entrer le nom");
		String testcommentL = JOptionPane.showInputDialog("Entrer le commentaire");
				
		daoligne.createLigne(testnomL, testcommentL);
		lg.setNomLigne(testnomL);
		lg.setCommentaire(testcommentL);		

		assertTrue(daoligne.existLigne(lg));
	}
	
	public void testSupprimerLigne() {
		String testnomL = JOptionPane.showInputDialog("creer une Ligne pour tester la suppression ensuite, le nom ?");
		String testcommentL = JOptionPane.showInputDialog("Entrer le commentaire");
		
		daoligne.createLigne(testnomL, testcommentL);
		JOptionPane.showMessageDialog(null, "Merci de cliquer pour supp","supp", JOptionPane.INFORMATION_MESSAGE);
		daoligne.supprimerLigne((daoligne.derniereLigne(lg)));		
      	assertFalse(daoligne.existLigne(lg));
	}

	public void testListerLigne() {
		
		List li = (List) daoligne.listerLigne();
		
		assertEquals(li, daoligne.listerLigne());
	}

	public void testGetLigneByID() {
		assertNotNull(lg);
		
	}

	public void testModifierLigne() {
		fail("Not yet implemented");
	}

}
