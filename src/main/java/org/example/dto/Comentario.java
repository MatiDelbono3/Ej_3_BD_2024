package org.example.dto;

import java.util.Date;

public class Comentario {
    private int Id;
    private int PostId;
    private String Autor;
    private String Comentario;
    private Date FechaComentario;

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
}
