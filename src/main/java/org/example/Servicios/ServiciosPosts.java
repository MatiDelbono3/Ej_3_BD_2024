package org.example.Servicios;

import org.example.conexiones.HibernateUtil;
import org.example.dto.Post;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class ServiciosPosts {
    public List<Post> RetornarPostsSinComentarios() {
        Transaction transaction=null;
        List<Post>PostsSinComentarios=new ArrayList<>();
        try(Session session= HibernateUtil.getSession().getSessionFactory().openSession()) {
            transaction= session.beginTransaction();
            String Sql3="FROM Posts g WHERE g.comentarios IS EMPTY ORDER BY g.fecha_publicacion DESC";
            PostsSinComentarios=  session.createQuery(Sql3, Post.class).getResultList();
            transaction.commit();
        } catch (Exception exception){
            if (transaction != null){
                transaction.rollback();
            }
        }
        return PostsSinComentarios;
    }
}
