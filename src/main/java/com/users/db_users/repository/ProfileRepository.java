package com.users.db_users.repository;

import com.users.db_users.entity.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, UUID> {
    List<Profile> findAllByOrderByFullNameAsc();
    List<Profile> findByRole(String role);
    Optional<Profile> findByEmail(String email);
}