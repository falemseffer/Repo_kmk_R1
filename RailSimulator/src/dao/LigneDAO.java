package dao;

import java.security.SecureRandom;
import java.util.*;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import beans.Ligne;

public class LigneDAO {	
	
	private Session se = null;
	private List<Ligne> listeLigne;
    private Ligne ligne;
    
    
	public  void createLigne(String nomLigne , String commentaireLigne ) {
	      
		 
		se = HibernateUtils.getSession();
	     Transaction t = se.beginTransaction();
	     Ligne ligne = new Ligne();
	     ligne.setNomLigne(nomLigne);
	     ligne.setCommentaire(commentaireLigne);
	     se.save(ligne);		
	     t.commit();
	     se.close();
	}
	
	
	public List<Ligne> listerLigne() {
    	se = HibernateUtils.getSession();
    	se.beginTransaction();  	 	
    	listeLigne = se.createQuery("from Ligne").list();    	
        return listeLigne;
    }
	
	public Ligne getLigneByID(int id) {
    	se = HibernateUtils.getSession();
    	se.beginTransaction(); 
    	
    	ligne = (Ligne) se.createQuery("from Ligne where idLigne="+id).uniqueResult();
    	 se.close();
    	
        return ligne;
    }
 
   
    public void supprimerLigne(int id) {
    	
    	se = HibernateUtils.getSession();
    	se.beginTransaction();
        ligne = (Ligne) se.load(Ligne.class, id);
        se.delete(ligne);
        se.beginTransaction().commit();
        se.close();
    }
    
    public void modifierLigne(Ligne ligne) {
    	  
    	se = HibernateUtils.getSession();       
    	Transaction tr=se.beginTransaction();
    	se.update(ligne);
    	tr.commit();
    	se.close();
    	 
    }
    

	@SuppressWarnings("unchecked")
	public int derniereLigne(Ligne l) {
	se = HibernateUtils.getSession();
	se.beginTransaction();
	 listeLigne = se.createQuery("from Ligne").list();
	//return listeStation.get(3).getIdStation() ;
	return listeLigne.get(listeLigne.size()-1).getIdLigne();
	//return (q.uniqueResult() != null);
	}
    
	public boolean existLigne(Ligne l) {
	se = HibernateUtils.getSession();
	se.beginTransaction();
		Query q = se.createQuery("select idLigne from Ligne where nomLigne = :nom").setParameter("nom", l.getNomLigne());
		if(q == null){
			
			return false ;
			
		}
		else {
		
			return true ;				
			
		}
	}
	
	public  String generateRandom()
	  {
		     Random rd = new SecureRandom();
	      
	      String letters = "abcdefghjkmnpqrstuvwxyzABCDEFGHJKMNPQRSTUVWXYZ23456789+@";

	      String pw = "";
	      for (int i=0; i<8; i++)
	      {
	          int index = (int)(rd.nextDouble()*letters.length());
	          pw += letters.substring(index, index+1);
	      }
	      return pw;
	  }
	
	
}