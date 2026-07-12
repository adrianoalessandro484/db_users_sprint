package com.users.db_users.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClienteMedidaRequest {
    private Long clienteId;
    private String tipoPrenda;
    private String genero;
    private String espalda;
    private String pecho;
    private String cintura;
    private String cadera;
    private String largo;
    private String manga;
    private String hombro;
    private String cuello;
    private String brazo;
    private String muneca;
    private String pantalonLargo;
    private String pantalonCintura;
    private String pantalonCadera;
    private String pantalonMuslo;
    private String pantalonRodilla;
    private String pantalonTobillo;
    private String notas;
}