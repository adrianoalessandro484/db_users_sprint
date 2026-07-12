package com.users.db_users.service;

import com.users.db_users.dto.ClienteMedidaRequest;
import com.users.db_users.dto.ClienteMedidaResponse;
import com.users.db_users.dto.ClienteRequest;
import com.users.db_users.dto.ClienteResponse;

import java.util.List;

public interface ClienteService {
    List<ClienteResponse> findAll();
    ClienteResponse findById(Long id);
    ClienteResponse create(ClienteRequest req);
    ClienteResponse update(Long id, ClienteRequest req);
    void delete(Long id);

    List<ClienteMedidaResponse> findMedidasByCliente(Long clienteId);
    ClienteMedidaResponse createMedida(ClienteMedidaRequest req);
    void deleteMedida(Long medidaId);
}