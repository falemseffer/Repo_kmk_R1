package utils;

import java.util.*;
import org.hibernate.Session;
import org.hibernate.Transaction;

import beans.Station;

public class DAO_Station {
	 
	private static Session s = null;
	List<Station> l;
    private Station p;
   
   
	// Création d'une station
	public static void createStation(String a , String b ) {
	      System.out.println("---------Create ---------");
	      s = HibernateUtils.getSession();
	      // Création des objets à sauvegarder
	      Station e1 = new Station();
	      e1.setNameStation(a);
	      e1.setCommentStation(b);
	      s.save(e1);
		  s.persist(e1);
		  // Début de la transaction
	      s.beginTransaction().commit();
	      s.close();
	}
 
    //Suppression d'une station
    public void delete(int idst) {
    	s = HibernateUtils.getSession();
    	s.beginTransaction();
        p = (Station) s.load(Station.class, idst);
        s.delete(p);
        s.beginTransaction().commit();
        s.close();
    }
 
    //lister les stations
    @SuppressWarnings("unchecked")
	public List<Station> listst() {
    	s = HibernateUtils.getSession();
    	s.beginTransaction();
        l = s.createQuery("from Station").list();
      //  System.out.println(l.toString());     
        return l;
    }
    @SuppressWarnings("unchecked")
	public List<Station> valueStation(String value) {
    	s = HibernateUtils.getSession();
    	s.beginTransaction();
        l = s.createQuery("from Station where station_id ="+value.toString()).list();
       // System.out.println(l.toString());   
        return l;
    }
 
    public void Edit(Station e) {
  
    	s = HibernateUtils.getSession();       
    	Transaction tr=s.beginTransaction();
    	s.update(e);
    	tr.commit();
    	s.close();
    	 
    }
    
}