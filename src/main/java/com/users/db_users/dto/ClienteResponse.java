package com.users.db_users.dto;

import com.users.db_users.entity.Cliente;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClienteResponse {
    private Long id;
    private String dni;
    private String nombre;
    private String telefonos;
    private LocalDateTime createdAt;
    private List<TelefonoItem> telefonosList;

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class TelefonoItem {
        private String numero;
        private String tipo;
    }

    public static ClienteResponse fromEntity(Cliente c) {
        return ClienteResponse.builder()
                .id(c.getId())
                .dni(c.getDni())
                .nombre(c.getNombre())
                .telefonos(c.getTelefonos())
                .createdAt(c.getCreatedAt())
                .build();
    }
}