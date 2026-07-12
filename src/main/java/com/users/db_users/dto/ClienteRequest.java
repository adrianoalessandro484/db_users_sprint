package com.users.db_users.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClienteRequest {
    private String dni;
    private String nombre;
    private String telefonos;
}