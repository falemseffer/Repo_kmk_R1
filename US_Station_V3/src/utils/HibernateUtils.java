package utils;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class HibernateUtils {
	public HibernateUtils() {
		// TODO Auto-generated constructor stub
	}
	private static final SessionFactory sessionFactory;

	// Crée une unique instance de la SessionFactory  partir de hibernate.cfg.xml
	static {
		try {
			System.out.println("--------------Ouvrir Session-----------------");
			sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
			System.out.println("--------------Fin de session------------");
		} catch (HibernateException ex) {
			throw new RuntimeException("Probleme de configuration : " + ex.getMessage(), ex);
		}
	}

	// Renvoie une session Hibernate
	public static Session getSession() throws HibernateException {
		return sessionFactory.openSession();
	}
}
