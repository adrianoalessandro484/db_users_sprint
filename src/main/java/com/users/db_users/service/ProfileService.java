package com.users.db_users.service;

import com.users.db_users.dto.ProfileRequest;
import com.users.db_users.dto.ProfileResponse;

import java.util.List;
import java.util.UUID;

public interface ProfileService {
    List<ProfileResponse> findAll();
    List<ProfileResponse> findByRole(String role);
    ProfileResponse findById(UUID id);
    ProfileResponse create(ProfileRequest req);
    ProfileResponse update(UUID id, ProfileRequest req);
    void delete(UUID id);
}