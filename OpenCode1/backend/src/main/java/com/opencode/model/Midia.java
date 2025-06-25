package com.opencode.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Midia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String caminhoArquivo;

    @Enumerated(EnumType.STRING)
    private TipoMidia tipoMidia;

    @ManyToOne
    @JoinColumn(name = "publicacao_id")
    private Publicacao publicacao;
}