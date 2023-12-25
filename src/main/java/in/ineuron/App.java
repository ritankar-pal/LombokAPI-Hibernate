package in.ineuron;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import in.ineuron.beans.Student;
import in.ineuron.util.HibernateUtil;




public class App 
{	
	
	private static Logger logger = Logger.getLogger(App.class);
			
	public static void main( String[] args ){
		
		logger.debug("Control Entered Main Method...");
		
    	Session session = null;
    	int id = 1;
    	Student student = null;
    	
    	try {
    		
    		session = HibernateUtil.getSession();
    		
    		logger.info("Session Object Created Successfully...");
    		
    		if(session != null) {
				student = session.get(Student.class, id);
			}
    		
    		if(student != null) {
    			System.out.println(student);
    			logger.info(student);
    		}
    		else {
    			logger.info("Record Not Found for the given id: " + id);
    			System.out.println("Record Not Found for the given id: " + id);
    		}
    			
    	}
    	catch(HibernateException he) {
    		logger.error(he);
    	}
    	catch(Exception e) {
    		logger.fatal(e);
    	}
    	finally {
    		HibernateUtil.closeSession(session);
    		HibernateUtil.closeSessionFactory();
    		
    		logger.info("All Resources are closed...");
    	}
    	
    	logger.debug("End of Main Method...");    	
    }
}
