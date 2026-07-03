package com.users.db_users.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProfileRequest {
    private String email;
    private String fullName;
    private String role;
    private String especialidades;
    private Integer cargaMax;
    private Boolean activo;
}