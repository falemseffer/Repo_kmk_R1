package testBeans;

import beans.Canton;


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

}
