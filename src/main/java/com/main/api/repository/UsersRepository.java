package com.main.api.repository;

import com.main.api.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UsersRepository extends JpaRepository<Users, UUID> {
    Optional<Users> findByToken(String token);

    Optional<Users> findByNameAndPassword(String name, String password);
}
