package dao;

import java.security.SecureRandom;
import java.util.List;
import java.util.Random;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import beans.Canton;
import beans.Ligne;
import beans.Station;

public class CantonDAO {
	
	private Session se = null;
	private List<Canton> listeCanton;
    private Canton canton;    
    
    public  void createCanton(String nomCanton , String commentaireCanton, Ligne ligne, Station station ) {	      
		 
		 se = HibernateUtils.getSession();
	     Transaction t = se.beginTransaction();
	     Canton canton = new Canton();	     
	     canton.setNomCanton(nomCanton);
	     canton.setCommentaireCanton(commentaireCanton);
	     canton.setLigne(ligne);
	     canton.setStation(station);
	     se.save(canton);		
	     t.commit();
	     se.close();
	}
    
    
	public List<Canton> listerCanton() {
    	se = HibernateUtils.getSession();
    	se.beginTransaction();  	 	
    	listeCanton = se.createQuery("from Canton").list();
    	
        return listeCanton;
    }
	
	public Canton getCantonByID(int id) {
    	se = HibernateUtils.getSession();
    	se.beginTransaction(); 
    	
    	canton = (Canton) se.createQuery("from Canton where idCanton="+id).uniqueResult();
    	 se.close();
    	
        return canton;
    }
    public void supprimerCanton(int id) {
    	
    	se = HibernateUtils.getSession();
    	se.beginTransaction();
        canton = (Canton) se.load(Canton.class, id);
        se.delete(canton);
        se.beginTransaction().commit();
        se.close();
    }
    
    public void modifierCanton(Canton Canton) {
  	  
    	se = HibernateUtils.getSession();       
    	Transaction tr=se.beginTransaction();
    	se.update(canton);
    	tr.commit();
    	se.close();
    	 
    }
    
	@SuppressWarnings("unchecked")
	public int dernierCanton(Canton c) {
	se = HibernateUtils.getSession();
	se.beginTransaction();
	 listeCanton = se.createQuery("from Canton").list();
	return listeCanton.get(listeCanton.size()-1).getIdCanton();
	}
      
	public boolean existCanton(Canton c) {
	se = HibernateUtils.getSession();
	se.beginTransaction();
		Query q = se.createQuery("select idCanton from Canton where nomCanton = :nom").setParameter("nom", c.getNomCanton());

		if(q == null){
				
				return false ;
				
			}
			else {
			
				return true ;				
				
			}
	}
	public  String generateRandom() {
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
