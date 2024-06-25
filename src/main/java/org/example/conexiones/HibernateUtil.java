package org.example.conexiones;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
public class HibernateUtil {
    private static final SessionFactory sessionfactory;
    static {
        try {
            Configuration configuration=new Configuration().configure();
            sessionfactory=configuration.buildSessionFactory();
        } catch (Exception exception){
            throw new RuntimeException("No se ha podido iniciar sesión de HibernateUtil");
        }
    }
public static Session getSession() {
        return sessionfactory.openSession();
    }
}
