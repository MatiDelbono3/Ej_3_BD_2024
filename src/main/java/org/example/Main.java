package org.example;

import org.example.Servicios.ServiciosComentarios;
import org.example.Servicios.ServiciosPosts;
import org.example.conexiones.HibernateUtil;
import org.example.entidades.Comentarios;
import org.example.dto.Comentario;
import org.example.dto.Post;
import org.hibernate.Session;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Session session=HibernateUtil.getSession();
        if (session != null ){
            System.out.println("Conectado");
        }
        else{
            System.out.println("No Conectado");

    }
        ServiciosPosts serviciosPosts=new ServiciosPosts();
        Scanner scanner=new Scanner(System.in);
        ServiciosComentarios serviciosComentarios=new ServiciosComentarios();
        // Datos del post
        System.out.println("Ingrese el ID del post");
        int Id = scanner.nextInt();
        System.out.println("Ingrese el titulo del post");
        String Titulo = scanner.nextLine();
        System.out.println("Ingrese el Contenido del post");
        String Contenido = scanner.nextLine();
        System.out.println("Ingrese la fecha de publicacion del post");
        Date FechaPublicacion = new Date();


        // Datos del Comentario
        System.out.println("Ingrese el ID del Comentario");
        int IdComentario = scanner.nextInt();
        System.out.println("Ingrese el Id del Post comentado");
        int IdPost = scanner.nextInt();
        System.out.println("Ingrese el nombre del autor");
        String Autor = scanner.nextLine();
        System.out.println("Ingrese el contenido del comentario");
        String Comentario=scanner.nextLine();
        System.out.println("Ingrese la fecha del comentario");
        Date FechaComentario=new Date();

        while (Id !=0 ) {
            // Obtener comentarios de un Post
            List<Comentario>ObtenerComentariosDeUnPost=serviciosComentarios.ObtenerComentariosDeUnPost(IdPost);
            ObtenerComentariosDeUnPost.forEach(comentario -> System.out.println(comentario.getId()));
            ObtenerComentariosDeUnPost.forEach(comentario -> System.out.println(comentario.getPostId()));
            ObtenerComentariosDeUnPost.forEach(comentario -> System.out.println(comentario.getAutor()));
            ObtenerComentariosDeUnPost.forEach(comentario -> System.out.println(comentario.getComentario()));
            ObtenerComentariosDeUnPost.forEach(comentario -> System.out.println(comentario.getFechaComentario()));

            // Obtener Comentarios de cada post
            List<Object>ObtenerNroComentariosDeCadaPost=serviciosComentarios.ObtenerNroComentariosCadaPost();

            //Obtener Post Sin comentario
            List<Post>ObtenerPostsSinComentario=serviciosPosts.RetornarPostsSinComentarios();
            ObtenerPostsSinComentario.forEach(post -> System.out.println(post.getID()));
            ObtenerPostsSinComentario.forEach(post -> System.out.println(post.getTitulo()));
            ObtenerPostsSinComentario.forEach(post -> System.out.println(post.getContenido()));
            ObtenerPostsSinComentario.forEach(post -> System.out.println(post.getFechaPublicacion()));

            // Datos del post
            System.out.println("Ingrese el ID del post");
            Id = scanner.nextInt();

        }
    }

}