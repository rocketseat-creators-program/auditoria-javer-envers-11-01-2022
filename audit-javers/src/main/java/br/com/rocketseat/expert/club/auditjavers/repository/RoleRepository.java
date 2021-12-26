package br.com.rocketseat.expert.club.auditjavers.repository;

import java.util.Optional;

import br.com.rocketseat.expert.club.auditjavers.entity.ERole;
import br.com.rocketseat.expert.club.auditjavers.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}