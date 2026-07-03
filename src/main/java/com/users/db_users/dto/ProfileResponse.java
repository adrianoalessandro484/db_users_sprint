package com.users.db_users.dto;

import com.users.db_users.entity.Profile;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProfileResponse {
    private UUID id;
    private String email;
    private String fullName;
    private String role;
    private String especialidades;
    private Integer cargaMax;
    private Boolean activo;
    private LocalDateTime createdAt;

    public static ProfileResponse fromEntity(Profile p) {
        return ProfileResponse.builder()
                .id(p.getId())
                .email(p.getEmail())
                .fullName(p.getFullName())
                .role(p.getRole())
                .especialidades(p.getEspecialidades())
                .cargaMax(p.getCargaMax())
                .activo(p.getActivo())
                .createdAt(p.getCreatedAt())
                .build();
    }
}