package com.users.db_users.controller;

import com.users.db_users.dto.ClienteMedidaRequest;
import com.users.db_users.dto.ClienteMedidaResponse;
import com.users.db_users.dto.ClienteRequest;
import com.users.db_users.dto.ClienteResponse;
import com.users.db_users.service.ClienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/profiles/clientes")
@CrossOrigin(origins = "*")
public class ClienteController {

    private final ClienteService service;

    public ClienteController(ClienteService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<ClienteResponse>> list() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<ClienteResponse> create(@RequestBody ClienteRequest req) {
        return ResponseEntity.ok(service.create(req));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteResponse> update(@PathVariable Long id,
                                                  @RequestBody ClienteRequest req) {
        return ResponseEntity.ok(service.update(id, req));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}/medidas")
    public ResponseEntity<List<ClienteMedidaResponse>> medidas(@PathVariable Long id) {
        return ResponseEntity.ok(service.findMedidasByCliente(id));
    }

    @PostMapping("/medidas")
    public ResponseEntity<ClienteMedidaResponse> crearMedida(@RequestBody ClienteMedidaRequest req) {
        return ResponseEntity.ok(service.createMedida(req));
    }

    @DeleteMapping("/medidas/{medidaId}")
    public ResponseEntity<Void> eliminarMedida(@PathVariable Long medidaId) {
        service.deleteMedida(medidaId);
        return ResponseEntity.noContent().build();
    }
}