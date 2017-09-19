package forum.hiber;

import org.hibernate.HibernateException;  
import org.hibernate.Session;  
import org.hibernate.SessionFactory;  
import org.hibernate.Transaction;  
import org.hibernate.cfg.Configuration;  
  
public class HibernateUtil {  
    private static SessionFactory sessionFactory;  
    public static final ThreadLocal<Session> session = new ThreadLocal<Session>();  
      
    static {      
        try {  
            sessionFactory = new Configuration().configure().buildSessionFactory();  
        } catch (Throwable ex) {  
            throw new ExceptionInInitializerError(ex);  
        }  
    }  
      
    /*  
     * ��õ�ǰsession  
     */  
    public static Session getSession() throws HibernateException {  
        Session s = (Session) session.get();  
        if(s ==null || !s.isOpen()){  
            s = sessionFactory.openSession();  
            session.set(s);  
        }  
        return s;     
    }  
      
    /*  
     * �ع�  
     */  
    public static void rollback(Transaction tx) {  
        try {  
            if(tx != null) {  
                tx.rollback();  
            }  
        } catch (HibernateException e) {  
            System.out.println("rollback faild." + e);  
        }  
    }  
      
    /*  
     * �ر�session  
     */  
    public static void closeSession() throws HibernateException {  
        Session s = session.get();  
        session.set(null);  
        if(s != null) {  
            s.close();  
        }  
    }  
      
}  