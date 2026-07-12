package com.users.db_users.service.impl;

import com.users.db_users.dto.ClienteMedidaRequest;
import com.users.db_users.dto.ClienteMedidaResponse;
import com.users.db_users.dto.ClienteRequest;
import com.users.db_users.dto.ClienteResponse;
import com.users.db_users.entity.Cliente;
import com.users.db_users.entity.ClienteMedida;
import com.users.db_users.repository.ClienteMedidaRepository;
import com.users.db_users.repository.ClienteRepository;
import com.users.db_users.service.ClienteService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;
    private final ClienteMedidaRepository medidaRepository;

    public ClienteServiceImpl(ClienteRepository clienteRepository,
                              ClienteMedidaRepository medidaRepository) {
        this.clienteRepository = clienteRepository;
        this.medidaRepository = medidaRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<ClienteResponse> findAll() {
        return clienteRepository.findAll().stream()
                .map(ClienteResponse::fromEntity)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public ClienteResponse findById(Long id) {
        Cliente c = clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado: " + id));
        return ClienteResponse.fromEntity(c);
    }

    @Override
    @Transactional
    public ClienteResponse create(ClienteRequest req) {
        if (clienteRepository.existsByDni(req.getDni())) {
            throw new RuntimeException("Ya existe un cliente con DNI " + req.getDni());
        }
        Cliente c = Cliente.builder()
                .dni(req.getDni())
                .nombre(req.getNombre() != null ? req.getNombre().toUpperCase() : "")
                .telefonos(req.getTelefonos())
                .build();
        return ClienteResponse.fromEntity(clienteRepository.save(c));
    }

    @Override
    @Transactional
    public ClienteResponse update(Long id, ClienteRequest req) {
        Cliente c = clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado: " + id));
        if (req.getNombre() != null) c.setNombre(req.getNombre().toUpperCase());
        if (req.getTelefonos() != null) c.setTelefonos(req.getTelefonos());
        return ClienteResponse.fromEntity(clienteRepository.save(c));
    }

    @Override
    @Transactional
    public void delete(Long id) {
        clienteRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ClienteMedidaResponse> findMedidasByCliente(Long clienteId) {
        return medidaRepository.findByClienteIdOrderByCreatedAtDesc(clienteId).stream()
                .map(ClienteMedidaResponse::fromEntity)
                .toList();
    }

    @Override
    @Transactional
    public ClienteMedidaResponse createMedida(ClienteMedidaRequest req) {
        if (!clienteRepository.existsById(req.getClienteId())) {
            throw new RuntimeException("Cliente no existe: " + req.getClienteId());
        }
        ClienteMedida m = ClienteMedida.builder()
                .clienteId(req.getClienteId())
                .tipoPrenda(req.getTipoPrenda())
                .genero(req.getGenero())
                .espalda(req.getEspalda())
                .pecho(req.getPecho())
                .cintura(req.getCintura())
                .cadera(req.getCadera())
                .largo(req.getLargo())
                .manga(req.getManga())
                .hombro(req.getHombro())
                .cuello(req.getCuello())
                .brazo(req.getBrazo())
                .muneca(req.getMuneca())
                .pantalonLargo(req.getPantalonLargo())
                .pantalonCintura(req.getPantalonCintura())
                .pantalonCadera(req.getPantalonCadera())
                .pantalonMuslo(req.getPantalonMuslo())
                .pantalonRodilla(req.getPantalonRodilla())
                .pantalonTobillo(req.getPantalonTobillo())
                .notas(req.getNotas())
                .build();
        return ClienteMedidaResponse.fromEntity(medidaRepository.save(m));
    }

    @Override
    @Transactional
    public void deleteMedida(Long medidaId) {
        medidaRepository.deleteById(medidaId);
    }
}