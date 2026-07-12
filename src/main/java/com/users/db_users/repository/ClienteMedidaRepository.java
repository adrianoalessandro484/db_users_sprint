package com.users.db_users.repository;

import com.users.db_users.entity.ClienteMedida;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClienteMedidaRepository extends JpaRepository<ClienteMedida, Long> {
    List<ClienteMedida> findByClienteIdOrderByCreatedAtDesc(Long clienteId);
}