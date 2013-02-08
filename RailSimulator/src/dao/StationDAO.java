package dao;

import java.security.SecureRandom;
import java.util.List;
import java.util.Random;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import beans.Station;

public class StationDAO {

	private Session se = null;
	private List<Station> listeStation;
	private Station station = new Station();


	public void createStation(String nomStation, String commentaireStation) {
		// TODO Auto-generated method stub
		 se = HibernateUtils.getSession();
	     Transaction t = se.beginTransaction();
	     station.setNomStation(nomStation);
	     station.setCommentaireStation(commentaireStation);
	     station.setIdStation(station.getIdStation());
	     se.save(station);
	     t.commit();
	     se.close();
	}
 
    
    public void supprimerStation(int id) {
    	
    	se = HibernateUtils.getSession();
    	se.beginTransaction();
        station = (Station) se.load(Station.class, id);
        se.delete(station);
        se.beginTransaction().commit();
        se.close();
    }
    
	public Station getStationByID(int id) {
    	se = HibernateUtils.getSession();
    	se.beginTransaction();   	
    	station = (Station) se.createQuery("from Station where idStation="+id).uniqueResult();
    	System.out.println(station.getNomStation());
    	se.close();
        return station;
    }
	
    public void modifierStation(Station station) {
  	  
    	se = HibernateUtils.getSession();       
    	Transaction tr=se.beginTransaction();
    	se.update(station);
    	tr.commit();
    	//se.close();
    	 
    }
    
	@SuppressWarnings("unchecked")
	public List<Station> listerStation() {
    	se = HibernateUtils.getSession();
    	se.beginTransaction();  	 	
    	listeStation = se.createQuery("from Station").list();   	
        return listeStation;
    }
    
	@SuppressWarnings("unchecked")
	public int derniereStation() {
	se = HibernateUtils.getSession();
	se.beginTransaction();
	listeStation = se.createQuery("from Station").list();
	return listeStation.get(listeStation.size()-1).getIdStation();
	
	}

	public boolean existStation(Station st) {
		se = HibernateUtils.getSession();
		se.beginTransaction();
			Query q = se.createQuery("select idStation from Station where nomStation = :nom").setParameter("nom", st.getNomStation());
			//Query q = se.createQuery("select idStation from Station where idStation = :id").setParameter("id", stid);

			if(q == null){
				System.out.println("false");
				return false ;
				
			}
			else {
				System.out.println("true");
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
