package testBeans;

import beans.Ligne;
import junit.framework.TestCase;

public class LigneTest extends TestCase {

	private Ligne ligne ; 
	
	protected void setUp() throws Exception {
		
		super.setUp();
		ligne  = new Ligne("nom1","comment1");
		}
		
		protected void tearDown() throws Exception {
		super.tearDown();
		ligne = null;
	}
	
	
	public void testLigne() {
		assertNotNull("L'instance est crŽŽe", ligne);
	}

	public void testGetNomLigne() {
		assertEquals("Est ce que nom est correct", "nom1", ligne.getNomLigne());
		
	}

	public void testSetNomLigne() {
		ligne.setNomLigne("nom2");
		assertEquals("Est ce que nom est correct", "nom2", ligne.getNomLigne());

	}

	public void testGetCommentaire() {
		assertEquals("Est ce que nom est correct", "comment1", ligne.getCommentaire());
	}

	public void testSetCommentaire() {
		ligne.setCommentaire("comment2");
		assertEquals("Est ce que nom est correct", "comment2", ligne.getCommentaire());
	
	}

}
