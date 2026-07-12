package com.users.db_users.config;

import com.users.db_users.entity.Profile;
import com.users.db_users.repository.ProfileRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SeedConfig {

    private static final Logger log = LoggerFactory.getLogger(SeedConfig.class);

    @Value("${app.seed.enabled:false}")
    private boolean seedEnabled;

    @Value("${SEED_ADMIN_EMAIL:admin@contreras.com}")
    private String adminEmail;

    @Value("${SEED_MAESTRO_EMAIL:maestro@contreras.com}")
    private String maestroEmail;

    @Value("${SEED_SASTRE_EMAIL:sastre@contreras.com}")
    private String sastreEmail;

    @Bean
    public CommandLineRunner seedProfiles(ProfileRepository repository) {
        return args -> {
            if (!seedEnabled) {
                return;
            }

            seedProfile(repository, adminEmail, "ADMINISTRADOR", "admin", "[\"ADMINISTRACION\"]", 1);
            seedProfile(repository, maestroEmail, "MAESTRO PRINCIPAL", "maestro", "[\"SACOS\",\"PANTALONES\"]", 5);
            seedProfile(repository, sastreEmail, "SASTRE DEMO", "sastre", "[\"SACOS\"]", 3);
        };
    }

    private void seedProfile(ProfileRepository repository, String email, String name,
                              String role, String especialidades, int cargaMax) {
        if (repository.findByEmail(email).isPresent()) {
            log.info("Seed: profile '{}' ya existe, se omite", email);
            return;
        }
        Profile p = Profile.builder()
                .email(email)
                .fullName(name)
                .role(role)
                .especialidades(especialidades)
                .cargaMax(cargaMax)
                .activo(true)
                .build();
        repository.save(p);
        log.info("Seed: profile '{}' creado (rol={})", email, role);
    }
}