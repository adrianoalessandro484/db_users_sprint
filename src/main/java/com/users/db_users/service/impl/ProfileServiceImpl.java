package com.users.db_users.service.impl;

import com.users.db_users.dto.ProfileRequest;
import com.users.db_users.dto.ProfileResponse;
import com.users.db_users.entity.Profile;
import com.users.db_users.repository.ProfileRepository;
import com.users.db_users.service.ProfileService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class ProfileServiceImpl implements ProfileService {

    private final ProfileRepository repository;

    public ProfileServiceImpl(ProfileRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProfileResponse> findAll() {
        return repository.findAllByOrderByFullNameAsc().stream()
                .map(ProfileResponse::fromEntity)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProfileResponse> findByRole(String role) {
        return repository.findByRole(role).stream()
                .map(ProfileResponse::fromEntity)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public ProfileResponse findById(UUID id) {
        Profile p = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Profile no encontrado: " + id));
        return ProfileResponse.fromEntity(p);
    }

    @Override
    @Transactional
    public ProfileResponse create(ProfileRequest req) {
        Profile p = Profile.builder()
                .email(req.getEmail())
                .fullName(req.getFullName() != null ? req.getFullName().toUpperCase() : "")
                .role(req.getRole() != null ? req.getRole() : "trabajador")
                .especialidades(req.getEspecialidades())
                .cargaMax(req.getCargaMax() != null ? req.getCargaMax() : 5)
                .activo(req.getActivo() != null ? req.getActivo() : true)
                .build();
        return ProfileResponse.fromEntity(repository.save(p));
    }

    @Override
    @Transactional
    public ProfileResponse update(UUID id, ProfileRequest req) {
        Profile p = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Profile no encontrado: " + id));
        if (req.getFullName() != null) p.setFullName(req.getFullName().toUpperCase());
        if (req.getRole() != null) p.setRole(req.getRole());
        if (req.getEspecialidades() != null) p.setEspecialidades(req.getEspecialidades());
        if (req.getCargaMax() != null) p.setCargaMax(req.getCargaMax());
        if (req.getActivo() != null) p.setActivo(req.getActivo());
        return ProfileResponse.fromEntity(repository.save(p));
    }

    @Override
    @Transactional
    public void delete(UUID id) {
        repository.deleteById(id);
    }
}