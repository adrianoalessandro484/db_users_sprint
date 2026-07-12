package com.users.db_users.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "clientes_medidas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClienteMedida {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cliente_id", nullable = false)
    private Long clienteId;

    @Column(length = 100)
    private String tipoPrenda;

    @Column(length = 50)
    private String genero;

    @Column(length = 50)
    private String espalda;

    @Column(length = 50)
    private String pecho;

    @Column(length = 50)
    private String cintura;

    @Column(length = 50)
    private String cadera;

    @Column(length = 50)
    private String largo;

    @Column(length = 50)
    private String manga;

    @Column(length = 50)
    private String hombro;

    @Column(length = 50)
    private String cuello;

    @Column(length = 50)
    private String brazo;

    @Column(length = 50)
    private String muneca;

    @Column(length = 50)
    private String pantalonLargo;

    @Column(length = 50)
    private String pantalonCintura;

    @Column(length = 50)
    private String pantalonCadera;

    @Column(length = 50)
    private String pantalonMuslo;

    @Column(length = 50)
    private String pantalonRodilla;

    @Column(length = 50)
    private String pantalonTobillo;

    @Column(columnDefinition = "text")
    private String notas;

    @Column(name = "created_at", nullable = false, updatable = false)
    @lombok.Builder.Default
    private LocalDateTime createdAt = LocalDateTime.now();
}