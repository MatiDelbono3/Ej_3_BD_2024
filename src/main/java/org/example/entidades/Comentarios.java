package org.example.entidades;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Comentarios")
public class Comentarios {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int Id;
@Column (name = "Id", nullable = false)
private int PostId;
@Column (name ="PostId", nullable = false)
private  String Autor;
@Column (name ="Autor", nullable = false)
private  String Comentario;
@Column (name ="Comentario", nullable = false)
private Date FechaComentario;
@Column (name ="fecha_comentario", nullable = false)
@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "Post_Id")
private List<Posts>Posts;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getPostId() {
        return PostId;
    }

    public void setPostId(int postId) {
        PostId = postId;
    }

    public String getAutor() {
        return Autor;
    }

    public void setAutor(String autor) {
        Autor = autor;
    }

    public String getComentario() {
        return Comentario;
    }

    public void setComentario(String comentario) {
        Comentario = comentario;
    }

    public Date getFechaComentario() {
        return FechaComentario;
    }

    public void setFechaComentario(Date fechaComentario) {
        FechaComentario = fechaComentario;
    }

    public List<org.example.entidades.Posts> getPosts() {
        return Posts;
    }

    public void setPosts(List<org.example.entidades.Posts> posts) {
        Posts = posts;
    }
}
