package com.pradipta.reportsuspect.auth.models.role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleService {
    @Autowired
    private RoleRepository repository;

    public Optional<Role> getRole(Long id) {
        return repository.findById(id);
    }
}
