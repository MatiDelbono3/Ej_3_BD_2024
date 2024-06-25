package org.example.entidades;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Posts")
public class Posts {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int Id;
@Column(name = "ID", nullable = false)
private String titulo;
@Column(name = "titulo", nullable = false)
private String contenido;
@Column(name = "titulo", nullable = false)
private Date FechaPublicacion;
@Column(name = "fecha_publicacion", nullable = false)
@OneToMany(mappedBy = "Post", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
 private List<Comentarios>Comentarios;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public Date getFechaPublicacion() {
        return FechaPublicacion;
    }

    public void setFechaPublicacion(Date fechaPublicacion) {
        FechaPublicacion = fechaPublicacion;
    }

    public List<org.example.entidades.Comentarios> getComentarios() {
        return Comentarios;
    }

    public void setComentarios(List<org.example.entidades.Comentarios> comentarios) {
        Comentarios = comentarios;
    }
}
