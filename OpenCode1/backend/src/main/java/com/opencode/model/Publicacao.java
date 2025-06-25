package com.opencode.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
public class Publicacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String titulo;

    @Column(columnDefinition = "TEXT")
    private String descricao;

    @Enumerated(EnumType.STRING)
    private TipoPublicacao tipo;

    private LocalDateTime criadoEm = LocalDateTime.now();

    @ManyToOne
    @JoinColumn(name = "autor_id")
    private Usuario autor;

    @OneToMany(mappedBy = "publicacao", cascade = CascadeType.ALL)
    private List<Comentario> comentarios;

    @OneToMany(mappedBy = "publicacao", cascade = CascadeType.ALL)
    private List<Midia> midias;

    @OneToMany(mappedBy = "publicacao", cascade = CascadeType.ALL)
    private List<Avaliacao> avaliacoes;
}