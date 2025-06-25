package com.opencode.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class Avaliacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    private TipoAvaliacao tipo;

    private LocalDateTime criadoEm = LocalDateTime.now();

    @ManyToOne
    @JoinColumn(name = "publicacao_id")
    private Publicacao publicacao;

    @ManyToOne
    @JoinColumn(name = "autor_id")
    private Usuario autor;
}