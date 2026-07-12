package com.users.db_users.dto;

import com.users.db_users.entity.ClienteMedida;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClienteMedidaResponse {
    private Long id;
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
    private LocalDateTime createdAt;

    public static ClienteMedidaResponse fromEntity(ClienteMedida m) {
        return ClienteMedidaResponse.builder()
                .id(m.getId())
                .clienteId(m.getClienteId())
                .tipoPrenda(m.getTipoPrenda())
                .genero(m.getGenero())
                .espalda(m.getEspalda())
                .pecho(m.getPecho())
                .cintura(m.getCintura())
                .cadera(m.getCadera())
                .largo(m.getLargo())
                .manga(m.getManga())
                .hombro(m.getHombro())
                .cuello(m.getCuello())
                .brazo(m.getBrazo())
                .muneca(m.getMuneca())
                .pantalonLargo(m.getPantalonLargo())
                .pantalonCintura(m.getPantalonCintura())
                .pantalonCadera(m.getPantalonCadera())
                .pantalonMuslo(m.getPantalonMuslo())
                .pantalonRodilla(m.getPantalonRodilla())
                .pantalonTobillo(m.getPantalonTobillo())
                .notas(m.getNotas())
                .createdAt(m.getCreatedAt())
                .build();
    }
}