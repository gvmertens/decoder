package br.com.mertens.ead.authuser.repositories;

import br.com.mertens.ead.authuser.enums.RoleType;
import br.com.mertens.ead.authuser.models.RoleModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface RoleRepository extends JpaRepository<RoleModel, UUID> {
    Optional<RoleModel> findByRoleName(RoleType name);
}