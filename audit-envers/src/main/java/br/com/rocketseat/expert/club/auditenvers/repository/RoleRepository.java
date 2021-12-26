package br.com.rocketseat.expert.club.auditenvers.repository;

import java.util.Optional;

import br.com.rocketseat.expert.club.auditenvers.entity.ERole;
import br.com.rocketseat.expert.club.auditenvers.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}