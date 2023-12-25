package in.ineuron.util;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import in.ineuron.beans.Student;


public class HibernateUtil {
	
	private static Session session = null;
	private static SessionFactory sessionFactory = null;
	
	
	static {
		sessionFactory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();
	}
	
	public static Session getSession() {
		if(sessionFactory != null) {
			session = sessionFactory.openSession();
		}
		
		return session;
	}
	
	public static void closeSession(Session session) {
		if(session != null)
			session.close();
	}
	
	public static void closeSessionFactory() {
		if(sessionFactory != null)
			sessionFactory.close();
	}
}
