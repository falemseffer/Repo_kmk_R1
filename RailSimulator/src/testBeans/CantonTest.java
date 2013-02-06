package testBeans;

import beans.Canton;
import beans.Ligne;
import beans.Station;

import junit.framework.TestCase;

public class CantonTest extends TestCase {

	private Canton canton ;
	
	protected void setUp() throws Exception {
		
		super.setUp();
		canton  = new Canton("nom1","comment1");
		}
		
		protected void tearDown() throws Exception {
		super.tearDown();
		canton = null;
	}
		
		//Test creation de l'instant
		public void testCanton() {
			assertNotNull("L'instance est crŽŽe", canton);
		}
/**		
	public void testGetIdCanton() {
	fail("Not yet implemented");
	}

	public void testSetIdCanton() {
		fail("Not yet implemented");
	}
*/
	public void testGetNomCanton() {
		assertEquals("Est ce que nom est correct", "nom1", canton.getNomCanton());
	}

	public void testSetNomCanton() {
		canton.setNomCanton("nom2");
		assertEquals("Est ce que nom est correct", "nom2", canton.getNomCanton());
		
	}

	public void testGetCommentaireCanton() {
		assertEquals("Est ce que nom est correct", "comment1", canton.getCommentaireCanton());
	}

	public void testSetCommentaireCanton() {
		canton.setCommentaireCanton("nom2");
		assertEquals("Est ce que nom est correct", "nom2", canton.getCommentaireCanton());
	}

	/**
	public void testGetLigne() {
	//	assertEquals("Est ce que nom est correct", null, canton.getLigne());
	}

	public void testSetLigne() {
		fail("Not yet implemented");
	}

	public void testGetStation() {
	//	assertEquals("Est ce que nom est correct", null, canton.getStation());
	}

	public void testSetStation() {
		fail("Not yet implemented");
	}
*/
}
