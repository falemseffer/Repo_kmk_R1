package testDAO;

import org.hibernate.validator.AssertTrue;
import beans.Ligne;
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

		daoligne.createLigne(testnomL, testcommentL);
		
		res = daoligne.existLigne(lg);			 
		
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
**/
	public void testModifierLigne() {
				//insert dans la base
		String testnomL = daoligne.generateRandom();
		String testcommentL = daoligne.generateRandom();
		
		daoligne.createLigne(testnomL, testcommentL);
		
		String nouvNom = daoligne.generateRandom();
		String nouvComment = daoligne.generateRandom();	
				
		lg.setNomLigne(nouvNom);
		lg.setCommentaire(nouvComment);
		lg.setIdLigne(daoligne.derniereLigne(lg));
		daoligne.modifierLigne(lg);				
		assertNotSame(testnomL, lg.getNomLigne());
	}

}
