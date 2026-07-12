package com.users.db_users.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "clientes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 20)
    private String dni;

    @Column(nullable = false, length = 200)
    private String nombre;

    @Column(length = 500)
    private String telefonos;

    @Column(name = "created_at", nullable = false, updatable = false)
    @lombok.Builder.Default
    private LocalDateTime createdAt = LocalDateTime.now();
}