package testBeans;

import beans.Station;
import junit.framework.TestCase;

public class StationTest extends TestCase {

	
	private Station station ;
	
	protected void setUp() throws Exception {
		
		super.setUp();
		station  = new Station("nom1","comment1");
		}
		
		protected void tearDown() throws Exception {
		super.tearDown();
		station = null;
	}
		
		//Test creation de l'instant
		public void testStation() {
		assertNotNull("L'instance est crŽŽe", station);
		}
	/**
	public void testGetIdStation() {
		fail("Not yet implemented");
	}

	public void testSetIdStation() {
		fail("Not yet implemented");
	}
*/
	public void testGetNomStation() {
		assertEquals("Est ce que nom est correct", "nom1", station.getNomStation());
	}

	public void testSetNomStation() {
		station.setNomStation("nom2");
		assertEquals("Est ce que nom est correct", "nom2", station.getNomStation());
	
	}

	public void testGetCommentaireStation() {
		assertEquals("Est ce que prenom est correct", "comment1", station.getCommentaireStation());
	}

	public void testSetCommentaireStation() {
		station.setCommentaireStation("comment2");
		assertEquals("Est ce que nom est correct", "comment2", station.getCommentaireStation());
		
	}
	
/**
	public void testGetCantonlist() {
		fail("Not yet implemented");
	}

	public void testSetCantonlist() {
		fail("Not yet implemented");
	}
	**/
}
