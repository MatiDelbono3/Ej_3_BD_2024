package org.example.Servicios;

import org.example.conexiones.HibernateUtil;
import org.example.dto.Comentario;
import org.example.dto.Post;
import org.example.entidades.Comentarios;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class ServiciosComentarios {

    public void InsertarComentarioAUnPost(int PostId, String Comentario) {
        Transaction transaction=null;
        try (Session session= HibernateUtil.getSession().getSessionFactory().openSession()){
            transaction= session.beginTransaction();
            Post post=session.get(Post.class, PostId);
            if (post!=null) {
            Comentario comentario=new Comentario();
            comentario.setPostId(PostId);
            comentario.setComentario(String.valueOf(comentario));
            // Guardar nuevo comentario
            session.save(comentario);
            // Confirmar la transacción
            session.getTransaction().commit();
            System.out.println("Comentario agregado con éxito");
        }
        else  {
                System.out.println("Comentario no hallado");
            }
    }
}
public List<Comentario>ObtenerComentariosDeUnPost(int PostId) {
        Transaction transaction=null;
        List<Comentario>ComentariosDeUnPost=new ArrayList<>();
        try(Session session=HibernateUtil.getSession().getSessionFactory().openSession()) {
            transaction= session.beginTransaction();
            String Sql="FROM POSTS where Post.Id = : PostId";
            ComentariosDeUnPost= session.createQuery(Sql, Comentario.class)
                    .setParameter("postId", PostId)
                    .getResultList();
            transaction.commit();

        }catch (Exception exception) {
            if (transaction != null) {
                transaction.rollback();
            }
            exception.printStackTrace();
        }
        finally {
           
        }
        return ComentariosDeUnPost;
}
}
